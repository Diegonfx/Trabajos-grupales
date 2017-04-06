package TrabajoPractico_KnightsTour.Swing;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.prism.paint.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by DiegoMancini on 5/4/17.
 */
public class KnightsTourMenu extends JFrame {

    private final int amountOfSquares = 64;
    private JLabel[][] knightsTourBoard = new JLabel[8][8];

    public KnightsTourMenu(ActionListener next) {
        setTitle("Knights tour");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 600));
        panel.setLayout(new GridLayout(8, 8));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setAlignmentY(Component.CENTER_ALIGNMENT);

        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.PAGE_AXIS));
        info.setAlignmentY(Component.BOTTOM_ALIGNMENT);

        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                knightsTourBoard[row][column] = new JLabel();
                knightsTourBoard[row][column].setBorder(BorderFactory.createLineBorder(java.awt.Color.MAGENTA));
                knightsTourBoard[row][column].setSize(40, 40);
                knightsTourBoard[row][column].setOpaque(true);
                knightsTourBoard[row][column].setAlignmentX(Component.CENTER_ALIGNMENT);
                knightsTourBoard[row][column].setAlignmentY(Component.CENTER_ALIGNMENT);
                panel.add(knightsTourBoard[row][column]);

                java.awt.Color blackColor = java.awt.Color.black;
                java.awt.Color whiteColor = java.awt.Color.white;
                if ((column % 2 == 1 && row % 2 == 1) || (column % 2 == 0 && row % 2 == 0)) {
                    knightsTourBoard[row][column].setBackground(whiteColor);
                } else {
                    knightsTourBoard[row][column].setBackground(blackColor);
                }
            }
        }

        ImageIcon knight = new ImageIcon("src/TrabajoPractico_KnightsTour/Swing/horseknight.png");
        knightsTourBoard[0][0].setIcon(knight);

        JButton solveKnightsTour = new JButton("Solve");
        solveKnightsTour.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        solveKnightsTour.setAlignmentX(Component.CENTER_ALIGNMENT);
        solveKnightsTour.addActionListener(next);
        panel.add(solveKnightsTour);

        info.add(Box.createRigidArea(new Dimension(100, 50)));
        info.add(solveKnightsTour);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(panel);
        mainPanel.add(info);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public int getAmountOfSquares() {
        return amountOfSquares;
    }

    public JLabel[][] getKnightsTourBoard() {
        return knightsTourBoard;
    }
}