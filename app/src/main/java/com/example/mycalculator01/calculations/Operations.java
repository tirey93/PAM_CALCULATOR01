package com.example.mycalculator01.calculations;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Operations {
    private Stack<Operation> operationStack = new Stack<>();

    public Stack<Operation> getOperationStack() {
        return operationStack;
    }

    public boolean isEmpty(){
        return operationStack.isEmpty();
    }

    public void setOperationStack(Stack<Operation> operationStack) {
        this.operationStack = operationStack;
    }


    public Operation pop(){
        return operationStack.pop();
    }

    public void clear(){
        this.operationStack = new Stack<>();
    }

    public void push(Operation operation){
        operationStack.push(operation);
    }
    public Operation last(){
        return operationStack.lastElement();
    }
    public Operation first(){
        return operationStack.firstElement();
    }
    public List<String> asList(){
        return operationStack.stream().map(Operation::getValue).collect(Collectors.toList());
    }

    public List<Operation> fromSecondOperation(){
        return operationStack.subList(1, operationStack.size() - 1);
    }
}
