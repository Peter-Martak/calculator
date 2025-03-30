package sk.peter.calculator;

import sk.peter.Operands;
import sk.peter.operation.Operation;

import java.util.Map;

public abstract class AbstractCalculator {
    private final String name;
    private final Map<Character, Operation> operationMap;

    public AbstractCalculator(String name, Map<Character, Operation> operationMap) {
        this.name = name;
        this.operationMap = operationMap;
    }

    public double calculate(Operands operands, Character operator){
        if(this.operationMap.containsKey(operator)){
            final Operation operation = this.operationMap.get(operator);
            final double result = this.calculateResult(operands, operation);
            this.printResult(result);
            return result;
        }else {
            throw new IllegalArgumentException("Calculator doesn't support operation: " + operator);
        }
    }

    private double calculateResult(Operands operands, Operation operation){
        final double result = operation.calculate(operands.getLeft(), operands.getRight());
        return result;
    }

    private void printResult(double result){
        System.out.println(this.name + " calculated result " + result);
    }
}
