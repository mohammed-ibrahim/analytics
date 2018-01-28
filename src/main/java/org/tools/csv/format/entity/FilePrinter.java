package org.tools.csv.format.entity;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import au.com.bytecode.opencsv.CSVWriter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
    public void nextLine(String[] line) {

        if (this.writer == null) {

            try {
                this.writer = new CSVWriter(new FileWriter(this.filePath.toFile()));
            } catch (IOException e) {

                log.error("Failed to open file for writing", e);
                throw new RuntimeException(e);
            }
        }

        this.writer.writeNext(line);
    }
}
