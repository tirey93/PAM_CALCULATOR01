package com.example.mycalculator01.calculations;
import com.example.mycalculator01.exceptions.CalculationException;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Calculation {
    private String currentNumber = "";
    private final Stack<Operation> operationStack = new Stack<>();

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
        List<String> res = operationStack.stream().map(Operation::getValue).collect(Collectors.toList());
        return String.join(" ", res) + " " + currentNumber;
    }

    public String getResult(){
        try {
            if(operationStack.isEmpty() || currentNumber.isEmpty())
                return "";
            double listCalculated = calculateFromList();
            double result = doOperation(listCalculated, Double.parseDouble(currentNumber), operationStack.lastElement().getValue());
            return String.valueOf(result);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearCharacter() {
        if(!currentNumber.isEmpty()){
            currentNumber = currentNumber.substring(0, currentNumber.length() -1);
        }
        else if(!operationStack.isEmpty()){
            popFromList();
        }
    }

    private void popFromList() {
        operationStack.pop();
        currentNumber = operationStack.lastElement().getValue();
        operationStack.pop();
    }

    public void clear(){
        if(operationStack.isEmpty() && currentNumber.isEmpty())
            return;

        if(!operationStack.isEmpty() && currentNumber.isEmpty())
            popFromList();
        else
            currentNumber = "";
    }

    public void clearAll(){
        operationStack.clear();
        currentNumber = "";
    }

    public void putNeg(){
        if(isLastOperationAnOperation()){
            Operation operation = operationStack.lastElement();
            if(operation.getValue().equals(OperationLiteral.Subtract)){
                operationStack.remove(operation);
                operationStack.add(new Operation(OperationType.Operation, OperationLiteral.Add));
            } else if(operation.getValue().equals(OperationLiteral.Add)){
                operationStack.remove(operation);
                operationStack.add(new Operation(OperationType.Operation, OperationLiteral.Subtract));
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
        double result = Double.parseDouble(operationStack.get(0).getValue());
        String operation = "";

        for(Operation o : operationStack.subList(1, operationStack.size() - 1)) {
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
            operationStack.remove(operationStack.size() - 1);
        }
        else {
            if(!hasInputFirstArg())
                throw new CalculationException("Please type first number.");

            if(isLastElementComma()) {
                currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
            }
            operationStack.add(new Operation(OperationType.Number, currentNumber));
            currentNumber = "";
        }
        operationStack.add(new Operation(OperationType.Operation, operation));
    }

    private boolean isLastElementComma() {
        return currentNumber.toCharArray()[currentNumber.length() - 1] == '.';
    }

    private boolean isOperationToReplace() {
        return isLastOperationAnOperation() && currentNumber.isEmpty();
    }

    private boolean isLastOperationAnOperation() {
        return !operationStack.isEmpty()
                && operationStack.lastElement().getType().equals(OperationType.Operation);
    }


    private boolean hasInputFirstArg() {
        return !currentNumber.isEmpty() && !currentNumber.equals("0.");
    }
}
