package TrabajoPractico_KnightsTour;

import TrabajoPractico3.Stacks.DynamicStack.DynamicStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DiegoMancini on 29/3/17.
 */
public class KnightTour {

    private final static int MOVES_ALLOWED_IN_ROW[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private final static int MOVES_ALLOWED_IN_COLUMN[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
    private final static int ROWS_AND_COLUMNS = 8;
    private Spot[][] board;
    private List<DynamicStack<Spot>> possibleMoves;

    public KnightTour() {
        possibleMoves = new ArrayList<>();
        board = new Spot[ROWS_AND_COLUMNS][ROWS_AND_COLUMNS];
    }

    private boolean nextMoveIsPossible(int positionInRow , int positionInColumn, int movementNumber ) {
        boolean output = false;

        return output;
    }

    private boolean moveIsAllowed(int positionInRow, int positionInColumn) {
        if ( (positionInRow >= 0 && positionInRow < ROWS_AND_COLUMNS) && (positionInColumn >= 0 && positionInColumn< ROWS_AND_COLUMNS) && (isUsed(positionInRow, positionInColumn)) ) {
            return true;
        } return false;
    }
    private boolean isUsed(int positionInRow, int positionInColumn) {
        if (board[positionInRow][positionInColumn].getValue() == -1) {
            return true;
        } else {
            return false;
        }
    }
    private void printBoard() {
        for (int positionInRow = 0 ; positionInRow < ROWS_AND_COLUMNS ; positionInRow++) {
            for (int positionInColumn = 0 ; positionInColumn < ROWS_AND_COLUMNS; positionInColumn++) {
                System.out.println("  " + board[positionInRow][positionInColumn].getValue());
            }
            System.out.println();
        }
    }


    // GETTERS
    private Spot[][] getBoard() {
        return board;
    }
    private static int[] getMovesAllowedInRow() {
        return MOVES_ALLOWED_IN_ROW;
    }
    private static int[] getMovesAllowedInColumn() {
        return MOVES_ALLOWED_IN_COLUMN;
    }
    private static int getRowsAndColumns() {
        return ROWS_AND_COLUMNS;
    }

    /*
    First implementation

    public boolean solve() {
        if (! (findNextMove(0 , 0 , 1 , MOVES_ALLOWED_IN_ROW , MOVES_ALLOWED_IN_COLUMN , board))) {
            System.out.println("There's no solution");
            return false;
        } else {
            printBoard();
        } return true;
    }

    private boolean findNextMove(int row , int column , int numberOfMoves , int[] movesAllowedInRow , int[] movesAllowedInColumn , int[][] boardToAnalyze) {

        if (!isEmpty(row , column)) { return false; }
        numberOfMoves = moves;
        if (moves + 1 == (ROWS_AND_COLUMNS * ROWS_AND_COLUMNS) ) { return true; }
        for (int i = 0 ; i < ROWS_AND_COLUMNS ; i++) {
            if (moveIsAllowed(row + MOVES_ALLOWED_IN_ROW[i] , column + MOVES_ALLOWED_IN_COLUMN[i]) ) {
                board[row + MOVES_ALLOWED_IN_ROW[i]][column + MOVES_ALLOWED_IN_COLUMN[i]] = numberOfMoves;
                moves++;
                if (findNextMove(row + MOVES_ALLOWED_IN_ROW[i] , column + MOVES_ALLOWED_IN_COLUMN[i] , numberOfMoves+1 , movesAllowedInRow , movesAllowedInColumn , boardToAnalyze )) {
                    return true;
                } else {
                    board[row + MOVES_ALLOWED_IN_ROW[i]][column + MOVES_ALLOWED_IN_COLUMN[i]] = -1;
                }
            }
        } return false;
    }
     */

}
