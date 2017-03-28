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
    private char currentCharacter;
    private int currentLine;
    private DynamicStack<Character> openCharacters;


    public LexicographicAnalyzer() {
        errors = 0;
        currentCharacter = '\0';
        currentLine = 1;
        openCharacters = new DynamicStack<>();
    }

    public void analizeText(String file) throws IOException{
        String text = readFile(file);
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '(' ||text.charAt(i) == '{' || text.charAt(i) == '[')
                openCharacters.push(text.charAt(i));
            if(text.charAt(i) == ')' ||text.charAt(i) == '}' || text.charAt(i) == ']')
                openCharacters.pop();
        }
    }

    public int countErrors(){
        if (!openCharacters.isEmpty())
            errors = openCharacters.size();
        return errors;
    }

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
    public char getCurrentCharacter() {
        return currentCharacter;
    }
    public int getCurrentLine() {
        return currentLine;
    }
    public DynamicStack<Character> getOpenCharacters() {
        return openCharacters;
    }
}
