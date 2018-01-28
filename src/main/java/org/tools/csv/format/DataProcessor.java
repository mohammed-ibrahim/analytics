package org.tools.csv.format;

import java.io.FileReader;
import java.nio.file.Path;

import org.tools.csv.format.entity.ConsolePrinter;
import org.tools.csv.format.entity.FilePrinter;
import org.tools.csv.format.entity.Format;
import org.tools.csv.format.entity.Printer;
import org.tools.csv.format.entity.ProcessMetadata;
import org.tools.csv.format.expr.ExpressionEvaluator;
import org.tools.csv.utils.Timer;

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
            Boolean headersPrinted = Boolean.FALSE;
            Long numResults = 0L;
            Timer timer = new Timer();

            while ((line = reader.readNext()) != null) {

                if (expressionEvaluator.evaluate(line)) {

                    numResults++;

                    if (!headersPrinted) {

                        line = reader.readNext();
                        for (int i=0; i<metadata.getReturnColumnIndexes().size(); i++) {
                            outputArray[i] = line[metadata.getReturnColumnIndexes().get(i)];
                        }
                        printer.nextLine(outputArray);

                        headersPrinted = true;
                    }

                    for (int i=0; i<metadata.getReturnColumnIndexes().size(); i++) {
                        outputArray[i] = line[metadata.getReturnColumnIndexes().get(i)];
                    }

                    printer.nextLine(outputArray);
                }
            }

            String info = String.format("Rows: %d Time-taken: %s", numResults, timer.end().toString());
            System.out.println(info);

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
