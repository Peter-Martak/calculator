package sk.peter;

import sk.peter.calculator.AbstractCalculator;
import sk.peter.calculator.CalculatorHolder;
import sk.peter.operation.ArithmeticOperator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static CalculatorHolder calculatorHolder = new CalculatorHolder();
    public static void main(String[] args) {
       do {
           System.out.println("Write number, then type of operation (+, -, *, /) and then write number again");
           final double left, right;
           final ArithmeticOperator operator;

           try {
               left = scanner.nextDouble();
               final String line = scanner.next();
               operator = ArithmeticOperator.getFromSymbol(line);
               right = scanner.nextDouble();
           } catch (InputMismatchException | IllegalArgumentException e){
               System.out.println("invalid input");
               scanner.nextLine();
               continue;
           }

           final Operands operands = new Operands(left, right);
           final AbstractCalculator calculator = calculatorHolder.getSuitableCalculator(operator);
           calculator.calculate(operands,operator);
           calculatorHolder.getSuitableCalculator(operator);
      }while (true);
    }
}
