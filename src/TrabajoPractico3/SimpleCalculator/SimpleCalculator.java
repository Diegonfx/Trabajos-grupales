package TrabajoPractico3.SimpleCalculator;

import TrabajoPractico3.Stacks.DynamicStack.DynamicStack;

/**
 * Created by DiegoMancini on 24/3/17.
 */
public class SimpleCalculator {


    private int result;
    private DynamicStack<Character> charactersToOperate;

    public SimpleCalculator() {
        charactersToOperate = new DynamicStack<>();
        result = 0;
    }

    public void calculate() {

        String operation = Scanner.getString("Ingrese la operacion a realizar: ");
        char[] operationsToChar = operation.toCharArray();
        for (int i = 0 ; i < operationsToChar.length ; i++ ) {
            charactersToOperate.push(operationsToChar[i]);
            if (operationsToChar[0] == '+' || operationsToChar[0] == '-' || operationsToChar[0] == '/' || operationsToChar[0] == '*') {
                throw new RuntimeException("ERROR");
            } else if (operationsToChar[i] != ' ' ||operationsToChar[i] != '0' || operationsToChar[i] != '1' || operationsToChar[i] != '2' || operationsToChar[i] != '3' || operationsToChar[i] != '4' || operationsToChar[i] != '5' || operationsToChar[i] != '6' || operationsToChar[i] != '7' || operationsToChar[i] != '8' || operationsToChar[i] != '9' || operationsToChar[i] != '+' || operationsToChar[i] != '-' || operationsToChar[i] != '*' || operationsToChar[i] != '/') {
                throw new RuntimeException("ERROR");
            } else {
                if (operationsToChar[i+1] == '+') {
                    result = (int) operationsToChar[i] + (int) operationsToChar[i+2];
                }
            }
        }
    }

}
