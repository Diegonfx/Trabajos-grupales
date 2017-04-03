package TrabajoPractico_Sudoku;

/**
 * Created by DiegoMancini on 1/4/17.
 */
public class SudokuMain {

    public static void main(String[] args) {
        Sudoku sdk = new Sudoku();
        System.out.println(" \nINITIAL SUDOKU\n");
        sdk.print();
        sdk.solver(0,0, sdk.getSudoku());
        System.out.println("\nSOLVED SUDOKU\n");
        sdk.print();
    }
}
