package TrabajoPractico3.SimpleCalculator.Practice;

import TrabajoPractico3.SimpleCalculator.Scanner;
import TrabajoPractico3.Stacks.DynamicStack.DynamicStack;

/**
 * Created by DiegoMancini on 24/3/17.
 */
public class SimpleCalculator {

    private int finalResult;
    private char[] string;
    private DynamicStack<Integer> result;
    private DynamicStack<Integer> firstNumber;
    private DynamicStack<Character> operator;
    private DynamicStack<Integer> secondNumber;

    public SimpleCalculator() {
        finalResult = 0;
        result = new DynamicStack<>();
        firstNumber = new DynamicStack<>();
        operator = new DynamicStack<>();
        secondNumber = new DynamicStack<>();
        string = null;
    }

    private void askForOperation() {

        String input = Scanner.getString("Insert operation: " );
        string = input.toCharArray();
        for (int i = 0 ; i < string.length ; i++) {
            if (string[i] == '1' || string[i] == '2' || string[i] == '3' || string[i] == '4' || string[i] == '5' || string[i] == '6' || string[i] == '7'
                    || string[i] == '8' || string[i] == '9' || string[i] == '0') {
                firstNumber.push((Character.getNumericValue(string[i])));
            } else if (string[i] != '+' || string[i] != '-' || string[i] != '/' || string[i] != '*') {
                operator.push(string[i]);
                while (string[i] != '+' || string[i] != '-' || string[i] != '/' || string[i] != '*' )
                secondNumber.push(Character.getNumericValue(string[i+1]));
            }
        }
    }

    public void sum() {
        askForOperation();
        result.push(firstNumber.peek() + secondNumber.peek() );
        firstNumber.pop();
        secondNumber.pop();
        operator.pop();
        finalResult = result.peek();
    }

    public void substract(){
        askForOperation();
        result.push(firstNumber.peek() - secondNumber.peek() );
        firstNumber.pop();
        secondNumber.pop();
        operator.pop();
        finalResult = result.peek();
    }

    public void multiply(){
        askForOperation();
        result.push(firstNumber.peek() * secondNumber.peek() );
        firstNumber.pop();
        secondNumber.pop();
        operator.pop();
        finalResult = result.peek();
    }

    public void divide(){
        askForOperation();
        result.push(firstNumber.peek() / secondNumber.peek() );
        firstNumber.pop();
        secondNumber.pop();
        operator.pop();
        finalResult = result.peek();
    }

    public void operate() {

        while(true) {
            System.out.println("Welcome to calculator menu \n");
            System.out.println("Choose operations please: \n" +
                    "1 - Sum \n" +
                    "2 - Substract \n" +
                    "3 - Multiply \n" +
                    "4 - Divide \n" +
                    "5 - Salir");
            int scanner = Scanner.getInt("Ingrese la operacion deseada: ");
            switch (scanner) {
                case 1:
                    sum();
                    System.out.println("Result is: " + getFinalResult());
                case 2:
                    substract();
                    System.out.println("Result is: " + getFinalResult());
                case 3:
                    multiply();
                    System.out.println("Result is: " + getFinalResult());
                case 4:
                    divide();
                    System.out.println("Result is: " + getFinalResult());
                case 5:
                    System.exit(0);
            }
        }
    }

    //Getters
    public int getFinalResult() {
        return finalResult;
    }
    public DynamicStack<Integer> getResult() {
        return result;
    }
    public DynamicStack<Integer> getFirstNumber() {
        return firstNumber;
    }
    public DynamicStack<Character> getOperator() {
        return operator;
    }
    public DynamicStack<Integer> getSecondNumber() {
        return secondNumber;
    }
}
