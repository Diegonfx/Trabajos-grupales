package TrabajoPractico4_Queue;

import TrabajoPractico3.SimpleCalculator.Scanner;
import TrabajoPractico3.Stacks.DynamicStack.DynamicStack;

/**
 * Class used to find if a word is a palindrome. (Palindrome being a word which can be read from left to right, or from right
 * to left. Ej: the word neuquen is a palindrome)
 * @author Diego Mancini
 * @author Tomas Iturralde
 */
public class Palindrome {
    private DynamicQueue<Character> queueOfCharacters = new DynamicQueue<>();
    private DynamicStack<Character> stackOfCharacters = new DynamicStack<>();

    public boolean isPalindrome() {
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
            }
            stackOfCharacters.pop();
            queueOfCharacters.dequeue();
        }
        return result;
    }

    public static void main(String[] args) {
        Palindrome a = new Palindrome();
        System.out.println(a.isPalindrome());
    }
}
