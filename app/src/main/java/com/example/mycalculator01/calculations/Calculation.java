package com.example.mycalculator01.calculations;
import com.example.mycalculator01.exceptions.CalculationException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculation {
    private String currentNumber = "";
    private String currentOperation = "";
    protected double result;

    private List<Operation> listOperations = new ArrayList<>();

    public void putDigit(int digit){
        currentNumber += digit;
    }
    public void putComma() {
        if(currentNumber.contains("."))
            return;
        if (currentNumber.isEmpty() || isLastElementComma()){
            currentNumber = "0.";
        }else{
            currentNumber += ".";
        }
    }

    public void putOperation(String operation) throws CalculationException {
        if(OperationLiteral.OneArgOperations.containsKey(operation)) {
            handleOneArgOperations(operation);
            return;
        }
        if(OperationLiteral.TwoArgOperations.containsKey(operation)) {
            handleTwoArgOperations(operation);
            return;
        }

        throw new CalculationException("Unknown operation");
    }

    public String getInput() {
        List<String> res = listOperations.stream().map(Operation::getValue).collect(Collectors.toList());
        return String.join(" ", res) + " " + currentNumber;
    }

    public double getResult(){

        return result;
    }

    public void clear(){
        if(listOperations.isEmpty() && currentNumber.isEmpty())
            return;

        if(!listOperations.isEmpty() && currentNumber.isEmpty())
            listOperations.remove(listOperations.size() - 1);
        else
            currentNumber = "";
    }

    public void clearAll(){
        listOperations.clear();
        currentNumber = "";
        currentOperation = "";
    }

    private void handleOneArgOperations(String operation) throws CalculationException {
       throw new CalculationException("Unknown operation");
    }

    private void handleTwoArgOperations(String operation) throws CalculationException {
        if(isCharacterToReplace()){
            listOperations.remove(listOperations.size() - 1);
        }
        else {
            if(!hasInputFirstArg())
                throw new CalculationException("Please type first number.");

            if(isLastElementComma()) {
                currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
            }
            listOperations.add(new Operation(OperationType.Number, currentNumber));
            currentNumber = "";
        }
        listOperations.add(new Operation(OperationType.Operation, operation));
        currentOperation = operation;
    }

    private boolean isLastElementComma() {
        return currentNumber.toCharArray()[currentNumber.length() - 1] == '.';
    }

    private boolean isCharacterToReplace() {
        return !listOperations.isEmpty()
                && listOperations.get(listOperations.size() - 1).getOperationType().equals(OperationType.Operation)
                && currentNumber.isEmpty();
    }

    private boolean hasInputFirstArg() {
        return !currentNumber.isEmpty() && !currentNumber.equals("0.");
    }
}
