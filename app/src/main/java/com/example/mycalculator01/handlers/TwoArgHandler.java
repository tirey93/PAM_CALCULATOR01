package com.example.mycalculator01.handlers;

import com.example.mycalculator01.calculations.Operation;
import com.example.mycalculator01.calculations.OperationLiteral;
import com.example.mycalculator01.calculations.OperationType;
import com.example.mycalculator01.calculations.State;
import com.example.mycalculator01.exceptions.CalculationException;

public class TwoArgHandler {
    private final State state;

    public TwoArgHandler(State state) {
        this.state = state;
    }

    public State handleTwoArgOperation(String operation) throws CalculationException {
        if(OperationLiteral.TwoArgOperations.containsKey(operation)) {
            handleTwoArgOperations(operation);
            return state;
        }

        throw new CalculationException("Unknown operation");
    }

    public void pushNumber() throws CalculationException {
        if(!hasInputFirstArg())
            throw new CalculationException("Please type a number.");

        if(state.getNumber().last().equals(".")) {
            state.getNumber().pop();
        }
        state.getOperations().push(new Operation(OperationType.Number, state.getNumber().getCurrentNumber()));
        state.getNumber().clear();
    }

    private void handleTwoArgOperations(String operation) throws CalculationException {
    if(!state.getOperations().isEmpty() && state.getNumber().isEmpty() && !state.getOperations().last().getType().equals(OperationType.OneArgAfterOperation)){
            state.getOperations().pop();
        }
        else {
            pushNumber();
        }
        state.getOperations().push(new Operation(OperationType.TwoArgOperation, operation));
    }


    private boolean hasInputFirstArg() {
        return !state.getNumber().isEmpty() && !state.getNumber().getCurrentNumber().equals("0.");
    }
}
