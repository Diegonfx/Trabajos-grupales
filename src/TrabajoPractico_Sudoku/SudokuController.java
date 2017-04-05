package TrabajoPractico_Sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Tomas on 3/4/2017.
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

        public class Solve implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (!sudokuMenu.getBoard()[i][j].getText().equals(""))
                            sudoku.setValueAtPosition(Integer.parseInt(sudokuMenu.getBoard()[i][j].getText()), i ,j);
                    }
                }
                //if(sudoku.boardIsValid(sudoku)) {
                    sudoku.solver(0,0,sudoku.getSudoku());
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            sudokuMenu.getBoard()[i][j].setText("" + sudoku.getSudoku()[i][j]);
                        }
                    }
                /*} else {
                    error.setVisible(true);

                }*/
            }
        }

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
