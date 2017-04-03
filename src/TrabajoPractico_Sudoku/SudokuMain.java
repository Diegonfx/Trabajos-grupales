package TrabajoPractico_Sudoku;

/**
 * Created by DiegoMancini on 1/4/17.
 */
public class SudokuMain {

    public static void main(String[] args) {
        Sudoku sdk= new Sudoku();
        sdk.print();
        System.out.println(sdk.solver(0,0, sdk.getSudoku()));
        sdk.print();

    }
}
