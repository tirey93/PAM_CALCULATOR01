package com.example.mycalculator01.calculations;

import java.util.Stack;

public class State {
    private Operations operations = new Operations();
    private Number number = new Number();

    public Number getNumber() {
        return number;
    }

    public Operations getOperations() {
        return operations;
    }
}
