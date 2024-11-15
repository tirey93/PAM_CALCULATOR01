package com.example.mycalculator01.handlers;

import com.example.mycalculator01.calculations.State;

import java.util.Stack;

public class ClearHandler {
    private final State state;
    public ClearHandler(State state){
        this.state = state;
    }

    public State clearCharacter() {
        if(!state.getNumber().isEmpty()){
            state.getNumber().pop();
        }
        else if(!state.getOperations().isEmpty()){
            popFromState();
        }
        return state;
    }

    public State clear(){
        if(state.getOperations().isEmpty() && state.getNumber().isEmpty())
            return state;

        if(!state.getOperations().isEmpty() && state.getNumber().isEmpty())
            popFromState();
        else
            state.getNumber().clear();
        return state;
    }

    public State clearAll(){
        state.getNumber().clear();
        state.getOperations().clear();
        return state;
    }


    private void popFromState() {
        state.getOperations().pop();
        state.getNumber().setCurrentNumber(state.getOperations().last().getValue());
        state.getOperations().pop();
    }
}
