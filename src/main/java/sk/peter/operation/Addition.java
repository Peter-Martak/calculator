package sk.peter.operation;

public class Addition implements Operation {
    @Override
    public double calculate(Double left, Double right) {
        return left + right;
    }
}
