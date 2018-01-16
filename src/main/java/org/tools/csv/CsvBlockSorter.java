package org.tools.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.tools.csv.comparator.CsvComparator;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsvBlockSorter {

    public void sort(String inputFileName, String outputFileName, CsvSortSettings csvSortSettings) throws Exception {
        Path inputFile = Paths.get(inputFileName);

        if (!inputFile.toFile().exists()) {
            throw new FileNotFoundException(inputFileName.toString());
        }

        List<String[]> buffer = new ArrayList<String[]>();

        try (CSVReader reader = new CSVReader(new FileReader(inputFile.toFile()));
                CSVWriter writer = new CSVWriter(new FileWriter(outputFileName))) {

            String[] line = reader.readNext();
            String[] header = line;

            while ((line = reader.readNext()) != null) {
                buffer.add(line);
            }

            Collections.sort(buffer, new CsvComparator(csvSortSettings.getSortColumnOrder()));
            writer.writeNext(header);
            writer.writeAll(buffer);
        } catch (Exception e) {

            e.printStackTrace();
            return;
        }
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

    /*
    private int getColumnIndex(CSVReader reader, CsvSortSettings csvSortSettings) throws Exception {
        Integer index = null;

        if (csvSortSettings.getSortColumnOn().equals(SortColumnOn.COL_INDEX)) {

            index = csvSortSettings.getSortColumnIndex();
        } else if (csvSortSettings.getSortColumnOn().equals(SortColumnOn.COL_NAME)) {

            if (csvSortSettings.getSortColumnName() == null) {
                throw new RuntimeException("Sort column name not provided.");
            }

            if (!csvSortSettings.getHasColumnNames()) {
                throw new RuntimeException("Settings: hasColumnNames is active and csv doesn't have column names");
            }

            String [] line = reader.readNext();

            if (line == null) {
                throw new RuntimeException("Csv is empty!!");
            }

            index = Arrays.asList(line).indexOf(csvSortSettings.getSortColumnName());

            if (index < 0) {
                throw new RuntimeException("The column: " + csvSortSettings.getSortColumnName() + " not found in csv:");
            }
        }

        return index;
    }

    */
}
