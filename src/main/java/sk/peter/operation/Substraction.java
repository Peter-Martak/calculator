package sk.peter.operation;

public class Substraction implements Operation{
    @Override
    public double calculate(Double left, Double right) {
        return left - right;
    }
}
