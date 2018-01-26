package org.tools.csv.format.entity;

public class ConsolePrinter implements Printer {

    @Override
    public void close() throws Exception {

        System.out.println("Done printing...");
    }

    @Override
    public void nextLine(String[] line) {
        // TODO Auto-generated method stub

    }

}
