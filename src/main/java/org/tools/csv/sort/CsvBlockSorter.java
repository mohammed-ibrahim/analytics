package org.tools.csv.sort;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.tools.csv.comparator.CsvComparator;
import org.tools.csv.entity.CsvSortSettings;
import org.tools.csv.entity.OperationStatus;
import org.tools.csv.utils.StatUtils;
import org.tools.csv.utils.Timer;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsvBlockSorter {

    public OperationStatus sort(
            Path inputFilePath,
            Path outputFilePath,
            CsvSortSettings csvSortSettings) throws Exception {

        //10mb csv file takes ~/350mb ram
        //50mb csv file takes ~/870mb ram
        //100mb csv file takes ~/1050mb ram
        if (!inputFilePath.toFile().exists()) {
            throw new FileNotFoundException(inputFilePath.toString());
        }

        Timer timer = new Timer();
        String status = "Failure";
        Double fileSize = StatUtils.fileSizeInMb(inputFilePath.toFile());
        StatUtils.assertFileSizeWithinManagableBlockSize(inputFilePath.toFile());

        List<String[]> buffer = new ArrayList<String[]>();

        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath.toFile()));
                CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath.toFile()))) {

            Timer loadtimer = new Timer();
            String[] line = null;
            String[] header = null;

            //Just to ensure that column-names are ommited for sorting.
            if (csvSortSettings.getHasColumnNames()) {

                //Preserve the headers.
                header = reader.readNext();
            }

            while ((line = reader.readNext()) != null) {
                buffer.add(line);
            }

            log.info("File-load complete, time-taken: {}", loadtimer.end().toString());

            Timer sortingTimer = new Timer();
            Collections.sort(buffer,
                    new CsvComparator(csvSortSettings.getSortColumnOrder(), csvSortSettings.getIsDescendingOrder()));
            log.info("Sorting complete, time-taken: {}", sortingTimer.end().toString());

            //Restore the headers after sorting.
            if (header != null) {
                writer.writeNext(header);
            }

            writer.writeAll(buffer);
            status = "Success";

        } catch (Exception e) {

            e.printStackTrace();
            return OperationStatus.failure();
        }

        log.info("Status: {}, Time-taken: {}, file-size: {} mb", status, timer.end().toString(), fileSize);

        return OperationStatus.success();
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

        csvBlockSorter.sort(Paths.get(args[0]), Paths.get(args[1]), csvSortSettings);
    }
}
