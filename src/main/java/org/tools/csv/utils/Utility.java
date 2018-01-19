package org.tools.csv.utils;

import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.tools.csv.entity.CsvSortSettings;

import au.com.bytecode.opencsv.CSVReader;

public class Utility {

    public static String generateTag() {
        Random random = new Random();
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int length = alphabets.length();
        return  String.valueOf(alphabets.charAt(random.nextInt(length)))
            + String.valueOf(alphabets.charAt(random.nextInt(length)))
            + String.valueOf(System.currentTimeMillis());
    }

    public static String[] getColumnNamesOfCsv(Path path, CsvSortSettings csvSortSettings) {

        if (!csvSortSettings.getHasColumnNames()) {
            return null;
        }

        String[] columnNames = null;

        try (CSVReader reader = new CSVReader(new FileReader(path.toFile()))) {

            columnNames = reader.readNext();
        } catch (Exception e) {

            throw new RuntimeException(e);
        }

        return columnNames;
    }

    public static CsvSortSettings getCsvSortSettings(Path inputFilePath, String arg) {

        if (arg == null || arg.trim().isEmpty()) {
            throw new RuntimeException("Invalid argument given for column names");
        }

        List<String> columnsInArgument = Arrays.asList(arg.split(","));

        if (isNumeric(columnsInArgument.get(0))) {

            CsvSortSettings csvSortSettings = new CsvSortSettings();
            csvSortSettings.setHasColumnNames(false);

            List<Integer> integerColumns = new ArrayList<Integer>();
            for (String column : columnsInArgument) {
                integerColumns.add(Integer.parseInt(column));
            }
            csvSortSettings.setSortColumnOrder(integerColumns);

            return csvSortSettings;
        } else {

            CsvSortSettings csvSortSettings = new CsvSortSettings();
            csvSortSettings.setHasColumnNames(true);
            List<String> columnsInCsv = Arrays.asList(getColumnNamesOfCsv(inputFilePath, csvSortSettings));

            List<Integer> integerColumns = new ArrayList<Integer>();
            List<String> faultyColumns = new ArrayList<String>();

            for (String columnInArgument : columnsInArgument) {
                Integer index = columnsInCsv.indexOf(columnInArgument);

                if (index == -1) {
                    faultyColumns.add(columnInArgument);
                } else {
                    integerColumns.add(index);
                }
            }

            if (faultyColumns.size() > 0) {
                throw new RuntimeException("Following columns doesn't exist in given csv file: " + faultyColumns.toString());
            }

            return csvSortSettings;
        }
    }

    public static boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }
}
