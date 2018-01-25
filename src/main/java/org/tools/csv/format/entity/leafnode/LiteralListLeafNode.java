package org.tools.csv.format.entity.leafnode;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LiteralListLeafNode implements LeafNode {

    private List<String> items = new ArrayList<String>();
}
