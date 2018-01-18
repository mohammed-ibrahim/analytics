package org.tools.csv.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class FileAppender {

    public void append(Path sourceFilePath, Path destinationFilePath) throws IOException {

        File sourceFile = sourceFilePath.toFile();
        FileInputStream fis = new FileInputStream(sourceFile);
        BufferedReader in = new BufferedReader(new InputStreamReader(fis));

        FileWriter fileWriter = new FileWriter(destinationFilePath.toFile(), true);
        BufferedWriter out = new BufferedWriter(fileWriter);

        String line = null;
        while ((line = in.readLine()) != null) {

            out.write(line);
            out.newLine();
        }

        in.close();
        out.close();
    }
}
