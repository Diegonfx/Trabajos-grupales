package TrabajoPractico_Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Tomas on 3/4/2017.
 */

public class SudokuMenu extends JFrame {
    private JTextField[][] board = new JTextField[9][9];

    public SudokuMenu(ActionListener solve, ActionListener clear){
        setTitle("Sudoku Solver");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);

        JPanel sudoku = new JPanel();
        sudoku.setLayout(new GridLayout(9,9));

        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Sudoku solver v2.0.1");
        title.setAlignmentY(Component.TOP_ALIGNMENT);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font(title.getFont().getName(), Font.ROMAN_BASELINE, 20));

        JLabel authors = new JLabel("Tomas Iturralde, Diego Mancini");
        authors.setAlignmentY(Component.TOP_ALIGNMENT);
        authors.setAlignmentX(Component.CENTER_ALIGNMENT );
        authors.setFont(new Font(title.getFont().getName(), Font.ROMAN_BASELINE, 20));


        for (int i = 0; i< 9; i++){
            for (int j = 0; j < 9; j++) {
                board[i][j] = new JTextField();
                board[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                board[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                board[i][j].setBackground(Color.WHITE);
                board[i][j].setOpaque(true);
                board[i][j].setHorizontalAlignment(JTextField.CENTER);
                board[i][j].setSize(50,50);
                sudoku.add(board[i][j]);
            }
        }

        JButton solveSudoku = new JButton("Solve");
        solveSudoku.setAlignmentX(Component.CENTER_ALIGNMENT);
        solveSudoku.addActionListener(solve);

        JButton Clear = new JButton("Clear board");
        Clear.setAlignmentX(Component.CENTER_ALIGNMENT);
        Clear.addActionListener(clear);

        info.add(Box.createRigidArea(new Dimension(200, 50)));
        info.add(title);
        info.add(Box.createRigidArea(new Dimension(200, 50)));
        info.add(authors);
        info.add(Box.createRigidArea(new Dimension(200, 50)));
        info.add(solveSudoku);
        info.add(Clear);

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(info);
        mainPanel.add(sudoku);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JTextField[][] getBoard() {
        return board;
    }
}
