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
        setValueAtPosition(8,0,0);
        setValueAtPosition(3,1,2);
        setValueAtPosition(7,2,1);
        setValueAtPosition(6,1,3);
        setValueAtPosition(9,2,4);
        setValueAtPosition(2,2,6);
        setValueAtPosition(5,3,1);
        setValueAtPosition(1,5,3);
        setValueAtPosition(4,4,4);
        setValueAtPosition(7,3,5);
        setValueAtPosition(5,4,5);
        setValueAtPosition(7,4,6);
        setValueAtPosition(3,5,7);
        setValueAtPosition(9,8,1);
        setValueAtPosition(1,6,2);
        setValueAtPosition(8,7,2);
        setValueAtPosition(5,7,3);
        setValueAtPosition(4,8,6);
        setValueAtPosition(6,6,7);
        setValueAtPosition(1,7,7);
        setValueAtPosition(8,6,8);
    }

    public int[][] getSudoku() {
        return sudoku;
    }

    public void print() {
        System.out.println("=================================================");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print( " || " + sudoku[i][j]);
            }
            System.out.println(" ||");
            System.out.println("=================================================");
        }
    }
    private void setValueAtPosition(int numberToAdd, int posRow, int posCol){
        sudoku[posRow][posCol] = numberToAdd;
   }

    public boolean solver(int i, int j, int[][] sudoku) {
            if (i == 9) {
                i = 0;
                if (++j == 9)
                    return true;
            }
            if (sudoku[i][j] != 0)  // skip filled cells
                return solver(i + 1, j, sudoku);

            for (int val = 1; val <= 9; ++val) {
                if (checkForAvailability(val, i, j)) {
                    sudoku[i][j] = val;
                    if (solver(i + 1, j, sudoku))
                        return true;
                }
            }
            sudoku[i][j] = 0; // reset on backtrack
            return false;
    }

    private boolean checkForAvailability(int numberToCheck, int posRow, int posColumn){
        return (checkForAvailabilityInRow(numberToCheck, posColumn) && checkForAvailabilityInColumn(numberToCheck, posRow) && checkForAvailabilityInBox(numberToCheck, posRow, posColumn));

    }
    public boolean checkForAvailabilityInRow(int numberToCheck, int column){
        for (int row = 0; row < 9; row++){
            if (sudoku[row][column] == numberToCheck)
                return false;
        }
        return true;
    }
    public boolean checkForAvailabilityInColumn(int numberToCheck, int row){
        for (int column = 0; column < 9; column++){
            if (sudoku[row][column] == numberToCheck)
                return false;
        }
        return true;
    }
    public boolean checkForAvailabilityInBox(int numberToCheck, int row, int column) {
        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
            for (int j = (column / 3) * 3; j < (column / 3) * 3 + 3; j++) {
                if (sudoku[i][j] == numberToCheck)
                    return false;
            }
        }
        return true;
    }
}
