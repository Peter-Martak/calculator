package sk.peter.operation;

public enum ArithmeticOperator {

    ADDITION('+'),
    SUBTRACTION('-'),
    MULTIPLICATION('*'),
    DIVISION('/');

    private final char symbol;

    ArithmeticOperator(char symbol){
        this.symbol = symbol;
    }

    public static ArithmeticOperator getFromSymbol(String line){
        if (line.length() == 1) {
            for (ArithmeticOperator operator : ArithmeticOperator.values()) {
                if (operator.symbol == line.charAt(0)) {
                    return operator;
                }
            }
        }
        throw  new IllegalArgumentException();
    }
}
