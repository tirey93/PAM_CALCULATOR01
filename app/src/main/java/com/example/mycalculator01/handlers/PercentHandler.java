package com.example.mycalculator01.handlers;

import com.example.mycalculator01.calculations.Operation;
import com.example.mycalculator01.calculations.OperationType;
import com.example.mycalculator01.calculations.State;

public class PercentHandler {
    private final State state;

    public PercentHandler(State state) {
        this.state = state;
    }

    public State handle(){
        if(state.getOperations().isEmpty()){
            return state;
        }
        if(state.getOperations().last().getValue().contains("%")){
            return state;
        }
        if(state.getOperations().last().getType().equals(OperationType.None)){
            return state;
        }
        if(!state.getNumber().isEmpty() && state.getNumber().last().equals(".")) {
            return state;
        }

        state.getOperations().push(new Operation(OperationType.Number, state.getNumber().getCurrentNumber() + "%"));
        state.getNumber().clear();
        return state;
    }
}
