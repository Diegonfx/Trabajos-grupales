package TrabajoPractico_KnightsTour;

import TrabajoPractico3.Stacks.DynamicStack.DynamicStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DiegoMancini on 31/3/17.
 */
public class DefinitiveKnightsTour {

    public static void main(String[] args) {
        DefinitiveKnightsTour kt = new DefinitiveKnightsTour();
        kt.printList();
    }
    private final static Spot[] MOVES_ALLOWED_IN_BOARD = { new Spot(2,1) , new Spot(1,2) , new Spot(-1,2) , new Spot(-2,1) ,
            new Spot(-2,-1) , new Spot(-1,-2) , new Spot(1,-2) , new Spot(2,-1) };
    private final static int SIZE = 8;
    private static Spot[][] board = new Spot[SIZE][SIZE];
    private static List<DynamicStack<Spot>> listOfStacksWithMovements;
    private static Spot currentSpot = new Spot(0 , 0);
    private static int movementNumber = 0;
    private static DynamicStack<Spot> firstStack = new DynamicStack<>();
    private static DynamicStack<Spot> secondStack = new DynamicStack<>();
    private static DynamicStack<Spot> thirdStack = new DynamicStack<>();
    private static DynamicStack<Spot> fourthStack = new DynamicStack<>();


    private DefinitiveKnightsTour() {
        for (int j = 0 ; j < SIZE ; j++) {
            for (int k = 0; k < SIZE; k++) {
                board[j][k] = new Spot(j, k);
            }
        }
        currentSpot.setValue(0);
        board[0][0] = currentSpot;
        listOfStacksWithMovements = new ArrayList<>();
        listOfStacksWithMovements.add(firstStack);
        listOfStacksWithMovements.add(secondStack);
        listOfStacksWithMovements.add(thirdStack);
        listOfStacksWithMovements.add(fourthStack);
    }

    private static boolean moveIsAllowed(Spot anySpot , Spot[][] board ) {
        if (anySpot.getPositionInRow() >= 0 && anySpot.getPositionInRow() < SIZE) {
            if (anySpot.getPositionInColumn() >=0 && anySpot.getPositionInColumn() < SIZE) {
                if ((board[anySpot.getPositionInRow()][anySpot.getPositionInColumn()].getValue() == -1)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static DynamicStack<Spot> getNextStackOfMoves() {
        DynamicStack<Spot> nextStack = new DynamicStack<>();
        int nextSpotsRow, nextSpotsColumn;
        Spot nextSpotInStack;
        for (int possibleSpot = 0 ; possibleSpot < SIZE ; possibleSpot++) {
            nextSpotsRow = currentSpot.getPositionInRow() + MOVES_ALLOWED_IN_BOARD[possibleSpot].getPositionInRow();
            nextSpotsColumn = currentSpot.getPositionInColumn() + MOVES_ALLOWED_IN_BOARD[possibleSpot].getPositionInColumn();
            nextSpotInStack = new Spot(nextSpotsRow , nextSpotsColumn);
            if (moveIsAllowed(nextSpotInStack, board)) {
                nextSpotInStack.setValue(movementNumber);
                board[nextSpotsRow][nextSpotsColumn] = nextSpotInStack;
                nextStack.push(nextSpotInStack);
                System.out.println(" || Value of spot: " + nextSpotInStack.getValue() + " || Name of spot in board: " + nextSpotInStack.getName());
            }
        } currentSpot = nextStack.peek();
        listOfStacksWithMovements.add(nextStack);
        return nextStack;
    }
    private static void fillList() {
                firstStack = getNextStackOfMoves();
                while (!firstStack.isEmpty()) {
                    secondStack = getNextStackOfMoves();
                    while (!secondStack.isEmpty()){
                        thirdStack = getNextStackOfMoves();
                        while (!thirdStack.isEmpty()) {
                            fourthStack = getNextStackOfMoves();
                            currentSpot = thirdStack.peek();
                            for (int i = 0 ; i < fourthStack.size() ; i++) {
                                fourthStack.pop();
                                movementNumber--;
                    } thirdStack.pop(); movementNumber--; currentSpot = thirdStack.peek();
                    if (!moveIsAllowed(thirdStack.peek() , board)) {
                        listOfStacksWithMovements.remove(fourthStack);
                    }
                }  secondStack.pop(); movementNumber--; currentSpot = secondStack.peek();
                    if (!moveIsAllowed(secondStack.peek() , board)) {
                        listOfStacksWithMovements.remove(thirdStack);
                    }
            } firstStack.pop(); movementNumber--; currentSpot = firstStack.peek();
                    if (!moveIsAllowed(firstStack.peek() , board)) {
                        listOfStacksWithMovements.remove(secondStack);
                    }
        } listOfStacksWithMovements.remove(firstStack);
    }
    private static void printBoard() {
        for (int positionInRow = 0 ; positionInRow < SIZE ; positionInRow++) {
            for (int positionInColumn = 0 ; positionInColumn < SIZE; positionInColumn++) {
                System.out.print(board[positionInRow][positionInColumn].getValue() + " || ");
            }
            System.out.println();
        }
    }
    private static void printList() {
            while (! listOfStacksWithMovements.isEmpty()) {
            fillList();
        }
    }
}
