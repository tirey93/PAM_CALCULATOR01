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

    public String getResult(){
        try {
            if(listOperations.isEmpty() || currentNumber.isEmpty())
                return "";
            double listCalculated = calculateFromList();
            double result = doOperation(listCalculated, Double.parseDouble(currentNumber), getLastOperation().getValue());
            return String.valueOf(result);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
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

    public void putNeg(){
        if(isLastOperationAnOperation()){
            Operation operation = getLastOperation();
            if(operation.getValue().equals(OperationLiteral.Subtract)){
                listOperations.remove(operation);
                listOperations.add(new Operation(OperationType.Operation, OperationLiteral.Add));
            } else if(operation.getValue().equals(OperationLiteral.Add)){
                listOperations.remove(operation);
                listOperations.add(new Operation(OperationType.Operation, OperationLiteral.Subtract));
            }
            else {
                negHandleCurrentNumber();
            }
        }else {
            negHandleCurrentNumber();
        }
    }

    private void negHandleCurrentNumber() {
        if(currentNumber.isEmpty()){
            currentNumber = "-1";
        }else if(currentNumber.startsWith("-")){
            currentNumber = currentNumber.substring(1);
        }
        else{
            currentNumber = "-" + currentNumber;
        }
    }

    private double calculateFromList(){
        double result = Double.parseDouble(listOperations.get(0).getValue());
        String operation = "";

        for(Operation o : listOperations.subList(1, listOperations.size() - 1)) {
            switch (o.getType()) {
                case Number: {
                    result = doOperation(result, Double.parseDouble(o.getValue()), operation);
                    break;
                }
                case Operation: {
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

    private void handleOneArgOperations(String operation) throws CalculationException {
       throw new CalculationException("Unknown operation");
    }

    private void handleTwoArgOperations(String operation) throws CalculationException {
        if(isOperationToReplace()){
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

    private boolean isOperationToReplace() {
        return isLastOperationAnOperation() && currentNumber.isEmpty();
    }

    private boolean isLastOperationAnOperation() {
        return !listOperations.isEmpty()
                && getLastOperation().getType().equals(OperationType.Operation);
    }

    private Operation getLastOperation() {
        return listOperations.get(listOperations.size() - 1);
    }

    private boolean hasInputFirstArg() {
        return !currentNumber.isEmpty() && !currentNumber.equals("0.");
    }
}
