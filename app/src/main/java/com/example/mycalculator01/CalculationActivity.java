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

    protected  Calculation calculation;

    protected void handleParenthesis() {
        try {
            calculation.putParenthesis();
            vInputCurrent.setText(calculation.getInput());
            vTempResult.setText(calculation.getResult());
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    protected void updateCurrentState(){
        try {
            vInputCurrent.setText(calculation.getInput());
            vTempResult.setText(calculation.getResult());
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void handleDigit(int digit){
        try {
            calculation.putDigit(digit);
            vInputCurrent.setText(calculation.getInput());
            vTempResult.setText(calculation.getResult());
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void handleTwoArgOperation(String operation) {
        try {
            calculation.putTwoArgOperation(operation);
            vInputCurrent.setText(calculation.getInput());
            vTempResult.setText(calculation.getResult());
        } catch (CalculationException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void handleOneArgOperation(String operation) {
        try {
            calculation.putOneArgOperation(operation);
            vInputCurrent.setText(calculation.getInput());
            vTempResult.setText(calculation.getResult());
        } catch (CalculationException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void handleEqual(){
        try {
            calculation.handleEqual();
            vInputCurrent.setText(calculation.getInput());
            vTempResult.setText(calculation.getResult());
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void handleComma(){
        try {
            calculation.putComma();
            vInputCurrent.setText(calculation.getInput());
            vTempResult.setText(calculation.getResult());
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void handleNeg(){
        try {
            calculation.putNeg();
            vInputCurrent.setText(calculation.getInput());
            vTempResult.setText(calculation.getResult());
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void handleClearCharacter(){
        try {
            calculation.clearCharacter();
            vInputCurrent.setText(calculation.getInput());
            vTempResult.setText(calculation.getResult());
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void handleClear(){
        try {
            calculation.clear();
            vInputCurrent.setText(calculation.getInput());
            vTempResult.setText(calculation.getResult());
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void handleClearAll(){
        try {
            calculation.clearAll();
            vInputCurrent.setText(calculation.getInput());
            vTempResult.setText(calculation.getResult());
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    protected void handleX2() {
        try {
            calculation.handleX2();
            vInputCurrent.setText(calculation.getInput());
            vTempResult.setText(calculation.getResult());
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    protected void handlePercent() {
        try {
            calculation.handlePercent();
            vInputCurrent.setText(calculation.getInput());
            vTempResult.setText(calculation.getResult());
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
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