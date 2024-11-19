package com.example.mycalculator01.handlers;

import com.example.mycalculator01.calculations.Operation;
import com.example.mycalculator01.calculations.OperationLiteral;
import com.example.mycalculator01.calculations.OperationType;
import com.example.mycalculator01.calculations.State;
import com.example.mycalculator01.exceptions.CalculationException;

public class OperationHandler {
    private final State state;

    public OperationHandler(State state) {
        this.state = state;
    }

    public State handleTwoArgOperation(String operation) throws CalculationException {
        if(OperationLiteral.TwoArgOperations.contains(operation)) {
            handleTwoArgOperations(operation);
            return state;
        }

        throw new CalculationException("Unknown operation");
    }

    public State handleOneArgOperation(String operation) throws CalculationException {
        if(OperationLiteral.OneArgOperations.contains(operation)) {
            handleOneArgOperations(operation);
            return state;
        }

        throw new CalculationException("Unknown operation");
    }

    public void pushNumber() throws CalculationException {
        if(!hasInputFirstArg())
            throw new CalculationException("Please type a number.");

        if(!state.getNumber().isEmpty() && state.getNumber().last().equals(".")) {
            state.getNumber().pop();
        }
        state.getOperations().push(new Operation(OperationType.Number, state.getNumber().getCurrentNumber()));
        state.getNumber().clear();
    }

    private void handleOneArgOperations(String operation) throws CalculationException {
        if(!state.getNumber().isEmpty() && state.getNumber().last().equals(".")) {
            state.getNumber().pop();
        }
        if(!state.getNumber().isEmpty()){
            state.getOperations().push(new Operation(OperationType.Number, state.getNumber().getCurrentNumber()));
            state.getOperations().push(new Operation(OperationType.TwoArgOperation, OperationLiteral.Multiply));
            state.getNumber().clear();
        }
        state.getOperations().push(new Operation(OperationType.OneArgOperation, operation));
        state.getOperations().push(new Operation(OperationType.None, "("));
    }
    private void handleTwoArgOperations(String operation) throws CalculationException {
        if(shouldLastOperationBeReplaced()){
            state.getOperations().pop();
        }
        else {
            pushNumber();
        }
        state.getOperations().push(new Operation(OperationType.TwoArgOperation, operation));
    }

    private boolean shouldLastOperationBeReplaced() {
        return !state.getOperations().isEmpty() && state.getNumber().isEmpty() && !state.getOperations().last().getType().equals(OperationType.None);
    }

    private boolean hasInputFirstArg() {
        return (!state.getNumber().isEmpty() && !state.getNumber().getCurrentNumber().equals("0."))
                || (!state.getOperations().isEmpty() && state.getOperations().last().getType().equals(OperationType.None));
    }
}
