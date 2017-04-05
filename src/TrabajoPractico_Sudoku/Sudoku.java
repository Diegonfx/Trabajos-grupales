package TrabajoPractico_Sudoku;


/**
 * Class used to represent a sudoku board.
 * @author Tomas Iturralde
 * @author Diego Mancini
 */
public class Sudoku {
    private static int[][] sudoku = new int[9][9];

    /**
     * Creates the sudoku board, setting every starting number to 0.
     */
    public Sudoku(){
        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                sudoku[i][j] = 0;
            }
        }
    }

    public int[][] getSudoku() {
        return sudoku;
    }

    /**
     * adds a value to a certain position.
     * @param numberToAdd number to be added to the board.
     * @param posRow position in row on the board.
     * @param posCol position in column on the board.
     */
    public void setValueAtPosition(int numberToAdd, int posRow, int posCol){
        sudoku[posRow][posCol] = numberToAdd;
   }

    /**
     * Solves a sudoku board by trying every number from 1-9. Sets the value a the spot as a 1 (if possible), and continues
     * filling the rest. If a poition can't be filled, it goes back and sums a 1 to the number in that position. This will
     * be done until the board is solved.
     * @param posRow starting position in row.
     * @param posColumn starting postion in column.
     * @param sudoku board to be solved.
     * @return true if the board could be solve, false if otherwise.
     */
    public boolean solver(int posRow, int posColumn, int[][] sudoku) {
        if (posRow == 9) {
            posRow = 0;
            if (++posColumn == 9)
                return true;
        }
        if (sudoku[posRow][posColumn] != 0)
            return solver(posRow+1, posColumn, sudoku);

        for (int val = 1; val <= 9; ++val) {
            if (checkForAvailability(val, posRow,posColumn)) {
                sudoku[posRow][posColumn] = val;
                if (solver(posRow+1, posColumn, sudoku))
                    return true;
            }
        }
        sudoku[posRow][posColumn] = 0;
        return false;
    }

    /**
     * Checks if the board is valid to be solved.
     * @param sudoku sudoku to be checked.
     * @return true if the board is valid, false if otherwise.
     */
    public boolean boardIsValid(Sudoku sudoku){
        boolean b = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku.getSudoku()[i][j] != 0)
                    b = checkForAvailability(sudoku.getSudoku()[i][j], i, j);
            }
        }
        return b;
    }

    /**
     * takes the 3 checkers and makes them one method.
     * @param numberToCheck at a position.
     * @param posRow position in row to be checked.
     * @param posColumn position in column to be checked.
     * @return true if the number is available to be added in the position composed by posRow and posColumn, false if otherwise.
     */
    private boolean checkForAvailability(int numberToCheck, int posRow, int posColumn){
        return (checkForAvailabilityInColumn(numberToCheck, posColumn) && checkForAvailabilityInRow(numberToCheck, posRow) && checkForAvailabilityInBox(numberToCheck, posRow, posColumn));
    }

    /**
     * Checks for the availability of a number in a certain column.
     * @param numberToCheck at the column.
     * @param column to be checked.
     * @return true if the number can be added to that column, false if otherwise.
     */
    private boolean checkForAvailabilityInColumn(int numberToCheck, int column){
        for (int row = 0; row < 9; row++){
            if (sudoku[row][column] == numberToCheck)
                return false;
        }
        return true;
    }

    /**
     * Checks for the availability of a number in a certain row.
     * @param numberToCheck at the row.
     * @param row to be checked.
     * @return true if the number can be added to that row, false if otherwise.
     */
    private boolean checkForAvailabilityInRow(int numberToCheck, int row){
        for (int column = 0; column < 9; column++){
            if (sudoku[row][column] == numberToCheck)
                return false;
        }
        return true;
    }

    /**
     * Checks if a number can be added to a box of 3x3 inside the board.
     * Every box can be counted from 0-2 in both directions(rows and columns).
     * @param numberToCheck at the box.
     * @param row of the box to be checked.
     * @param column of the box to be checked.
     * @return true if the number can be added to that box, false if otherwise.
     */
    private boolean checkForAvailabilityInBox(int numberToCheck, int row, int column) {
        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
            for (int j = (column / 3) * 3; j < (column / 3) * 3 + 3; j++) {
                if (sudoku[i][j] == numberToCheck)
                    return false;
            }
        }
        return true;
    }
}
