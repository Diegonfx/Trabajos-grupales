package TrabajoPractico3.LexicographicAnalyzer.Exercise;

import TrabajoPractico3.Stacks.DynamicStack.DynamicStack;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by DiegoMancini on 24/3/17.
 */
public class LexicographicAnalyzer {

    private int errors;
    private DynamicStack<Character> openCharacters;


    public LexicographicAnalyzer() {
        errors = 0;
        openCharacters = new DynamicStack<>();
    }

    /**
     * analyzes the text (converted into a String) and searches for '(', '{' or '['. If it finds any it stores the char
     * found on a stack. If the closing char is found, it pops the stack.
     * @param file converted into a String.
     * @throws IOException
     */
    public void analizeText(String file) throws IOException{
        String text = readFile(file);
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '(' ||text.charAt(i) == '{' || text.charAt(i) == '[')
                openCharacters.push(text.charAt(i));
            if(text.charAt(i) == ')' ||text.charAt(i) == '}' || text.charAt(i) == ']')
                openCharacters.pop();
        }
    }

    /**
     * Counts the errors of the text by looking at the size(top) of the stack. If the stack is empty it means there are no errors.
     * @return the amount of error found in the text.
     */
    public int countErrors(){
        if (!openCharacters.isEmpty())
            errors = openCharacters.size();
        return errors;
    }

    /**
     * Takes a file and converts it to a String.
     * @param file .txt file.
     * @return the txt file converted into a String.
     * @throws IOException
     */
    private String readFile(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }

    public int getErrors() {
        return errors;
    }
    public DynamicStack<Character> getOpenCharacters() {
        return openCharacters;
    }
}
