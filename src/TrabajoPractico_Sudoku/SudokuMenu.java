package TrabajoPractico_Sudoku;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Creates the menu for the sudoku solver.
 * @author Tomas Iturralde
 * @author Diego Mancini
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

        JLabel title = new JLabel("Sudoku solver v2.5.1");
        title.setAlignmentY(Component.TOP_ALIGNMENT);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font(title.getFont().getName(), Font.ROMAN_BASELINE, 20));

        JLabel authors = new JLabel("Tomas Iturralde, Diego Mancini");
        authors.setAlignmentY(Component.TOP_ALIGNMENT);
        authors.setAlignmentX(Component.CENTER_ALIGNMENT );
        authors.setFont(new Font(title.getFont().getName(), Font.ROMAN_BASELINE, 20));

        /**
         * Sets every square inside the sudoku with its parameters, as well as restricting the amount of characters that can be
         * introduced in to every square by the user to 1.
         */
        for (int i = 0; i< 9; i++){
            for (int j = 0; j < 9; j++) {
                board[i][j] = new JTextField();
                AbstractDocument d = (AbstractDocument) board[i][j].getDocument();
                d.setDocumentFilter(new DocumentFilter(){
                    int max = 1;

                    @Override
                    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                        int documentLength = fb.getDocument().getLength();
                        if (documentLength - length + text.length() <= max)
                            super.replace(fb, offset, length, text.toUpperCase(), attrs);
                    }
                });
                board[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                board[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                board[i][j].setBackground(Color.WHITE);
                board[i][j].setHorizontalAlignment(JTextField.CENTER);
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
