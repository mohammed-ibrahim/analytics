package org.tools.csv.format.entity;

import java.io.FileWriter;
import java.nio.file.Path;

import au.com.bytecode.opencsv.CSVWriter;

public class FilePrinter implements Printer {

    private Path filePath;

    private CSVWriter writer;

    public FilePrinter(Path outputFile) {

        this.filePath = outputFile;
        this.writer = null;
    }

    @Override
    public void close() throws Exception {

        if (this.writer != null) {
            this.writer.close();
        }
    }

    @Override
    public void nextLine(String[] line) throws Exception {

        if (this.writer == null) {

            this.writer = new CSVWriter(new FileWriter(this.filePath.toFile()));
        }

        this.writer.writeNext(line);
    }
}
