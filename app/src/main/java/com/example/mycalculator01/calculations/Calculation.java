package com.example.mycalculator01.calculations;
import androidx.lifecycle.ViewModel;

import com.example.mycalculator01.exceptions.CalculationException;
import com.example.mycalculator01.handlers.ClearHandler;
import com.example.mycalculator01.handlers.CommaHandler;
import com.example.mycalculator01.handlers.NegHandler;
import com.example.mycalculator01.handlers.OperationHandler;
import com.example.mycalculator01.handlers.ParenthesisHandler;
import com.example.mycalculator01.handlers.PercentHandler;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculation extends ViewModel {
    private State state = new State();

    public void clearCharacter() {
        state = new ClearHandler(state).clearCharacter();
    }

    public void clear(){
        state = new ClearHandler(state).clear();
    }

    public void clearAll(){
        state = new ClearHandler(state).clearAll();
    }

    public void putDigit(int digit){
        state.getNumber().push(String.valueOf(digit));
    }
    public void putComma() {
        state = new CommaHandler(state).handleComma();
    }
    public void putNeg(){
        state = new NegHandler(state).handleNeg();
    }
    public void putParenthesis() {
        state = new ParenthesisHandler(state).handle();
    }
    public void putTwoArgOperation(String operation) throws CalculationException {
        state = new OperationHandler(state).handleTwoArgOperation(operation);
    }
    public void putOneArgOperation(String operation) throws CalculationException {
        state = new OperationHandler(state).handleOneArgOperation(operation);
    }
    public void handleX2() throws CalculationException {
        state = new OperationHandler(state).handleTwoArgOperation("^");
        state.getNumber().setCurrentNumber("2");
    }
    public void handlePercent() {
        state = new PercentHandler(state).handle();
    }

    public void handleEqual(){
        state.getNumber().setCurrentNumber(getResult());
        state.getOperations().clear();
    }

    public String getInput() {
        List<String> res = state.getOperations().asList();
        String result = String.join(" ", res) + " " + state.getNumber().getCurrentNumber();

        result = result.replace(" ( ", "(");
        result = result.replace(" )", ")");
        return result;
    }

    public String getResult(){
        try {
            String input = getInput();
            String converted = convertInputForExp4j(input);
            Expression e = new ExpressionBuilder(converted)
                    .build();
            double result = e.evaluate();

            return String.valueOf(result);
        }
        catch (IllegalArgumentException ignored){

        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    private String convertInputForExp4j(String input){
        String result = input;
        result = replaceLiterals(result);
        result = closeParenthesis(result);

        if(input.contains("%")){
            Pattern pattern = Pattern.compile("([0-9]+%)");
            Matcher matcher = pattern.matcher(result);
            if(matcher.find()){
                String gr = matcher.group(1);

                String replace = result.replace(gr, "");
                String prev = replace.substring(0, replace.length() - 4);
                result = result.replace("%", " * (" + prev + ")/100");
            }

        }
        return result;
    }

    private String closeParenthesis(String result) {
        if(ParenthesisHandler.isOpen(state)){
            result += ")";
        }
        return result;
    }

    private static String replaceLiterals(String result) {
        for (Map.Entry<String, String> entry : OperationLiteral.ToExp4j.entrySet()) {
            result = result.replace(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
