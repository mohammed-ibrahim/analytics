package org.tools.csv;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileSplitter {

    public List<File> splitFile(String inputFileName, String dumpDirectory, int sizeOfFileInMB) throws IOException {

        Path inputFile = Paths.get(inputFileName);

        if ((!Paths.get(dumpDirectory).toFile().exists())
                || (!Paths.get(dumpDirectory).toFile().isDirectory())) {

            throw new RuntimeException("Invalid dump directory: " + dumpDirectory);
        }

        int counter = 1;
        List<File> files = new ArrayList<File>();
        int sizeOfChunk = 1024 * 1024 * sizeOfFileInMB;
        String eof = System.lineSeparator();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile.toFile()))) {

            //String name = inputFile.getName();
            String line = br.readLine();

            while (line != null) {
                //File newFile = new File(inputFile.getParent(), name + "." + String.format("%03d", counter++));
                File newFile = Paths.get(dumpDirectory, "part-" + String.format("%07d", counter++)).toFile();

                try (OutputStream out = new BufferedOutputStream(new FileOutputStream(newFile))) {

                    int fileSize = 0;
                    while (line != null) {
                        byte[] bytes = (line + eof).getBytes(StandardCharsets.UTF_8);

                        if ((fileSize + bytes.length) > sizeOfChunk) {

                            break;
                        }

                        out.write(bytes);
                        fileSize += bytes.length;
                        line = br.readLine();
                    }

                }

                files.add(newFile);
            }
        }

        return files;
    }
    
    public static void main(String[] args) throws Exception {
        
        if (args.length != 3) {
            System.out.println("Usage: java -cp jar_file.jar org.tools.csv.FileSplitter <input_file> <dump_directory> size_in_mb");
            System.exit(1);
        }
        
        FileSplitter fileSplitter = new FileSplitter();
        fileSplitter.splitFile(args[0], args[1], Integer.parseInt(args[2]));
    }
}
