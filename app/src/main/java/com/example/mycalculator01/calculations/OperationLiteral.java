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
    public static final String Cosines = "cos";
    public static final String Tangent = "tan";
    public static final String Ln = "ln";
    public static final String Log = "log";
    public static final String Sqrt = "sqrt";

    public static Set<String> TwoArgOperations = Set.of(
            Divide,
            Multiply,
            Subtract,
            Add,
            Power
    );
    public static Set<String>OneArgOperations = Set.of(
            Sinus,
            Cosines,
            Tangent,
            Ln,
            Log,
            Sqrt
    );

    public static Map<String, String> ToExp4j = Map.of(
            Divide, "/",
            Multiply, "*",
            Ln, "log",
            Log, "log10"
    );
}
