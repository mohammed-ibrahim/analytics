package org.tools.csv.format.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Format {

    private List<String> rawColumns = new ArrayList<String>();
    
    private Node node;
}
