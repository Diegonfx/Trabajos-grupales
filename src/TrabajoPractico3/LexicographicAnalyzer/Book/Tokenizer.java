package TrabajoPractico3.LexicographicAnalyzer.Book;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;

/**
 * Created by DiegoMancini on 25/3/17.
 */
public class Tokenizer {

    private PushbackReader input;
    private char currentCharacter;
    private int currentLine;
    private int errors;
    private static final int SLASH_SLASH = 0;
    private static final int SLASH_STAR = 1;

    public Tokenizer(Reader inStream) {
        input = new PushbackReader(inStream);
        currentCharacter = '\0';
        currentLine = 1;
        errors = 0;
    }

    public PushbackReader getInput() {
        return input;
    }
    public char getCurrentCharacter() {
        return currentCharacter;
    }
    public int getCurrentLine() {
        return currentLine;
    }
    public int getErrors() {
        return errors;
    }

    /**
     *
     * @return
     */
    public char getNextOpenClose(){
        while (nextChar() == true) {
            if (currentCharacter == '/') {
                processSlash();
            } else if (currentCharacter == '\''  || currentCharacter == '"' ) {
                skipQuote(currentCharacter);
            } else if (currentCharacter == '(' || currentCharacter == '[' || currentCharacter == '{' || currentCharacter == ')' || currentCharacter == ']' || currentCharacter == '}') {
                return currentCharacter;
            }
        } return '\0' ; //End of file
    }

    /**
     *
     * @return
     */
    public String getNextID(){
        while (nextChar()) {
            if (currentCharacter == '/') {
                processSlash();
            } else if (currentCharacter == '\\') {
                nextChar();
            }else if (currentCharacter == '\'' || currentCharacter == '"') {
                skipQuote(currentCharacter);
            } else if (!Character.isDigit(currentCharacter) && isIdChar(currentCharacter)) {
                return getRemainingString();
            }
        } return null; // End of file

    }

    /**
     *
     * @return
     */
    private boolean nextChar(){
        try {
            int readValue = input.read();
            if (readValue == -1) {
                return false;
            } else {
                currentCharacter = (char) readValue;
                if (currentCharacter == '\n') {
                    currentLine++;
                } return true;
            }
        } catch (IOException e) {
            return false;
        }
    }

    /**
     *
     */
    private void putBackCharacter(){
        if (currentCharacter == '\n') {
            currentLine--;

        } try {
            input.unread( (int) currentCharacter);
        } catch (IOException e) {

        }
    }

    /**
     *
     * @param start
     */
    private void skipComment(int start) {
        if (start == SLASH_SLASH) {
            while (nextChar() && (currentCharacter != '\n')) {
            } return;
        } boolean state = false;
        while (nextChar()) {
            if (state && currentCharacter == '\'') {
                return;
            } state = (currentCharacter == '*');
        } errors++;
    }

    /**
     *
     * @param quoteType
     */
    private void skipQuote(char quoteType) {
        while (nextChar()) {
            if (currentCharacter == quoteType) {
                return;
            }if (currentCharacter == '\n') {
                errors++;
                System.out.println("Missing closed quote at line " + currentLine);
            } else if (currentCharacter == '\\') {
                nextChar();
            }
        }
    }

    /**
     *
     */
    private void processSlash() {
        if (nextChar() == true) {
            if (currentCharacter == '*') {
                if (nextChar() == true && currentCharacter!= '*') {
                    putBackCharacter();
                } else {
                    skipComment(SLASH_STAR);
                }
            } else if(currentCharacter == '/') {
                skipComment(SLASH_SLASH);
            } else if(currentCharacter != '\n') {
                putBackCharacter();
            }
        }
    }

    /**
     *
     * @param ch
     * @return
     */
    private static final boolean isIdChar(char ch){
        return Character.isJavaIdentifierPart(ch);
    }

    /**
     *
     * @return
     */
    private String getRemainingString() {
        StringBuilder result = new StringBuilder(currentCharacter);
        for (; nextChar() ; result.append(currentCharacter)) {
            if (!isIdChar(currentCharacter)) {
                putBackCharacter();
                break;
            }
        }
        return new String(result);
    }

}
