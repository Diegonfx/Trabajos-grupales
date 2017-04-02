package TrabajoPractico_Sudoku;

import TrabajoPractico3.Stacks.StaticStack.StaticStack;

/**
 * Created by Tomas on 30/3/2017.
 */
public class Sudoku {
    private static int[][] sudoku = new int[9][9];

    public Sudoku(){
        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                sudoku[i][j] = 0;
            }
        }
        // FUNCIONA ESTO? JAJAJA
        for (int[] a : sudoku){
            for (int b : a){
                b = 0;
            }
        }
    }

    public boolean addNumber(int posRow, int posColumn){
        if (posColumn > 8)
            return true;

        StaticStack<Integer> possibleSolutions = new StaticStack<>(9);
        for (int i = 1; i < 10; i++){
            if (checkForAvailability(i, posRow, posColumn))
                possibleSolutions.push(i);
        }
        sudoku[posRow][posColumn] = possibleSolutions.peek();
        return false;
    }

    private boolean checkForAvailability(int numberToCheck, int posRow, int posColumn){
        return (checkForAvailabilityInRow(numberToCheck, posColumn) && checkForAvailabilityInColumn(numberToCheck, posRow) && checkForAvailabilityInBox(numberToCheck, posRow, posColumn));

    }

    private boolean checkForAvailabilityInRow(int numberToCheck, int column){
        for (int row = 0; row < 9; row++){
            if (sudoku[row][column] == numberToCheck)
                return false;
        }
        return true;
    }
    private boolean checkForAvailabilityInColumn(int numberToCheck, int row){
        for (int column = 0; column < 9; column++){
            if (sudoku[row][column] == numberToCheck)
                return false;
        }
        return true;
    }
    private boolean checkForAvailabilityInBox(int numberToCheck, int row, int column){
        row = (row % 3)/3;
        column = (column % 3)/3;
        for (int boxRow = 0; boxRow < 3; boxRow++){
            for (int boxCol = 0; boxCol < 3; boxCol++){
            if (sudoku[row + boxRow][column + boxCol] == numberToCheck)
                return false;
            }
        }
        return true;
    }

    public int[][] getSudoku() {
        return sudoku;
    }
}
