package org.tools.csv.format;

import java.io.FileReader;
import java.nio.file.Path;

import org.tools.csv.format.entity.ConsolePrinter;
import org.tools.csv.format.entity.Format;
import org.tools.csv.format.entity.Printer;
import org.tools.csv.format.entity.ProcessMetadata;

import au.com.bytecode.opencsv.CSVReader;

public class DataProcessor {

    public void process(
            Path inputFile,
            Path outputFile,
            Format format,
            ProcessMetadata metadata) {

        String[] outputArray = new String[metadata.getReturnColumnIndexes().size()];

        try (CSVReader reader = new CSVReader(new FileReader(inputFile.toFile()));
                Printer printer = getPrinter(outputFile)) {

            String[] line = null;

            //omit the header
            line = reader.readNext();

            while ((line = reader.readNext()) != null) {
                //TODO: process data here
                //1: If matcher.matches then #2 else continue.
                //2: Copy required columns from inputfile to outputArray
                //3: Send the array to printer
            }

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    private Printer getPrinter(Path outputFile) {

        return new ConsolePrinter();
    }
}
