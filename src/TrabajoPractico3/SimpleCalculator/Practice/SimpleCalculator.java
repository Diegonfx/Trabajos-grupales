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


    public SimpleCalculator() {
        finalResult = 0;
        result = new DynamicStack<>();
        firstNumber = new DynamicStack<>();
        operator = new DynamicStack<>();

        string = null;
    }

    private void askForOperation() {

        String input = Scanner.getString("Insert operation: " );
        int counter = 0;
        for (int i = 0 ; i < input.length() ; i++) {
            if(input.charAt(i) == '-' || input.charAt(i) == '+'){
                int number = Integer.parseInt(input.substring(counter, i));
                counter= i + 1;
                firstNumber.push(number);
                char oper = input.charAt(i);
                operator.push(oper);
            }
        }
        int num = Integer.parseInt(input.substring(counter, input.length()));
        firstNumber.push(num);
    }

    private void sum() {
        askForOperation();
        int num1 = firstNumber.peek();
        firstNumber.pop();
        int num2 = firstNumber.peek();
        firstNumber.pop();
        result.push(num1 + num2 );
        operator.pop();
        finalResult = result.peek();
        result.pop();
    }
/*
    private void substract(){
        askForOperation();
        result.push(firstNumber.peek() - secondNumber.peek() );
        firstNumber.pop();
        secondNumber.pop();
        operator.pop();
        finalResult = result.peek();
        result.pop();
    }

    private void multiply(){
        askForOperation();
        result.push(firstNumber.peek() * secondNumber.peek() );
        firstNumber.pop();
        secondNumber.pop();
        operator.pop();
        finalResult = result.peek();
        result.pop();
    }

    private void divide(){

        askForOperation();
        result.push(firstNumber.peek() / secondNumber.peek() );
        firstNumber.pop();
        secondNumber.pop();
        operator.pop();
        finalResult = result.peek();
        result.pop();
    }
*/
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
                /*case 2:
                    substract();
                    System.out.println("Result is: " + getFinalResult());
                case 3:
                    multiply();
                    System.out.println("Result is: " + getFinalResult());
                case 4:
                    divide();
                    System.out.println("Result is: " + getFinalResult());
                case 5:
                    System.exit(0);*/
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
}
