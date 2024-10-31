package com.example.mycalculator01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


import com.example.mycalculator01.calculations.OperationLiteral;
import com.example.mycalculator01.calculations.Calculation;

public class MainActivity extends CalculationActivity {

    private TextView vInputCurrent;
    private TextView vTempResult;

    private Button bOperationClear;
    private Button bOperationAllClear;
    private Button bOperationEqual;

    private Button bDigit1;
    private Button bDigit2;
    private Button bDigit3;
    private Button bDigit4;
    private Button bDigit5;
    private Button bDigit6;
    private Button bDigit7;
    private Button bDigit8;
    private Button bDigit9;
    private Button bDigit0;

    private Button bOperationDivide;
    private Button bOperationMultiply;
    private Button bOperationSubtract;
    private Button bOperationAdd;
    private Button bOperationNeg;
    private Button bOperationComma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calculation calculation = new Calculation();
        vInputCurrent = findViewById(R.id.input_current);
        vTempResult = findViewById(R.id.temp_result);
        setvInputCurrent(vInputCurrent);
        setvTempResult(vTempResult);

        bOperationClear = findViewById(R.id.operation_clear);
        bOperationAllClear = findViewById(R.id.operation_all_clear);
        bOperationEqual = findViewById(R.id.operation_equal);

        bDigit1 = findViewById(R.id.digit_1);
        bDigit2 = findViewById(R.id.digit_2);
        bDigit3 = findViewById(R.id.digit_3);
        bDigit4 = findViewById(R.id.digit_4);
        bDigit5 = findViewById(R.id.digit_5);
        bDigit6 = findViewById(R.id.digit_6);
        bDigit7 = findViewById(R.id.digit_7);
        bDigit8 = findViewById(R.id.digit_8);
        bDigit9 = findViewById(R.id.digit_9);
        bDigit0 = findViewById(R.id.digit_0);

        bOperationDivide = findViewById(R.id.operation_divide);
        bOperationMultiply = findViewById(R.id.operation_multiply);
        bOperationSubtract = findViewById(R.id.operation_subtract);
        bOperationAdd = findViewById(R.id.operation_add);
        bOperationNeg = findViewById(R.id.operation_neg);
        bOperationComma = findViewById(R.id.operation_comma);


        bOperationClear.setOnClickListener(v -> {
            vTempResult.setText("Clicked Clear");
        });
        bOperationAllClear.setOnClickListener(v -> {
            vTempResult.setText("Clicked All Clear");
        });
        bOperationEqual.setOnClickListener(v -> {
            vTempResult.setText("Clicked Equal");
        });


        bDigit1.setOnClickListener(v -> {
            handleDigit(1);
        });
        bDigit2.setOnClickListener(v -> {
            handleDigit(2);
        });
        bDigit3.setOnClickListener(v -> {
            handleDigit(3);
        });
        bDigit4.setOnClickListener(v -> {
            handleDigit(4);
        });
        bDigit5.setOnClickListener(v -> {
            handleDigit(5);
        });
        bDigit6.setOnClickListener(v -> {
            handleDigit(6);
        });
        bDigit7.setOnClickListener(v -> {
            handleDigit(7);
        });
        bDigit8.setOnClickListener(v -> {
            handleDigit(8);
        });
        bDigit9.setOnClickListener(v -> {
            handleDigit(9);
        });
        bDigit0.setOnClickListener(v -> {
            handleDigit(0);
        });


        bOperationDivide.setOnClickListener(v -> {
            handleOperation(OperationLiteral.Divide);
        });
        bOperationMultiply.setOnClickListener(v -> {
            handleOperation(OperationLiteral.Multiply);
        });
        bOperationSubtract.setOnClickListener(v -> {
            handleOperation(OperationLiteral.Subtract);
        });
        bOperationAdd.setOnClickListener(v -> {
            handleOperation(OperationLiteral.Add);
        });

        bOperationNeg.setOnClickListener(v -> {
            handleNeg();
        });
        bOperationComma.setOnClickListener(v -> {
            handleComma();
        });
    }
}