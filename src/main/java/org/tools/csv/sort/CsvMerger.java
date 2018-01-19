package org.tools.csv.sort;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.tools.csv.entity.CsvSortSettings;
import org.tools.csv.entity.OperationStatus;
import org.tools.csv.utils.FileAppender;

import au.com.bytecode.opencsv.CSVWriter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsvMerger {

    private static final int NUM_THREADS = 2;

    private Boolean hasFailed = false;

    public OperationStatus merge(
            List<File> files,
            Path outputFilePath,
            String[] columnNames,
            CsvSortSettings csvSortSettings,
            Boolean deleteSourceFile) throws Exception {

        List<File> filesToMergeSort = files;
        Integer iterationNumber = 1;

        while (filesToMergeSort.size() > 1) {
            filesToMergeSort = serialMerge(filesToMergeSort, iterationNumber, csvSortSettings, deleteSourceFile);
            iterationNumber = iterationNumber + 1;
        }

        if (filesToMergeSort.size() != 1) {
            log.error("Something has gone wrong!! Seriously wrong");
            return OperationStatus.failure();
        }

        //Path outputPath = Paths.get(outputFileName);
        if (outputFilePath.toFile().exists()) {
            outputFilePath.toFile().delete();
        }

        File sortedFile = filesToMergeSort.get(0);
        if (columnNames != null) {
            CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath.toFile()));
            writer.writeNext(columnNames);
            writer.close();
            new FileAppender().append(sortedFile.toPath(), outputFilePath);
        } else {

            sortedFile.renameTo(outputFilePath.toFile());
        }

        return OperationStatus.success();
    }

    private List<File> submittedFiles = null;

    private Iterator<File> iterator = null;

    private Integer mergeNumber = null;

    private List<File> serialMerge(
            List<File> filesToMergeSort,
            Integer iterationNumber,
            CsvSortSettings csvSortSettings,
            Boolean deleteSourceFile) throws Exception {

        this.submittedFiles = new ArrayList<File>();
        this.mergeNumber = 1;
        File residual = null;

        //If odd number then save the residual
        if ((filesToMergeSort.size() % 2) == 1) {
            residual = filesToMergeSort.remove(filesToMergeSort.size()-1);
        }

        this.iterator = filesToMergeSort.iterator();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_THREADS; i++) {
            executorService.submit(new MergeSortDelegator(csvSortSettings, deleteSourceFile, iterationNumber));
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);

        if (residual != null) {
            File lastFile = this.submittedFiles.remove(this.submittedFiles.size() - 1);
            String mergedFileName = Paths.get(lastFile.toPath().getParent().toString(), "residual-merge-" + String.format("%07d", iterationNumber)).toString();
            SimpleCsvMergeSort simpleCsvMergeSort = new SimpleCsvMergeSort();
            simpleCsvMergeSort.mergeSortCsvFiles(lastFile.getAbsolutePath(), residual.getAbsolutePath(), mergedFileName, csvSortSettings, deleteSourceFile);
            this.submittedFiles.add(Paths.get(mergedFileName).toFile());
        }

        return submittedFiles;
    }

    synchronized private List<Object> getNextFilesToMerge() {
        if (!this.iterator.hasNext() && (!this.hasFailed)) {

            return null;
        }

        File filea = this.iterator.next();
        //Iterator will throw no more elements if fileb is null.
        File fileb = this.iterator.next();

        Integer nextMergeNumber = this.mergeNumber;
        this.mergeNumber++;
        return Arrays.asList(filea, fileb, nextMergeNumber);
    }

    synchronized private void submitFile(File file) {
        this.submittedFiles.add(file);
    }

    synchronized private void failed() {
        this.hasFailed = true;
    }

    @AllArgsConstructor
    private class MergeSortDelegator implements Runnable {

        private CsvSortSettings csvSortSettings;

        private Boolean deleteSourceFiles;

        private Integer iterationNumber;

        @Override
        public void run() {
            try {
                List<Object> filesToMergeSort;

                while ((filesToMergeSort = getNextFilesToMerge()) != null) {
                    File filea = (File)filesToMergeSort.get(0);
                    File fileb = (File)filesToMergeSort.get(1);
                    Integer mergeNumber = (Integer)filesToMergeSort.get(2);
                    File mergedFile = safeRun(filea, fileb, mergeNumber);
                    submitFile(mergedFile);
                }
            } catch (Exception e) {

                log.error("Merge sort failed: ", e);
                failed();
            }
        }

        public File safeRun(File filea, File fileb, Integer mergeNumber) throws Exception {
            Path pathc = Paths.get(filea.toPath().getParent().toString(), "merge-sort-level-" + String.format("%07d", this.iterationNumber) + "-mrno-" + String.format("%07d", mergeNumber));
            File filec = pathc.toFile();
            SimpleCsvMergeSort simpleCsvMergeSort = new SimpleCsvMergeSort();
            simpleCsvMergeSort.mergeSortCsvFiles(filea.getAbsolutePath(), fileb.getAbsolutePath(), filec.getAbsolutePath(), this.csvSortSettings, this.deleteSourceFiles);
            return filec;
        }
    }
}
