package org.tools.csv.format.entity;

public interface Printer extends AutoCloseable {

    void nextLine(String[] line) throws Exception;
}
