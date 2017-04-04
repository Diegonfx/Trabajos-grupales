package TrabajoPractico_Sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Tomas on 3/4/2017.
 */
public class SudokuController {
        private SudokuMenu sudokuMenu;
        private Sudoku sudoku;

        public SudokuController(){
            sudokuMenu = new SudokuMenu(new Solve(), new AddNumber());
            sudoku = new Sudoku();
        }

        public class Solve implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                sudoku.solver(0,0,sudoku.getSudoku());
            }
        }

        public class AddNumber implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }
}
