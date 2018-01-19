package org.tools.csv.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.tools.csv.entity.CsvSortSettings;
import org.tools.csv.entity.OperationStatus;
import org.tools.csv.utils.Constants;
import org.tools.csv.utils.FileSplitter;
import org.tools.csv.utils.StatUtils;
import org.tools.csv.utils.Utility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsvMergeSorter {

    public OperationStatus sort(
            Path inputFilePath,
            Path outputFilePath,
            CsvSortSettings csvSortSettings,
            Boolean deleteSourceFile,
            String fileSortDirectory) throws Exception {

        if (!inputFilePath.toFile().exists()) {
            throw new FileNotFoundException(inputFilePath.toString());
        }

        if (inputFilePath.toFile().length() <= StatUtils.getSafeBlockSize()) {

            CsvBlockSorter csvBlockSorter = new CsvBlockSorter();
            return csvBlockSorter.sort(inputFilePath, outputFilePath, csvSortSettings, deleteSourceFile);
        }

        String tempDirectory = (fileSortDirectory == null) ? System.getProperty("java.io.tmpdir") : fileSortDirectory;
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

        String[] columnNames = Utility.getColumnNamesOfCsv(inputFilePath, csvSortSettings);
        log.info("Splitting....");
        FileSplitter fileSplitter = new FileSplitter();
        List<File> files = fileSplitter.splitFile(inputFilePath, dropDirectory, StatUtils.getManagableSizeInMb().intValue(), true);
        log.info("Total files splitted: {}", files.size());

        log.info("Sorting....");
        InitialSorter initialSorter = new InitialSorter();
        List<File> initialSortedFiles = initialSorter.sortIndividualFiles(files, csvSortSettings, deleteSourceFile);
        log.info("Total files sorted: {}", initialSortedFiles.size());

        log.info("Merging....");
        CsvMerger csvMerger = new CsvMerger();
        csvMerger.merge(initialSortedFiles, outputFilePath, columnNames, csvSortSettings, deleteSourceFile);

        return OperationStatus.success();
    }

    public static void main(String[] args) throws Exception {

        if (args.length != 3) {
            System.out.println("Usage: java -cp jar_file.jar org.tools.csv.CsvMergeSorter <input_csv> <output_csv> sort_col1,sort_col2,sort_col3");
            System.exit(1);
        }

        CsvSortSettings csvSortSettings = new CsvSortSettings();
        csvSortSettings.setSortColumnOrder(new ArrayList<Integer>());
        csvSortSettings.setHasColumnNames(true);
        for (String columIndex : args[2].split(",")) {
            csvSortSettings.getSortColumnOrder().add(Integer.parseInt(columIndex));
        }

        CsvMergeSorter csvMergeSorter = new CsvMergeSorter();
        csvMergeSorter.sort(Paths.get(args[0]), Paths.get(args[1]), csvSortSettings, false, null);
    }
}
