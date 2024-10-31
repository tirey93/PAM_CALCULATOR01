package com.example.mycalculator01.calculations;

import java.util.HashMap;
import java.util.Map;

public class OperationLiteral {
    public static String Divide = "÷";
    public static String Multiply = "×";
    public static String Subtract = "-";
    public static String Add = "+";
    public static String Sinus = "sin";

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
