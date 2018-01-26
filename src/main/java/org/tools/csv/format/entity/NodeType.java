package org.tools.csv.format.entity;

import java.util.HashMap;
import java.util.Map;

public enum NodeType {

    PARENTHESES,
    AND,
    OR,
    EQ,
    GT,
    LT,
    LE,
    GE,
    NE,
    IN,
    IS,
    LIKE,
    ROOT_EXPR;
    
    public static NodeType fromString(String input) {
        Map<String, NodeType> map = new HashMap<String, NodeType>();
        map.put("<", NodeType.LT);
        map.put(">", NodeType.GT);
        map.put("<=", NodeType.LE);
        map.put(">=", NodeType.GE);
        map.put("!=", NodeType.NE);
        map.put("in", NodeType.IN);
        map.put("=", NodeType.EQ);

        return map.get(input);
    }
}
