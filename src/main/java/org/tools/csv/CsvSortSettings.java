package org.tools.csv;

import java.util.List;

import lombok.Data;

@Data
public class CsvSortSettings {

    private List<Integer> sortColumnOrder;
    
    private Boolean hasColumnNames;
}
