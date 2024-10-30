package com.example.mycalculator01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView vInputCurrent;
    private TextView vTempResult;

    private Button bOpearationCancel;
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
        vInputCurrent = findViewById(R.id.input_current);
        vTempResult = findViewById(R.id.temp_result);

        bOpearationCancel = findViewById(R.id.operation_cancel);
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


        bOpearationCancel.setOnClickListener(v -> {
            vTempResult.setText("Clicked Cancel");
        });
        bOperationEqual.setOnClickListener(v -> {
            vTempResult.setText("Clicked Equal");
        });


        bDigit1.setOnClickListener(v -> {
            vInputCurrent.setText("Clicked 1");
        });
        bDigit2.setOnClickListener(v -> {
            vInputCurrent.setText("Clicked 2");
        });
        bDigit3.setOnClickListener(v -> {
            vInputCurrent.setText("Clicked 3");
        });
        bDigit4.setOnClickListener(v -> {
            vInputCurrent.setText("Clicked 4");
        });
        bDigit5.setOnClickListener(v -> {
            vInputCurrent.setText("Clicked 5");
        });
        bDigit6.setOnClickListener(v -> {
            vInputCurrent.setText("Clicked 6");
        });
        bDigit7.setOnClickListener(v -> {
            vInputCurrent.setText("Clicked 7");
        });
        bDigit8.setOnClickListener(v -> {
            vInputCurrent.setText("Clicked 8");
        });
        bDigit9.setOnClickListener(v -> {
            vInputCurrent.setText("Clicked 9");
        });
        bDigit0.setOnClickListener(v -> {
            vInputCurrent.setText("Clicked 0");
        });


        bOperationDivide.setOnClickListener(v -> {
            vTempResult.setText("Clicked Cancel");
        });
        bOperationMultiply.setOnClickListener(v -> {
            vTempResult.setText("Clicked Multiply");
        });
        bOperationSubtract.setOnClickListener(v -> {
            vTempResult.setText("Clicked Subtract");
        });
        bOperationAdd.setOnClickListener(v -> {
            vTempResult.setText("Clicked Add");
        });
        bOperationNeg.setOnClickListener(v -> {
            vTempResult.setText("Clicked Neg");
        });
        bOperationComma.setOnClickListener(v -> {
            vTempResult.setText("Clicked Comma");
        });
    }
}