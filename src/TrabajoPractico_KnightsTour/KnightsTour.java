package TrabajoPractico_KnightsTour;

import TrabajoPractico3.Stacks.DynamicStack.DynamicStack;
import TrabajoPractico3.Stacks.StaticStack.StaticStack;
import com.sun.scenario.effect.impl.prism.PrImage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DiegoMancini on 1/4/17.
 */
public class KnightsTour {

    private final static int[] MOVES_ALLOWED_IN_ROW = {2, 1, -1, -2, -2, -1, 1, 2};
    private final static int[] MOVES_ALLOWED_IN_COLUMN = {1, 2, 2, 1, -1, -2, -2, -1};
    private final static int SIZE = 8;
    private  static Integer[][] board = new Integer[SIZE][SIZE];
    private DynamicStack<Integer> firstStack;
    private DynamicStack<Integer> secondStack;
    private DynamicStack<Integer> thirdStack;
    private DynamicStack<Integer> fourthStack;
    private static int moves = 0;

    public KnightsTour() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = -1;
            }
        }
        board[0][0] = 0;
        firstStack = new DynamicStack<>();
        firstStack.push(board[0][0]);
        secondStack = new DynamicStack<>();
        thirdStack = new DynamicStack<>();
        fourthStack = new DynamicStack<>();
    }

    private static boolean moveIsAllowed(int positionInRow, int positionInColumn, Integer[][] board) {
        if (positionInRow >= 0 && positionInRow < SIZE) {
            if (positionInColumn >= 0 && positionInColumn < SIZE) {
                if ((board[positionInRow][positionInColumn] == -1)) {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean knightsTourBacktrackingUtility(int positionInRow, int positionInColumn, int numberOfMovement, Integer[][] board, int[] movesAllowedInRow, int[] movesAllowedInColumn) {
        int nextSpotsRow, nextSpotsColumn;
        if (numberOfMovement == (SIZE * SIZE)) {
            return true;
        }
        for (int possibleMovement = 0; possibleMovement < SIZE; possibleMovement++) {
            nextSpotsRow = positionInRow + movesAllowedInRow[possibleMovement];
            nextSpotsColumn = positionInColumn + movesAllowedInColumn[possibleMovement];
            if (moveIsAllowed(nextSpotsRow, nextSpotsColumn, board)) {
                board[nextSpotsRow][nextSpotsColumn] = numberOfMovement;
                if (knightsTourBacktrackingUtility(nextSpotsRow, nextSpotsColumn, numberOfMovement + 1, board, movesAllowedInRow, movesAllowedInColumn)) {
                    return true;
                } else {
                    board[nextSpotsRow][nextSpotsColumn] = -1;
                }
            }
        }
        return false;
    }

    public static boolean solveKnightsTour() {
        if (!knightsTourBacktrackingUtility(0 , 0, 1, board , MOVES_ALLOWED_IN_ROW, MOVES_ALLOWED_IN_COLUMN)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            printBoard();
        return true;
    }
    private static void printBoard() {
        for (int positionInRow = 0 ; positionInRow < SIZE ; positionInRow++) {
            for (int positionInColumn = 0 ; positionInColumn < SIZE; positionInColumn++) {
                System.out.print(board[positionInRow][positionInColumn] + " || ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        KnightsTour kt = new KnightsTour();
        kt.solveKnightsTour();
    }
}
