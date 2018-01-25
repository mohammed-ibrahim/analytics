package org.tools.csv.format.entity;

import java.util.ArrayList;
import java.util.List;

import org.tools.csv.format.entity.leafnode.LeafNode;

import lombok.Data;

@Data
public class Node {

    private NodeType op;
    
    private Node lhs;
    
    private Node rhs;
    
    private LeafNode lhsLeaf;
    
    private LeafNode rhsLeaf;
    
    private List<String> rhsList = new ArrayList<String>();
}
