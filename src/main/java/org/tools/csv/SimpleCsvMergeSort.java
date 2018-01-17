package org.tools.csv;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.tools.csv.comparator.CsvComparator;
import org.tools.csv.entity.CsvSortSettings;
import org.tools.csv.entity.OperationStatus;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class SimpleCsvMergeSort {

    public OperationStatus mergeCsvFiles(
            String filea,
            String fileb,
            String filec,
            CsvSortSettings csvSortSettings,
            Boolean deleteSourceFiles) throws Exception {

        Path patha = Paths.get(filea);
        Path pathb = Paths.get(fileb);
        Path pathc = Paths.get(filec);

        try (CSVReader readera = new CSVReader(new FileReader(patha.toFile()));
                CSVReader readerb = new CSVReader(new FileReader(pathb.toFile()));
                CSVWriter writerc = new CSVWriter(new FileWriter(pathc.toFile()))) {

            CsvComparator csvComparator = new CsvComparator(csvSortSettings.getSortColumnOrder());
            String[] linea = readera.readNext();
            String[] lineb = readerb.readNext();

            while (linea != null || lineb != null) {

                if (linea != null && lineb != null) {
                    int result = csvComparator.compare(linea, lineb);

                    if (result > 0) {

                        writerc.writeNext(lineb);
                        lineb = null;
                    } else if (result < 0) {

                        writerc.writeNext(linea);
                        linea = null;
                    } else {

                        writerc.writeNext(linea);
                        writerc.writeNext(lineb);
                        linea = null;
                        lineb = null;
                    }
                } else if (linea != null) {

                    writerc.writeNext(linea);
                    linea = null;
                } else if (lineb != null) {

                    writerc.writeNext(lineb);
                    lineb = null;
                }

                if (linea == null) {

                    linea = readera.readNext();
                }

                if (lineb == null) {

                    lineb = readerb.readNext();
                }
            }
        }

        if (deleteSourceFiles) {
            patha.toFile().delete();
            pathb.toFile().delete();
        }

        return OperationStatus.success();
    }
}
