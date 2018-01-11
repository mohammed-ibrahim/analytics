package org.tools.csv;

import lombok.Data;

@Data
public class CsvSortSettings {

    private SortColumnOn sortColumnOn;
    
    private String sortColumnName;
    
    private Integer sortColumnIndex;
    
    private Boolean hasColumnNames;
}
