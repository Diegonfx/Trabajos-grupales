package TrabajoPractico_Sudoku;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tomas on 4/4/2017.
 */
public class ErrorPopUp extends JFrame {
    public ErrorPopUp(){
        setTitle("Error!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel message = new JPanel();
        message.setLayout(new BoxLayout(message, BoxLayout.LINE_AXIS));

        JLabel title = new JLabel("Error: Couldn't solve the sudoku,\n please try again with different numbers.");
        title.setAlignmentY(Component.TOP_ALIGNMENT);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font(title.getFont().getName(), Font.ROMAN_BASELINE, 20));

        add(title);
        pack();
        setLocationRelativeTo(null);
    }
}
