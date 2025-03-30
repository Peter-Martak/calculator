package sk.peter.calculator;

import sk.peter.operation.*;

import java.util.HashMap;
import java.util.Map;

public class CalculatorHolder {
    private BasicCalculator basicCalculator;
    private AdvanceCalculator advanceCalculator;

    public CalculatorHolder(){
        this.initializeCalculator();
    }

    public void initializeCalculator(){
        final Map<Character, Operation> basicCalculatorOperationMap = new HashMap<>();
        basicCalculatorOperationMap.put('+', new Addition());
        basicCalculatorOperationMap.put('-', new Substraction());

        this.basicCalculator = new BasicCalculator("Basic Calculator", basicCalculatorOperationMap);

        final Map<Character, Operation> advancedCalculatorOperationMap = new HashMap<>();
        advancedCalculatorOperationMap.put('*', new Multiplication());
        advancedCalculatorOperationMap.put('/', new Division());

        this.advanceCalculator = new AdvanceCalculator("Advanced Calculator", advancedCalculatorOperationMap);
    }

    public AbstractCalculator getSuitableCalculator(char operator){
        switch (operator){
            case '+', '-' -> {
                return this.basicCalculator;
            }
            case '*', '/' -> {
                return this.advanceCalculator;
            }
            default -> throw new IllegalArgumentException("Unsupported Operation");
        }
    }
}
