package TrabajoPractico_KnightsTour;

import TrabajoPractico3.Stacks.DynamicStack.DynamicStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DiegoMancini on 31/3/17.
 */
public class DefinitiveKnightsTour {

    private final static int[] MOVES_ALLOWED_IN_ROW = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private final static int[] MOVES_ALLOWED_IN_COLUMN = { 1, 2, 2, 1, -1, -2, -2, -1 };
    private final static int ROWS_AND_COLUMNS = 8;
    private static Spot[][] board = new Spot[ROWS_AND_COLUMNS][ROWS_AND_COLUMNS];
    private static List<DynamicStack<Spot>> listOfStacksWithMovements;

    private static boolean moveIsAllowed(Spot anySpot , Spot[][] board ) {
        if (anySpot.getPositionInRow() >= 0 && anySpot.getPositionInRow() < ROWS_AND_COLUMNS) {
            if (anySpot.getPositionInColumn() >=0 && anySpot.getPositionInColumn() < ROWS_AND_COLUMNS) {
                if ((board[anySpot.getPositionInRow()][anySpot.getPositionInColumn()].getValue() == -1)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean knightsTourBacktrackingUtility(Spot initialSpot, int numberOfMovement, Spot[][] board, int[] movesAllowedInRow, int[] movesAllowedInColumn) {
        Spot nextSpot;
        int nextSpotsRow , nextSpotsColumn;
        if (numberOfMovement == (ROWS_AND_COLUMNS * ROWS_AND_COLUMNS)) {
            return true;
        }
        for (int possibleMovement = 0 ; possibleMovement < ROWS_AND_COLUMNS ; possibleMovement++) {
            nextSpotsRow = initialSpot.getPositionInRow() + movesAllowedInRow[possibleMovement] ;
            nextSpotsColumn = initialSpot.getPositionInColumn() + movesAllowedInColumn[possibleMovement];
            nextSpot = new Spot(nextSpotsRow , nextSpotsColumn);
            if (moveIsAllowed(nextSpot , board)) {
                nextSpot.setValue(numberOfMovement);
                nextSpot.addHorseToSpot();
                nextSpot.setOccupied(true);
                board[nextSpotsRow][nextSpotsColumn] = nextSpot;
                if (knightsTourBacktrackingUtility(nextSpot , numberOfMovement+1 ,board , movesAllowedInRow , movesAllowedInColumn )) {
                    return true;
                } else {
                    board[nextSpot.getPositionInRow()][nextSpot.getPositionInColumn()].setValue(-1);
                }
            }
        } return false;
    }
    private static void fillBoard() {
        for (int positionInRow = 0 ; positionInRow < ROWS_AND_COLUMNS ; positionInRow++) {
            for (int positionInColumn = 0 ; positionInColumn < ROWS_AND_COLUMNS; positionInColumn++) {
                board[positionInRow][positionInColumn] = new Spot(positionInRow , positionInColumn);
            }
        }
        board[0][0].setValue(0);
    }
    public static boolean solveKnightsTour() {
        fillBoard();
        if (!knightsTourBacktrackingUtility(board[0][0], 1, board, MOVES_ALLOWED_IN_ROW, MOVES_ALLOWED_IN_COLUMN)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            printBoard();
        return true;
    }
    private static void printBoard() {
        for (int positionInRow = 0 ; positionInRow < ROWS_AND_COLUMNS ; positionInRow++) {
            for (int positionInColumn = 0 ; positionInColumn < ROWS_AND_COLUMNS; positionInColumn++) {
                System.out.print(board[positionInRow][positionInColumn].getValue() + " || ");
            }
            System.out.println();
        }
    }

    private void printNextMove(Spot nextSpot) {
        System.out.println(board[nextSpot.getPositionInRow()][nextSpot.getPositionInColumn()].getValue() + " || ");
    }

    public static void main(String[] args) {
        solveKnightsTour();
    }
}
