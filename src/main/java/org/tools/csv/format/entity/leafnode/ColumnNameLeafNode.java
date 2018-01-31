package org.tools.csv.format.entity.leafnode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ColumnNameLeafNode implements LeafNode {

    private String name;
}
