package TrabajoPractico_Sudoku;

/**
 * Created by Tomas on 30/3/2017.
 */
public class Sudoku {
    private Box[][] sudoku;

    public Sudoku(){
        sudoku = new Box[3][3];
    }

    public Box[][] getSudoku() {
        return sudoku;
    }
}
