package com.example.mycalculator01.calculations;

import java.util.Map;
import java.util.Set;

public class OperationLiteral {
    public static final String Divide = "÷";
    public static final String Multiply = "×";
    public static final String Subtract = "-";
    public static final String Add = "+";
    public static final String Power = "^";

    public static final String Sinus = "sin";

    public static Set<String> TwoArgOperations = Set.of(
            Divide,
            Multiply,
            Subtract,
            Add,
            Power
    );
    public static Map<String, String> OneArgOperations = Map.of(

    );

    public static Map<String, String> ToExp4j = Map.of(
            Divide, "/",
            Multiply, "*"
    );
}
