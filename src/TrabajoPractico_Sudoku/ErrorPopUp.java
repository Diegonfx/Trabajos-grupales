package TrabajoPractico_Sudoku;

import javax.swing.*;
import java.awt.*;

/**
 * Pop up message created to show the user that an invalid board has been used.
 * @author Tomas Iturralde
 * @author Diego Mancini
 */
public class ErrorPopUp extends JFrame {
    public ErrorPopUp(){
        setTitle("Error!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel message = new JPanel();
        message.setLayout(new BoxLayout(message, BoxLayout.LINE_AXIS));

        JLabel title = new JLabel("Error: Couldn't solve the sudoku, please try again with different numbers.");
        title.setAlignmentY(Component.TOP_ALIGNMENT);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font(title.getFont().getName(), Font.ROMAN_BASELINE, 20));

        add(title);
        pack();
        setLocationRelativeTo(null);
    }
}
