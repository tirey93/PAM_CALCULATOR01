package com.example.mycalculator01.handlers;

import com.example.mycalculator01.calculations.Operation;
import com.example.mycalculator01.calculations.OperationLiteral;
import com.example.mycalculator01.calculations.OperationType;
import com.example.mycalculator01.calculations.State;

public class ParenthesisHandler {
    private final State state;

    public ParenthesisHandler(State state) {
        this.state = state;
    }

    public State handle(){
        if(isOpen(state)){
            if(!state.getNumber().isEmpty()){
                state.getOperations().push(new Operation(OperationType.Number, state.getNumber().getCurrentNumber()));
                state.getNumber().clear();
            }
            state.getOperations().push(new Operation(OperationType.None, ")"));
        }
        return state;
    }

    public static boolean isOpen(State state){

        String input = String.join("", state.getOperations().asList());

        int opens = input.length() - input.replace("(", "").length();
        int close = input.length() - input.replace(")", "").length();

        return opens > close;
    }
}
