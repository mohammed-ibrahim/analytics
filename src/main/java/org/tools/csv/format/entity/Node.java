package org.tools.csv.format.entity;

import java.util.ArrayList;
import java.util.List;

import org.tools.csv.format.entity.leafnode.LeafNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

@Data
@Wither
@AllArgsConstructor
@NoArgsConstructor
public class Node {

    private NodeType op;
    
    private Object lhs;
    
    private Object rhs;
}
