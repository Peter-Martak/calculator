package sk.peter;

import sk.peter.calculator.AbstractCalculator;
import sk.peter.calculator.CalculatorHolder;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static CalculatorHolder calculatorHolder = new CalculatorHolder();
    public static void main(String[] args) {
       do {
           System.out.println("Write number, then type of operation (+, -, *, /) and then write number again");
           double left, right;
           char operator;

           try {
               left = scanner.nextDouble();
               operator = scanner.next().charAt(0);
               right = scanner.nextDouble();
           } catch (InputMismatchException e){
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
