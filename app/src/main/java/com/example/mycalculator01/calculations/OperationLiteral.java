package com.example.mycalculator01.calculations;

import java.util.HashMap;
import java.util.Map;

public class OperationLiteral {
    public static final String Divide = "÷";
    public static final String Multiply = "×";
    public static final String Subtract = "-";
    public static final String Add = "+";
    public static final String Sinus = "sin";

    public static Map<String, String> TwoArgOperations = Map.of(
            "÷", Divide,
            "×", Multiply,
            "-", Subtract,
            "+", Add
    );
    public static Map<String, String> OneArgOperations = Map.of(
            "sin", Sinus

    );

    public static Map<String, String> getAllOperations(){
        Map<String, String> result = new HashMap<>();
        result.putAll(OneArgOperations);
        result.putAll(TwoArgOperations);
        return  result;
    }
}
