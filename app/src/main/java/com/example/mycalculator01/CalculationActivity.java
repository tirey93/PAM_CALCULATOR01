package com.example.mycalculator01;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycalculator01.calculations.Calculation;
import com.example.mycalculator01.exceptions.CalculationException;

public class CalculationActivity extends AppCompatActivity {

    private TextView vInputCurrent;
    private TextView vTempResult;

    private  Calculation calculation = new Calculation();

    public void handleDigit(int digit){
        calculation.putDigit(digit);
        vInputCurrent.setText(calculation.getInput());
    }

    public void handleOperation(String operation) {
        try {
            calculation.putOperation(operation);
            vInputCurrent.setText(calculation.getInput());
        } catch (CalculationException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void handleComma(){

    }
    public void handleNeg(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setvInputCurrent(TextView vInputCurrent) {
        this.vInputCurrent = vInputCurrent;
    }

    public void setvTempResult(TextView vTempResult) {
        this.vTempResult = vTempResult;
    }
}