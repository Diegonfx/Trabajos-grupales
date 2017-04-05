package TrabajoPractico_Sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controls every action taken in the sudoku menu, updating the information in both the sudoku and the board showed on screen.
 * @author Tomas Iturralde
 * @author Diego Mancini
 */
public class SudokuController {
        private SudokuMenu sudokuMenu;
        private Sudoku sudoku;
        private ErrorPopUp error;

        public SudokuController(){
            sudokuMenu = new SudokuMenu(new Solve(), new ClearBoard());
            sudoku = new Sudoku();
            error = new ErrorPopUp();

        }

    /**
     * Class used to give an action to the "Solve" button in the SudokuMenu.
     * First it fills the sudoku with every number typed by the user. If what has been typed is valid,
     * it will be solved and filled in the board on screen. If not, it means the board in unsolvable, and an error will pop.
     */
    public class Solve implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (!sudokuMenu.getBoard()[i][j].getText().equals(""))
                            sudoku.setValueAtPosition(Integer.parseInt(sudokuMenu.getBoard()[i][j].getText()), i ,j);
                    }
                }
                if(sudoku.boardIsValid(sudoku)) {
                    sudoku.solver(0,0,sudoku.getSudoku());
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            sudokuMenu.getBoard()[i][j].setText("" + sudoku.getSudoku()[i][j]);
                        }
                    }
                } else {
                    error.setVisible(true);

                }
            }
        }

    /**
     * Class used to give an action to the "Clear board" button in the SudokuMenu.
     * Clears both the sudoku and the board showed on screen.
     */
    public class ClearBoard implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                sudoku = new Sudoku();
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        sudokuMenu.getBoard()[i][j].setText("");
                    }
                }
            }
        }
}
