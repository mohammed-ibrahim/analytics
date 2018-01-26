package org.tools.csv.format.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

@Data
@Wither
@AllArgsConstructor
@NoArgsConstructor
public class ProcessMetadata {

    private List<Integer> returnColumnIndexes;

    private List<String> columnNames;

    public Integer indexOfColumnName(String columnName) {
        Integer index = this.columnNames.indexOf(columnName);

        if (index < 0) {
            throw new RuntimeException("The column name: " + columnName + " doesn't exist in given csv");
        }

        return index;
    }
}
