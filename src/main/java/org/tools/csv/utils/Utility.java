package org.tools.csv.utils;

import java.io.FileReader;
import java.nio.file.Path;
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
}
