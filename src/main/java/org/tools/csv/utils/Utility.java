package org.tools.csv.utils;

import java.io.FileReader;
import java.nio.file.Path;
import java.util.Random;

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

    public static String[] getColumnNamesOfCsv(Path path) {

        String[] columnNames = null;

        try (CSVReader reader = new CSVReader(new FileReader(path.toFile()))) {

            columnNames = reader.readNext();
        } catch (Exception e) {

            throw new RuntimeException(e);
        }

        return columnNames;
    }

    public static boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

    public static boolean isNullOrEmpty(String s) {
        if (s == null) {
            return true;
        }

        if (s.trim().isEmpty()) {
            return true;
        }

        return false;
    }
}
