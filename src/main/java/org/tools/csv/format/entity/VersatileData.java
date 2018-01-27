package org.tools.csv.format.entity;

import java.util.List;

import org.tools.csv.format.entity.leafnode.ColumnNameLeafNode;

import lombok.Data;

@Data
public class VersatileData {

    private Object object;

    private VersatileDataType type;

    private String strValue;

    private Double doubleValue;

    private Boolean boolValue;

    private List<?> listValue;

    public VersatileData(Object object, String[] row, ProcessMetadata metadata) {

        this.object = object;

        if (object == null) {

            this.type = VersatileDataType.NULL;
        } else if (object instanceof String) {

            String str = (String)object;

            if (str.trim().isEmpty()) {

                this.type = VersatileDataType.NULL;
            } else {
                this.type = VersatileDataType.STRING;
                this.strValue = str;
            }

        } else if (object instanceof Double) {

            this.type = VersatileDataType.DOUBLE;
            this.doubleValue = (Double)object;
        } else if (object instanceof Boolean) {

            this.type = VersatileDataType.BOOL;
            this.boolValue = (Boolean)object;
        } else if (object instanceof List) {

            this.listValue = (List)object;
        } else if (object instanceof ColumnNameLeafNode) {

            ColumnNameLeafNode leafNode = (ColumnNameLeafNode)object;
            String value = row[metadata.indexOfColumnName(leafNode.getName())];

            if (value == null || value.trim().isEmpty()) {
                this.type = VersatileDataType.NULL;
            } else {
                this.type = VersatileDataType.STRING;
                this.strValue = value;
            }
        } else {

            throw new RuntimeException("Handler not defined for class: " + object.getClass());
        }
    }

    public Boolean isEquals(VersatileData other) {

        if (!this.type.equals(other.getType())) {

            throw new RuntimeException(this.type.toString() + " cannot be compared to: " + other.getType().toString());
        }

        if (this.type.equals(VersatileDataType.NULL) || other.getType().equals(VersatileDataType.NULL)) {

            throw new RuntimeException("null types cannot be compared.");
        }

        switch (this.type) {
            case BOOL:
                return this.boolValue.equals(other.getBoolValue());

            case DOUBLE:
                return this.doubleValue.equals(other.getDoubleValue());

            case STRING:
                return this.strValue.equals(other.getStrValue());

            default:
                throw new RuntimeException(this.type.toString() + " comparisiont to: " + other.getType().toString()  + " is not handeled.");
        }
    }
}
