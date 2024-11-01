package com.example.mycalculator01.handlers;

import com.example.mycalculator01.calculations.State;

public class CommaHandler {
    private final State state;

    public CommaHandler(State state) {
        this.state = state;
    }

    public State handleComma(){
        if(state.getNumber().contains("."))
            return state;
        if (state.getNumber().isEmpty() || state.getNumber().last().equals(".")){
            state.getNumber().setCurrentNumber("0.");
        }else{
            state.getNumber().push(".");
        }
        return state;
    }
}
