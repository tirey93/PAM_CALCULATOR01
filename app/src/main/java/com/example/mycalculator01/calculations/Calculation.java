package com.example.mycalculator01.calculations;
import androidx.lifecycle.ViewModel;

import com.example.mycalculator01.exceptions.CalculationException;
import com.example.mycalculator01.handlers.ClearHandler;
import com.example.mycalculator01.handlers.CommaHandler;
import com.example.mycalculator01.handlers.NegHandler;
import com.example.mycalculator01.handlers.OperationHandler;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.List;
import java.util.Map;

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
        state = new OperationHandler(state).handleTwoArgOperation(operation);
    }
    public void handleX2() throws CalculationException {
        state = new OperationHandler(state).handleTwoArgOperation("^");
        state.getOperations().push(new Operation(OperationType.Number, "2"));
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

            String input = convertInputForExp4j(getInput());
            Expression e = new ExpressionBuilder(input)
                    .build();
            double result = e.evaluate();

            return String.valueOf(result);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    private String convertInputForExp4j(String input){
        String result = input;
        for (Map.Entry<String, String> entry : OperationLiteral.ToExp4j.entrySet()) {
            result = result.replace(entry.getKey(), entry.getValue());
        }
        return result;
    }


}
