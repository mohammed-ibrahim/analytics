package org.tools.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsvBlockSorter {

    public void sort(String inputFileName, String outputFileName, CsvSortSettings csvSortSettings) throws Exception {
        Path inputFile = Paths.get(inputFileName);

        if (inputFile.toFile().exists()) {
            throw new FileNotFoundException(inputFileName.toString());
        }

        List<String[]> buffer = new ArrayList<String[]>();
        List<Object> columnToSort = new ArrayList<Object>();

        try (CSVReader reader = new CSVReader(new FileReader(inputFile.toFile()))) {
            Integer columnIndex = getColumnIndex(reader, csvSortSettings);
            String[] line;
            while ((line = reader.readNext()) != null) {
                buffer.add(line);
                columnToSort.add(line[columnIndex]);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    
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
}
