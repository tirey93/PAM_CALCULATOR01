package com.example.mycalculator01;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;


import androidx.lifecycle.ViewModelProvider;

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

    private Button bOperationSin;
    private Button bOperationCos;
    private Button bOperationTan;

    private Button bOperationLn;
    private Button bOperationLog;
    private Button bOperationPercent;

    private Button bOperationX2;
    private Button bOperationPower;
    private Button bOperationSqrt;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.default_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.authors) {
            Intent intent = new Intent(MainActivity.this, Authors.class);
            startActivity(intent);
            return true;
        } else if (itemId == R.id.exit) {
            finishAndRemoveTask();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.calculation = new ViewModelProvider(this).get(Calculation.class);

        vInputCurrent = findViewById(R.id.input_current);
        vTempResult = findViewById(R.id.temp_result);

        setvInputCurrent(vInputCurrent);
        setvTempResult(vTempResult);
        updateCurrentState();

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

        bOperationSin = findViewById(R.id.operation_sin);
        bOperationCos = findViewById(R.id.operation_cos);
        bOperationTan = findViewById(R.id.operation_tan);
        bOperationLn = findViewById(R.id.operation_ln);
        bOperationLog = findViewById(R.id.operation_log);
        bOperationPercent = findViewById(R.id.operation_percent);
        bOperationX2 = findViewById(R.id.operation_x2);
        bOperationPower = findViewById(R.id.operation_power);
        bOperationSqrt = findViewById(R.id.operation_sqrt);


        if (bOperationSin != null) {
            bOperationSin.setOnClickListener(v -> {
                handleSin();
            });
        }
        if (bOperationCos != null) {
            bOperationCos.setOnClickListener(v -> {
                handleCos();
            });
        }
        if (bOperationTan != null) {
            bOperationTan.setOnClickListener(v -> {
                handleTan();
            });
        }
        if (bOperationLn != null) {
            bOperationLn.setOnClickListener(v -> {
                handleLn();
            });
        }
        if (bOperationLog != null) {
            bOperationLog.setOnClickListener(v -> {
                handleLog();
            });
        }
        if (bOperationPercent != null) {
            bOperationPercent.setOnClickListener(v -> {
                handlePercent();
            });
        }
        if (bOperationX2 != null) {
            bOperationX2.setOnClickListener(v -> {
                handleX2();
            });
        }
        if (bOperationSqrt != null) {
            bOperationSqrt.setOnClickListener(v -> {
                handleSqrt();
            });
        }

        if (bOperationClear != null) {
            bOperationClear.setOnClickListener(v -> {
                handleClearCharacter();
            });
            bOperationClear.setOnLongClickListener(v -> {
                handleClear();
                return true;
            });
        }

        if (bOperationAllClear != null) {
            bOperationAllClear.setOnClickListener(v -> {
                handleClearAll();
            });
        }

        if (bOperationEqual != null) {
            bOperationEqual.setOnClickListener(v -> {
                handleEqual();
            });
        }

        if (bDigit1 != null) {
            bDigit1.setOnClickListener(v -> {
                handleDigit(1);
            });
        }
        if (bDigit2 != null) {
            bDigit2.setOnClickListener(v -> {
                handleDigit(2);
            });
        }
        if (bDigit3 != null) {
            bDigit3.setOnClickListener(v -> {
                handleDigit(3);
            });
        }
        if (bDigit4 != null) {
            bDigit4.setOnClickListener(v -> {
                handleDigit(4);
            });
        }
        if (bDigit5 != null) {
            bDigit5.setOnClickListener(v -> {
                handleDigit(5);
            });
        }
        if (bDigit6 != null) {
            bDigit6.setOnClickListener(v -> {
                handleDigit(6);
            });
        }
        if (bDigit7 != null) {
            bDigit7.setOnClickListener(v -> {
                handleDigit(7);
            });
        }
        if (bDigit8 != null) {
            bDigit8.setOnClickListener(v -> {
                handleDigit(8);
            });
        }
        if (bDigit9 != null) {
            bDigit9.setOnClickListener(v -> {
                handleDigit(9);
            });
        }
        if (bDigit0 != null) {
            bDigit0.setOnClickListener(v -> {
                handleDigit(0);
            });
        }

        if (bOperationDivide != null) {
            bOperationDivide.setOnClickListener(v -> {
                handleOperation(OperationLiteral.Divide);
            });
        }
        if (bOperationMultiply != null) {
            bOperationMultiply.setOnClickListener(v -> {
                handleOperation(OperationLiteral.Multiply);
            });
        }
        if (bOperationSubtract != null) {
            bOperationSubtract.setOnClickListener(v -> {
                handleOperation(OperationLiteral.Subtract);
            });
        }
        if (bOperationAdd != null) {
            bOperationAdd.setOnClickListener(v -> {
                handleOperation(OperationLiteral.Add);
            });
        }

        if (bOperationNeg != null) {
            bOperationNeg.setOnClickListener(v -> {
                handleNeg();
            });
        }
        if (bOperationComma != null) {
            bOperationComma.setOnClickListener(v -> {
                handleComma();
            });
        }
    }
}