package org.tools.csv.format.entity.leafnode;

import lombok.Data;

@Data
public class NullFieldNode implements LeafNode {

    private String value = "null";
}
