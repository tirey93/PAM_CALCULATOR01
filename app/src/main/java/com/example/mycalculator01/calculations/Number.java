package com.example.mycalculator01.calculations;

import java.util.Stack;

public class Number {
    private Stack<String> currentNumber = new Stack<>();

    public  boolean isEmpty(){
        return  currentNumber.isEmpty();
    }

    public String getCurrentNumber() {
        return String.join("", currentNumber);
    }

    public void clear() {
        this.currentNumber = new Stack<>();
    }

    public void push(String element) {
        this.currentNumber.push(element);
    }

    public String pop() {
        return this.currentNumber.pop();
    }
    public void setCurrentNumber(String number){
        currentNumber = new Stack<>();
        currentNumber.push(number);
    }

    public boolean contains(String element){
        return currentNumber.contains(element);
    }

    public String first(){
        return currentNumber.firstElement();
    }

    public String last(){
        return currentNumber.lastElement();
    }
}
