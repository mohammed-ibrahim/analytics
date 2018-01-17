package org.tools.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.tools.csv.entity.CsvSortSettings;
import org.tools.csv.entity.OperationStatus;
import org.tools.csv.utils.Constants;
import org.tools.csv.utils.StatUtils;
import org.tools.csv.utils.Utility;

public class CsvMergeSorter {

    public OperationStatus sort(
            String inputFileName,
            String outputFileName,
            CsvSortSettings csvSortSettings,
            Boolean deleteSourceFile,
            String fileSortDirectory) throws Exception {

        Path inputFile = Paths.get(inputFileName);

        if (!inputFile.toFile().exists()) {
            throw new FileNotFoundException(inputFileName.toString());
        }

        if (inputFile.toFile().length() <= StatUtils.getSafeBlockSize()) {

            CsvBlockSorter csvBlockSorter = new CsvBlockSorter();
            return csvBlockSorter.sort(inputFileName, outputFileName, csvSortSettings, deleteSourceFile);
        }

        String tempDirectory = (fileSortDirectory == null) ? System.getProperty("java.io.tmpdir") : fileSortDirectory;
        String tag = Utility.generateTag();
        Path fileSortRootDir = Paths.get(tempDirectory, tag);

        if (!fileSortRootDir.toFile().exists()) {
            fileSortRootDir.toFile().mkdirs();
        }

        //call splitter
        Path splitDirectory = Paths.get(fileSortRootDir.toString(), Constants.SPLIT_FILE_DIR_NAME);
        FileSplitter fileSplitter = new FileSplitter();
        List<File> files = fileSplitter.splitFile(inputFileName, splitDirectory.toString(), StatUtils.getSafeBlockSize().intValue(), true);
        CsvMerger csvMerger = new CsvMerger();
        csvMerger.merge(files, outputFileName);

        //call merger
        return OperationStatus.success();
    }
}
