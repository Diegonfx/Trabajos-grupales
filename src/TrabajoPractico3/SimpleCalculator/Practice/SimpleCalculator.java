package TrabajoPractico3.SimpleCalculator.Practice;

import TrabajoPractico3.SimpleCalculator.Scanner;
import TrabajoPractico3.Stacks.DynamicStack.DynamicStack;

/**
 * Creates a calculator which can do the following operations : '+', '-', '*' and '/'
 * @author Tomas Iturralde
 * @author Diego Mancini
 **/
public class SimpleCalculator {

    private int finalResult;
    private DynamicStack<Integer> result;
    private DynamicStack<Integer> firstNumber;
    private DynamicStack<Character> operator;


    public SimpleCalculator() {
        finalResult = 0;
        result = new DynamicStack<>();
        firstNumber = new DynamicStack<>();
        operator = new DynamicStack<>();
    }

    private void askForOperation() {

        String input = Scanner.getString("Insert operation: " );
        int counter = 0;
        for (int i = 0 ; i < input.length() ; i++) {
            if(input.charAt(i) == '-' || input.charAt(i) == '+' || input.charAt(i) == '*' || input.charAt(i) == '/'){
                int number = Integer.parseInt(input.substring(counter, i));
                counter = i + 1;
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
    private void substract(){
        askForOperation();
        int num1 = firstNumber.peek();
        firstNumber.pop();
        int num2 = firstNumber.peek();
        firstNumber.pop();
        if (operator.peek() == '-') {
            result.push(num2 - num1 );
            operator.pop();
        }
        finalResult = result.peek();
        result.pop();
    }
    private void multiply(){
       askForOperation();
        int num1 = firstNumber.peek();
        firstNumber.pop();
        int num2 = firstNumber.peek();
        firstNumber.pop();
        result.push(num1 * num2 );
        operator.pop();
        finalResult = result.peek();
        result.pop();
    }
    private void divide(){
        askForOperation();
        int num1 = firstNumber.peek();
        firstNumber.pop();
        int num2 = firstNumber.peek();
        firstNumber.pop();
        result.push(num2 / num1 );
        operator.pop();
        finalResult = result.peek();
        result.pop();
    }
    private boolean isSum(char operator) {
        if (operator == '+') {
            return true;
        } else return false;
    }
    private boolean isSubstract(char operator) {
        if (operator == '-') {
            return true;
        } else return false;
    }
    private boolean isDivide(char operator) {
        if (operator == '/') {
            return true;
        } else return false;
    }
    private boolean isMultiply(char operator) {
        if (operator == '*') {
            return true;
        } else return false;
    }

    public void operate() {

        boolean operate = true;

        while(operate) {
            System.out.println("\nWelcome to calculator menu \n");
            System.out.println("Choose operations please: \n" +
                    "1 - Sum \n" +
                    "2 - Substract \n" +
                    "3 - Multiply \n" +
                    "4 - Divide \n" +
                    "5 - Multioperation \n" +
                    "6 - Salir");
            int scanner = Scanner.getInt("Ingrese la operacion deseada: ");
            switch (scanner) {
                case 1:
                    sum();
                    System.out.println("Result is: " + getFinalResult());
                    break;
                case 2:
                    substract();
                    System.out.println("Result is: " + getFinalResult());
                    break;
                case 3:
                    multiply();
                    System.out.println("Result is: " + getFinalResult());
                    break;
                case 4:
                    divide();
                    System.out.println("Result is: " + getFinalResult());
                    break;
                case 5:
                    System.out.println("Result is: " + getFinalResult());
                    break;
                case 6:
                    operate = false;
                System.exit(0);
                    break;
                default:
                System.exit(0);
                    break;
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
