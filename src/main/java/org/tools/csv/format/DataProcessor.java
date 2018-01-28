package org.tools.csv.format;

import java.io.FileReader;
import java.nio.file.Path;

import org.tools.csv.format.entity.ConsolePrinter;
import org.tools.csv.format.entity.FilePrinter;
import org.tools.csv.format.entity.Format;
import org.tools.csv.format.entity.Printer;
import org.tools.csv.format.entity.ProcessMetadata;
import org.tools.csv.format.expr.ExpressionEvaluator;

import au.com.bytecode.opencsv.CSVReader;

public class DataProcessor {

    public void process(
            Path inputFile,
            Path outputFile,
            Format format,
            ProcessMetadata metadata) {

        String[] outputArray = new String[metadata.getReturnColumnIndexes().size()];

        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(format.getNode(), metadata);

        try (CSVReader reader = new CSVReader(new FileReader(inputFile.toFile()));
                Printer printer = getPrinter(outputFile)) {

            String[] line = null;

            //print the headers
            line = reader.readNext();
            for (int i=0; i<metadata.getReturnColumnIndexes().size(); i++) {
                outputArray[i] = line[metadata.getReturnColumnIndexes().get(i)];
            }
            printer.nextLine(outputArray);

            while ((line = reader.readNext()) != null) {

                if (expressionEvaluator.evaluate(line)) {

                    for (int i=0; i<metadata.getReturnColumnIndexes().size(); i++) {
                        outputArray[i] = line[metadata.getReturnColumnIndexes().get(i)];
                    }

                    printer.nextLine(outputArray);
                }
            }

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    private Printer getPrinter(Path outputFile) {

        if (outputFile == null) {

            return new ConsolePrinter();
        } else {

            return new FilePrinter(outputFile);
        }
    }
}
