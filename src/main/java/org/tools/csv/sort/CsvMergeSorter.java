package org.tools.csv.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.tools.csv.entity.CsvSortSettings;
import org.tools.csv.entity.OperationStatus;
import org.tools.csv.utils.Constants;
import org.tools.csv.utils.FileSplitter;
import org.tools.csv.utils.StatUtils;
import org.tools.csv.utils.Utility;
import org.tools.csv.validation.CsvSortCliHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsvMergeSorter {

    public OperationStatus sort(
            Path inputFilePath,
            Path outputFilePath,
            CsvSortSettings csvSortSettings,
            Boolean deleteSourceFile,
            Path tempDumpDirectory) throws Exception {

        if (!inputFilePath.toFile().exists()) {
            throw new FileNotFoundException(inputFilePath.toString());
        }

        if (inputFilePath.toFile().length() <= StatUtils.getSafeBlockSize()) {

            CsvBlockSorter csvBlockSorter = new CsvBlockSorter();
            return csvBlockSorter.sort(inputFilePath, outputFilePath, csvSortSettings, deleteSourceFile);
        }

        String tempDirectory = (tempDumpDirectory == null) ? System.getProperty("java.io.tmpdir") : tempDumpDirectory.toString();
        String tag = Utility.generateTag();
        Path fileSortRootDir = Paths.get(tempDirectory, tag);

        if (!fileSortRootDir.toFile().exists()) {
            fileSortRootDir.toFile().mkdirs();
        }

        //call splitter

        Path dropDirectory = Paths.get(fileSortRootDir.toString(), Constants.DROP_DIR_NAME);

        if (!dropDirectory.toFile().exists()) {
            dropDirectory.toFile().mkdirs();
        }

        String[] columnNames = null;
        if (csvSortSettings.getHasColumnNames()) {
            columnNames = Utility.getColumnNamesOfCsv(inputFilePath);
        }

        log.info("Splitting....");
        FileSplitter fileSplitter = new FileSplitter();
        List<File> files = fileSplitter.splitFile(inputFilePath, dropDirectory, StatUtils.getManagableSizeInMb().intValue(), csvSortSettings.getHasColumnNames());
        log.info("Total files splitted: {}", files.size());

        log.info("Sorting....");
        InitialSorter initialSorter = new InitialSorter();
        List<File> initialSortedFiles = initialSorter.sortIndividualFiles(files, csvSortSettings, deleteSourceFile);
        log.info("Total files sorted: {}", initialSortedFiles.size());

        log.info("Merging....");
        CsvMerger csvMerger = new CsvMerger();
        csvMerger.merge(initialSortedFiles, outputFilePath, columnNames, csvSortSettings, deleteSourceFile);

        if (deleteSourceFile) {
            inputFilePath.toFile().delete();
        }

        return OperationStatus.success();
    }

    public static void main(String[] args) throws Exception {

        CsvSortCliHandler csvSortCliHandler = new CsvSortCliHandler();
        csvSortCliHandler.validate(args);

        //log.info("Parsed columns: {}", csvSortCliHandler.getCsvSortSettings().getSortColumnOrder().toString());
        //System.exit(0);
        CsvMergeSorter csvMergeSorter = new CsvMergeSorter();
        csvMergeSorter.sort(csvSortCliHandler.getInputFilePath(),
                csvSortCliHandler.getOutputFilePath(),
                csvSortCliHandler.getCsvSortSettings(),
                csvSortCliHandler.getDeleteSourceFile(),
                csvSortCliHandler.getTempDumpDirectory());
    }
}
