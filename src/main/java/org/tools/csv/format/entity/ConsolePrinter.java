package org.tools.csv.format.entity;

import java.util.Arrays;

public class ConsolePrinter implements Printer {

    @Override
    public void close() throws Exception {

        System.out.println("Done printing...");
    }

    @Override
    public void nextLine(String[] line) {

        Arrays.asList(line).forEach(a -> System.out.print(a + ","));
        System.out.println("");
    }

}
