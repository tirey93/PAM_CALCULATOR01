package com.example.mycalculator01.calculations;

public class Operation {

    private OperationType operationType;
    private String value;

    public Operation(OperationType operationType, String value) {
        this.operationType = operationType;
        this.value = value;
    }

    public OperationType getType() {
        return operationType;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return operationType + " - " + value;
    }
}
