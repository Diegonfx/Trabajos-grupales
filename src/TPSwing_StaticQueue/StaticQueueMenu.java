package TPSwing_StaticQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by DiegoMancini on 9/6/17.
 */
public class StaticQueueMenu extends JFrame {

    private JLabel[] queue = new JLabel[10];

    public StaticQueueMenu(ActionListener enqueue , ActionListener dequeue , ActionListener emptyQueue) {

        setTitle("Graphic static queue");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000 , 600);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(1000 , 600));
        panel.setLayout(new FlowLayout());


    }
}
