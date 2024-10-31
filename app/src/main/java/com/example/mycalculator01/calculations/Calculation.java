package com.example.mycalculator01.calculations;


import com.example.mycalculator01.exceptions.CalculationException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Calculation {
    protected String input = "23+3-1";
    protected double result;

    public void putDigit(int digit){
        input += digit;
    }

    public void putOperation(String operations) throws CalculationException {
        throw new CalculationException("");
    }

    private List<Operation> getListOfOperations(String input){
        ArrayList<Operation> list = new ArrayList<Operation>();
        if(input.isEmpty())
            return list;
        if(!containsOperation(input))
            return list;

        //Value 23
        //Type Number

        //Value +
        //Type Op

        //Value 3
        //Type Number

        //Value -
        //Type Op

        //Value 1
        //Type Number

        List<Operation> firstOperations = getFirstOperation(input);
        list.addAll(firstOperations);
        Optional<Operation> operation = firstOperations.stream()
                .filter(x -> x.getOperationType() == OperationType.Operation)
                .findFirst();
        if(operation.isPresent()) {
            String trimmedInput = input.split(operation.get().getOperationType().toString())[1];
            list.addAll(getListOfOperations(trimmedInput));
        }

        return list;
    }

    private boolean containsOperation(String input){
        for (String literal : OperationLiteral.AllOperations.keySet()) {
            if(input.contains(literal))
                return true;
        }
        return false;
    }

    private List<Operation> getFirstOperation(String input){
        for (String literal : OperationLiteral.TwoArgOperations.keySet()) {
            if(input.contains(literal)){
                String[] splitted = input.split(literal);
                Operation number = new Operation(OperationType.Number, splitted[0]);
                Operation operation = new Operation(OperationType.Operation, literal);
                return List.of(number, operation);
            }
        }

        for (String literal : OperationLiteral.OneArgOperations.keySet()) {
            if(input.contains(literal)){
                Operation operation = new Operation(OperationType.Operation, literal);
                return List.of(operation);
            }
        }

        return Collections.emptyList();
    }
}
