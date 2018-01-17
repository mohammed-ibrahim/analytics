package org.tools.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.tools.csv.comparator.CsvComparator;
import org.tools.csv.utils.StatUtils;
import org.tools.csv.utils.Timer;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsvBlockSorter {

    public void sort(String inputFileName, String outputFileName, CsvSortSettings csvSortSettings) throws Exception {
        Path inputFile = Paths.get(inputFileName);

        //10mb csv file takes ~/350mb ram
        //50mb csv file takes ~/870mb ram
        //100mb csv file takes ~/1050mb ram
        if (!inputFile.toFile().exists()) {
            throw new FileNotFoundException(inputFileName.toString());
        }

        Timer timer = new Timer();
        String status = "Failure";
        Double fileSize = StatUtils.fileSizeInMb(inputFile.toFile());
        StatUtils.assertFileSizeWithinManagableBlockSize(inputFile.toFile());

        List<String[]> buffer = new ArrayList<String[]>();

        try (CSVReader reader = new CSVReader(new FileReader(inputFile.toFile()));
                CSVWriter writer = new CSVWriter(new FileWriter(outputFileName))) {

            Timer loadtimer = new Timer();
            String[] line = reader.readNext();
            String[] header = line;

            while ((line = reader.readNext()) != null) {
                buffer.add(line);
            }

            log.info("File-load complete, time-taken: {}", loadtimer.end().toString());

            Timer sortingTimer = new Timer();
            Collections.sort(buffer, new CsvComparator(csvSortSettings.getSortColumnOrder()));
            //log.info("Sleeping for 1 min");
            //Thread.currentThread().sleep(60000);
            log.info("Sorting complete, time-taken: {}", sortingTimer.end().toString());
            writer.writeNext(header);
            writer.writeAll(buffer);
            status = "Success";

        } catch (Exception e) {

            e.printStackTrace();
            return;
        }

        log.info("Status: {}, Time-taken: {}, file-size: {} mb", status, timer.end().toString(), fileSize);
    }

    public static void main(String[] args) throws Exception {

        if (args.length != 3) {
            System.out.println("Usage: java -cp jar_file.jar org.tools.csv.CsvBlockSorter <input_csv> <output_csv> sort_col1,sort_col2,sort_col3");
            System.exit(1);
        }

        CsvBlockSorter csvBlockSorter = new CsvBlockSorter();
        CsvSortSettings csvSortSettings = new CsvSortSettings();

        csvSortSettings.setSortColumnOrder(new ArrayList<Integer>());
        for (String columIndex : args[2].split(",")) {
            csvSortSettings.getSortColumnOrder().add(Integer.parseInt(columIndex));
        }

        csvBlockSorter.sort(args[0], args[1], csvSortSettings);
    }
}
