package org.tools.csv;

import java.io.File;
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

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InitialSorter {

    private static final int NUM_THREADS = 2;

    private Boolean hasFailed;

    private Integer index = 1;

    private Iterator<File> iterator;

    private List<File> sortedFiles;

    public List<File> sortIndividualFiles(
            List<File> files,
            CsvSortSettings csvSortSettings,
            Boolean deleteSourceFiles) throws Exception {

        this.hasFailed = false;
        this.iterator = files.iterator();
        this.sortedFiles = new ArrayList<File>();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_THREADS; i++) {
            executorService.submit(new SortDelegator(csvSortSettings, deleteSourceFiles));
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);

        return this.sortedFiles;
    }

    synchronized public void failed() {
        this.hasFailed = true;
    }

    synchronized List<Object> getNextFile() {

        if ((!this.iterator.hasNext()) || this.hasFailed) {
            return null;
        }

        Integer returnIndex = this.index;
        this.index++;
        return Arrays.asList(this.iterator.next(), returnIndex);
    }

    synchronized void submitFile(File file) {
        this.sortedFiles.add(file);
    }

    @AllArgsConstructor
    private class SortDelegator implements Runnable {

        private CsvSortSettings csvSortSettings;

        private Boolean deleteSourceFile;

        @Override
        public void run() {
            try {

                List<Object> nextFileDetails = null;

                while ((nextFileDetails = getNextFile()) != null) {
                    File fileToBlockSort = (File)nextFileDetails.get(0);
                    Integer index = (Integer)nextFileDetails.get(1);
                    File sortedFile = safeRun(fileToBlockSort, index);
                    submitFile(sortedFile);
                }
            } catch (Exception e) {

                failed();
                e.printStackTrace();
            }
        }

        public File safeRun(File fileToBlockSort, Integer index) throws Exception {
            Path sourcePath = fileToBlockSort.toPath();
            Path destinationPath = Paths.get(sourcePath.getParent().toString(), "initial-sorted-" + String.format("%07d", index));

            log.info("Sorting the file: {} into: {}", fileToBlockSort.toString(), destinationPath.toString());

            CsvBlockSorter csvBlockSorter = new CsvBlockSorter();
            csvBlockSorter.sort(sourcePath.toString(),
                    destinationPath.toString(),
                    this.csvSortSettings,
                    this.deleteSourceFile);

            return destinationPath.toFile();
        }
    }
}
