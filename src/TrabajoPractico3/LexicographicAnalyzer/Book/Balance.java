package TrabajoPractico3.LexicographicAnalyzer.Book;

import TrabajosPracticos.TrabajoPractico3.Stacks.DynamicStack.DynamicStack;

import java.io.Reader;

/**
 * Created by DiegoMancini on 25/3/17.
 */
public class Balance {

    private static class Symbol{
        private char token;
        private int theLine;

        public Symbol(char token, int theLine) {
            this.token = token;
            this.theLine = theLine;
        }
    }
    private int errors;
    private Tokenizer tokenizer;

    public Balance(Reader inStream) {
        errors = 0;
        tokenizer = new Tokenizer(inStream);
    }

    public int checkBalance() {
        char ch;
        Symbol match = null;
        DynamicStack<Symbol> pendingTokens = new DynamicStack<>();

        while ((ch = tokenizer.getNextOpenClose()) != '\0') {
            Symbol lastSymbol = new Symbol(ch , tokenizer.getCurrentLine()) ;

            switch (ch) {
                case '(' : case '[' : case '{' :
                    pendingTokens.push(lastSymbol);
                    break;
                case ')' : case ']' : case '}' :
                    if (pendingTokens.isEmpty()) {
                        errors++;
                        System.out.println("Extraneous " + ch + "at line " + tokenizer.getCurrentLine());
                    } else {
                        match = pendingTokens.peek();
                        pendingTokens.pop();
                        checkMatch(match , lastSymbol);
                    }
                    break;
                default: // Can't be done
                    break;
            }
        }

        while (!pendingTokens.isEmpty()) {
            match = pendingTokens.peek();
            pendingTokens.pop();
            System.out.println("Unmatched " + match.token + "at line " + match.theLine);
            errors++ ;
        } return errors + tokenizer.getErrors();
    }

    private void checkMatch(Symbol openSymbol , Symbol closeSymbol) {
        if ( (openSymbol.token == '(' && closeSymbol.token != ')' ) || ( openSymbol.token == '[' && closeSymbol.token != ']' ) || ( openSymbol.token == '{' && closeSymbol.token != '}' ) ) {
            System.out.println("Found " + closeSymbol.token + " on line " + tokenizer.getCurrentLine() + "; does not match " + openSymbol.token + " at line " + openSymbol.theLine);
            errors++;
        }
    }

}
