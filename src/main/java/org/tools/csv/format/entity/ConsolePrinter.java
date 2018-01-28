package org.tools.csv.format.entity;

import org.apache.commons.lang3.StringUtils;

public class ConsolePrinter implements Printer {

    @Override
    public void close() throws Exception {

    }

    @Override
    public void nextLine(String[] line) {

        System.out.println(StringUtils.join(line, ","));
    }

}
