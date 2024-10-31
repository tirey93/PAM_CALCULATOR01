package com.example.mycalculator01.calculations;

import java.util.Map;

public class OperationLiteral {
    public static String Divide = "÷";
    public static String Multiply = "×";
    public static String Subtract = "-";
    public static String Add = "+";
    public static String Neg = "±";
    public static String Comma = ",";

    public static Map<String, String> AllOperations = Map.of(
            "÷", "Divide",
            "×", "Multiply",
            "-", "Subtract",
            "+", "Add",
            "±", "Negate"
    );

    public static Map<String, String> TwoArgOperations = Map.of(
            "÷", "Divide",
            "×", "Multiply",
            "-", "Subtract",
            "+", "Add"
    );
    public static Map<String, String> OneArgOperations = Map.of(
            "±", "Negate"
    );
}
