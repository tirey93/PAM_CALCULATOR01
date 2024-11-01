package com.example.mycalculator01.handlers;

import com.example.mycalculator01.calculations.Operation;
import com.example.mycalculator01.calculations.OperationLiteral;
import com.example.mycalculator01.calculations.OperationType;
import com.example.mycalculator01.calculations.State;

public class NegHandler {
    private final State state;

    public NegHandler(State state) {
        this.state = state;
    }

    public State handleNeg(){
        if(!state.getOperations().isEmpty()){
            Operation operation = state.getOperations().last();
            if(operation.getValue().equals(OperationLiteral.Subtract)){
                state.getOperations().pop();
                state.getOperations().push(new Operation(OperationType.Operation, OperationLiteral.Add));
            } else if(operation.getValue().equals(OperationLiteral.Add)){
                state.getOperations().pop();
                state.getOperations().push(new Operation(OperationType.Operation, OperationLiteral.Subtract));
            }
            else {
                negHandleCurrentNumber();
            }
        }else {
            negHandleCurrentNumber();
        }
        return state;
    }

    private void negHandleCurrentNumber() {
        if(state.getNumber().isEmpty()){
            state.getNumber().setCurrentNumber("-1");
        }else if(state.getNumber().first().contains("-")){
            state.getNumber().setCurrentNumber(state.getNumber().getCurrentNumber().substring(1));
        }
        else{
            String old = state.getNumber().getCurrentNumber();
            state.getNumber().setCurrentNumber("-");
            state.getNumber().push(old);
        }
    }
}
