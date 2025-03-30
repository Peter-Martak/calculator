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
        final Map<ArithmeticOperator, Operation> basicCalculatorOperationMap = new HashMap<>();
        basicCalculatorOperationMap.put(ArithmeticOperator.ADDITION, new Addition());
        basicCalculatorOperationMap.put(ArithmeticOperator.SUBTRACTION, new Substraction());

        this.basicCalculator = new BasicCalculator("Basic Calculator", basicCalculatorOperationMap);

        final Map<ArithmeticOperator, Operation> advancedCalculatorOperationMap = new HashMap<>();
        advancedCalculatorOperationMap.put(ArithmeticOperator.MULTIPLICATION, new Multiplication());
        advancedCalculatorOperationMap.put(ArithmeticOperator.DIVISION, new Division());

        this.advanceCalculator = new AdvanceCalculator("Advanced Calculator", advancedCalculatorOperationMap);
    }

    public AbstractCalculator getSuitableCalculator(ArithmeticOperator operator){
        switch (operator){
            case ADDITION, SUBTRACTION -> {
                return this.basicCalculator;
            }
            case MULTIPLICATION, DIVISION -> {
                return this.advanceCalculator;
            }
            default -> throw new IllegalArgumentException("Unsupported Operation");
        }
    }
}
