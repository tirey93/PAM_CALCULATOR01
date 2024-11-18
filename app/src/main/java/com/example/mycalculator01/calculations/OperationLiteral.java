package com.example.mycalculator01.calculations;

import java.util.Map;

public class OperationLiteral {
    public static final String Divide = "÷";
    public static final String Multiply = "×";
    public static final String Subtract = "-";
    public static final String Add = "+";

    public static final String Sinus = "sin";
    public static final String X2 = "^2";

    public static Map<String, String> TwoArgOperations = Map.of(
            "÷", Divide,
            "×", Multiply,
            "-", Subtract,
            "+", Add
    );
    public static Map<String, String> OneArgAfterOperations = Map.of(
            "^2", X2
    );
}
