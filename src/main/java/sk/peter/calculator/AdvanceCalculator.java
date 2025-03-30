package sk.peter.calculator;

import sk.peter.operation.ArithmeticOperator;
import sk.peter.operation.Operation;

import java.util.Map;

public class AdvanceCalculator extends AbstractCalculator{
    public AdvanceCalculator(String name, Map<ArithmeticOperator, Operation> operationMap) {
        super(name, operationMap);
    }
}
