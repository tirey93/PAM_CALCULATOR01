package com.example.mycalculator01.calculations;
import com.example.mycalculator01.exceptions.CalculationException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculation {
    private String currentNumber = "";
    private String currentOperation = "";
    protected double result;

    private List<Operation> operations = new ArrayList<>();

    public void putDigit(int digit){
        currentNumber += digit;
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
        List<String> res = operations.stream().map(Operation::getValue).collect(Collectors.toList());
        return String.join(" ", res) + " " + currentNumber;
    }

    public double getResult(){

        return result;
    }

    private void handleOneArgOperations(String operation) throws CalculationException {
       throw new CalculationException("Unknown operation");
    }

    private void handleTwoArgOperations(String operation) throws CalculationException {
        if(isCharacterToReplace()){
            operations.remove(operations.size() - 1);
        }
        else {
            if(!hasInputFirstArg())
                throw new CalculationException("Please type first number.");
            if(!currentNumber.isEmpty()){
                operations.add(new Operation(OperationType.Number, currentNumber));
                currentNumber = "";
            }
        }
        operations.add(new Operation(OperationType.Operation, operation));
        currentOperation = operation;
    }

    private boolean isCharacterToReplace() {
        return !operations.isEmpty()
                && operations.get(operations.size() - 1).getOperationType().equals(OperationType.Operation)
                && currentNumber.isEmpty();
    }

    private boolean hasInputFirstArg() {
        return !currentNumber.isEmpty();
    }
}
