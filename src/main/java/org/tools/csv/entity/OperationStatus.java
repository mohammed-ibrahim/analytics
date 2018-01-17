package org.tools.csv.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OperationStatus {

    private ExecutionStatus executionStatus;
    
    public static OperationStatus success() {
        return new OperationStatus(ExecutionStatus.SUCCESS);
    }
    
    public static OperationStatus failure() {
        return new OperationStatus(ExecutionStatus.FAILURE);
    }
}
