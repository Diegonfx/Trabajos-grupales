package TrabajoPractico_KnightsTour;

import TrabajoPractico3.Stacks.DynamicStack.DynamicStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DiegoMancini on 31/3/17.
 */
public class DefinitiveKnightsTour {

    public static void main(String[] args) {
        fillList();
        printBoard();
    }
    private final static Spot[] MOVES_ALLOWED_IN_BOARD = { new Spot(2,1) , new Spot(1,2) , new Spot(-1,2) , new Spot(-2,1) ,
            new Spot(-2,-1) , new Spot(-1,-2) , new Spot(1,-2) , new Spot(2,-1) };
    private final static int SIZE = 8;
    private static Spot[][] board = new Spot[SIZE][SIZE];
    private static List<DynamicStack<Spot>> listOfStacksWithMovements;
    private static Spot currentSpot;
    private static int movementNumber;
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
        movementNumber = 0;
        currentSpot = new Spot(0 , 0);
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
        int nextSpotsRow, nextSpotsColumn;
        Spot nextSpotInStack;
        for (int possibleSpot = 0 ; possibleSpot < SIZE ; possibleSpot++) {
            nextSpotsRow = currentSpot.getPositionInRow() + MOVES_ALLOWED_IN_BOARD[possibleSpot].getPositionInRow();
            nextSpotsColumn = currentSpot.getPositionInColumn() + MOVES_ALLOWED_IN_BOARD[possibleSpot].getPositionInColumn();
            nextSpotInStack = new Spot(nextSpotsRow , nextSpotsColumn);
            if (moveIsAllowed(nextSpotInStack, board)) {
                nextSpotInStack.setValue(++movementNumber);
                nextStack.push(nextSpotInStack);
            }
        } currentSpot = nextStack.peek();
        return nextStack;
    }
    private static void fillList() {
        for (movementNumber = 0 ; movementNumber < 63 ; movementNumber++) {
            while (movementNumber < 63) {
                DynamicStack<Spot> stack = getNextStackOfMoves();
                while (listOfStacksWithMovements.get(movementNumber).size() >= 1) {
                    DynamicStack<Spot> nextStack = getNextStackOfMoves();
                    for (int j = 0 ; j < nextStack.size(); j++) {
                        nextStack.pop();
                    }
                }  stack.pop();
                currentSpot = stack.peek();
            }
        }
    }

//    private static boolean knightsTourBacktrackingUtility(Spot initialSpot, int numberOfMovement, Spot[][] board, int[] movesAllowedInRow, int[] movesAllowedInColumn) {
//        Spot nextSpot;
//        int nextSpotsRow , nextSpotsColumn;
//        if (numberOfMovement == (ROWS_AND_COLUMNS * ROWS_AND_COLUMNS)) {
//            return true;
//        }
//        for (int possibleMovement = 0 ; possibleMovement < ROWS_AND_COLUMNS ; possibleMovement++) {
//            nextSpotsRow = initialSpot.getPositionInRow() + movesAllowedInRow[possibleMovement] ;
//            nextSpotsColumn = initialSpot.getPositionInColumn() + movesAllowedInColumn[possibleMovement];
//            nextSpot = new Spot(nextSpotsRow , nextSpotsColumn);
//            if (moveIsAllowed(nextSpot , board)) {
//                nextSpot.setValue(numberOfMovement);
//                nextSpot.addHorseToSpot();
//                nextSpot.setOccupied(true);
//                board[nextSpotsRow][nextSpotsColumn] = nextSpot;
//                if (knightsTourBacktrackingUtility(nextSpot , numberOfMovement+1 ,board , movesAllowedInRow , movesAllowedInColumn )) {
//                    return true;
//                } else {
//                    board[nextSpot.getPositionInRow()][nextSpot.getPositionInColumn()].setValue(-1);
//                }
//            }
//        } return false;
//    }

    private static void printBoard() {
        for (int positionInRow = 0 ; positionInRow < SIZE ; positionInRow++) {
            for (int positionInColumn = 0 ; positionInColumn < SIZE; positionInColumn++) {
                System.out.print(board[positionInRow][positionInColumn].getValue() + " || ");
            }
            System.out.println();
        }
    }
//    private void printNextMove(Spot nextSpot) {
//        System.out.println(board[nextSpot.getPositionInRow()][nextSpot.getPositionInColumn()].getValue() + " || ");
//    }
}
