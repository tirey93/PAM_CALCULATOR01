package com.example.mycalculator01.handlers;

import com.example.mycalculator01.calculations.Operation;
import com.example.mycalculator01.calculations.OperationLiteral;
import com.example.mycalculator01.calculations.OperationType;
import com.example.mycalculator01.calculations.State;
import com.example.mycalculator01.exceptions.CalculationException;

public class OneArgHandler {
    private final State state;

    public OneArgHandler(State state) {
        this.state = state;
    }

    public State handleOneArgBefore(String operation){

        return state;
    }

    public State handleOneArgAfter(String operation) throws CalculationException {
        if(!OperationLiteral.OneArgAfterOperations.containsKey(operation)){
            throw new CalculationException("Unknown operation");
        }
        new TwoArgHandler(state).pushNumber();
        state.getOperations().push(new Operation(OperationType.OneArgAfterOperation, operation));
        return state;
    }
}
