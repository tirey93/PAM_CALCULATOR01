package com.example.mycalculator01.calculations;
import androidx.lifecycle.ViewModel;

import com.example.mycalculator01.exceptions.CalculationException;
import com.example.mycalculator01.handlers.ClearHandler;
import com.example.mycalculator01.handlers.CommaHandler;
import com.example.mycalculator01.handlers.NegHandler;
import com.example.mycalculator01.handlers.OneArgHandler;
import com.example.mycalculator01.handlers.TwoArgHandler;

import java.util.List;

public class Calculation extends ViewModel {
    private State state = new State();

    public void clearCharacter() {
        state = new ClearHandler(state).clearCharacter();
    }

    public void clear(){
        state = new ClearHandler(state).clear();
    }

    public void clearAll(){
        state = new ClearHandler(state).clearAll();
    }

    public void putDigit(int digit){
        state.getNumber().push(String.valueOf(digit));
    }
    public void putComma() {
        state = new CommaHandler(state).handleComma();
    }
    public void putNeg(){
        state = new NegHandler(state).handleNeg();
    }
    public void putOperation(String operation) throws CalculationException {
        state = new TwoArgHandler(state).handleTwoArgOperation(operation);
    }
    public void handleOneArgAfter(String operation) throws CalculationException {
        state = new OneArgHandler(state).handleOneArgAfter(operation);
    }


    public void handleEqual(){
        state.getNumber().setCurrentNumber(getResult());
        state.getOperations().clear();
    }

    public String getInput() {
        List<String> res = state.getOperations().asList();
        return String.join(" ", res) + " " + state.getNumber().getCurrentNumber();
    }

    public String getResult(){
        try {
            if(state.getOperations().isEmpty() || state.getNumber().isEmpty())
                return "";
            double listCalculated = calculateFromList();
            double result = doOperation(listCalculated,
                    Double.parseDouble(state.getNumber().getCurrentNumber()),
                    state.getOperations().last().getValue());
            return String.valueOf(result);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    private double calculateFromList(){
        double result = Double.parseDouble(state.getOperations().first().getValue());
        String operation = "";

        for(Operation o : state.getOperations().fromSecondOperation()) {
            switch (o.getType()) {
                case Number: {
                    result = doOperation(result, Double.parseDouble(o.getValue()), operation);
                    break;
                }
                case TwoArgOperation: {
                    operation = o.getValue();
                    break;
                }
            }
        }

        return result;
    }

    private double doOperation(double result, double component, String operation) {
        switch (operation){
            case OperationLiteral.Add: return result + component;
            case OperationLiteral.Subtract: return result - component;
            case OperationLiteral.Multiply: return result * component;
            case OperationLiteral.Divide: return result / component;
        }
        return result;
    }
}
