package TrabajoPractico4_Queue;

import TrabajoPractico3.SimpleCalculator.Scanner;
import TrabajoPractico3.Stacks.DynamicStack.DynamicStack;

/**
 * Created by DiegoMancini on 7/4/17.
 */
public class Palindrome {
    private static DynamicQueue<Character> queueOfCharacters = new DynamicQueue<>();
    private static DynamicStack<Character> stackOfCharacters = new DynamicStack<>();

    public static boolean isPalindrome() {
        boolean result = true;
        String wordToAnalyze = Scanner.getString("Ingrese una palabra a analizar: ");
        char[] listOfLetters = wordToAnalyze.toLowerCase().toCharArray();
        for (int i = 0 ; i < listOfLetters.length ; i++) {
            queueOfCharacters.enqueue(listOfLetters[i]);
            stackOfCharacters.push(listOfLetters[i]);
        }
        for (int i = 0 ; i < listOfLetters.length ; i++) {
            if (!stackOfCharacters.peek().equals(queueOfCharacters.getFront())) {
                result = false;
                stackOfCharacters.pop();
                queueOfCharacters.dequeue();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome());
    }
}
