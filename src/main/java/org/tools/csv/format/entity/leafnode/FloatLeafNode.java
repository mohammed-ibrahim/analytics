package org.tools.csv.format.entity.leafnode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FloatLeafNode implements LeafNode {

    public Double value;
}
