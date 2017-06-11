package TP_Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Tomas on 11/6/2017.
 */
public class QueueView extends JFrame {
    private JTextPane[] theQueue = new JTextPane[10];

    public QueueView(ActionListener queue, ActionListener dequeue, ActionListener emptyQueue){
        setTitle("Queue Model");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);

        JPanel aQueue = new JPanel();
        aQueue.setLayout(new GridLayout(0,10));

        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Static Queue");
        title.setAlignmentY(Component.TOP_ALIGNMENT);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font(title.getFont().getName(), Font.ROMAN_BASELINE, 20));

        JLabel authors = new JLabel("Tomas Iturralde, Diego Mancini");
        authors.setAlignmentY(Component.TOP_ALIGNMENT);
        authors.setAlignmentX(Component.CENTER_ALIGNMENT );
        authors.setFont(new Font(title.getFont().getName(), Font.ROMAN_BASELINE, 20));

        for (int i = 0; i < 10; i++){
            theQueue[i] = new JTextPane();
            theQueue[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            theQueue[i].setFont(new Font("Arial", Font.PLAIN, 20));
            theQueue[i].setBackground(Color.WHITE);
            aQueue.add(theQueue[i]);
        }

        JButton enqueue = new JButton("Enqueue");
        enqueue.setAlignmentX(Component.CENTER_ALIGNMENT);
        enqueue.setAlignmentY(Component.CENTER_ALIGNMENT);
        enqueue.addActionListener(queue);

        JButton deQueue = new JButton("Dequeue");
        deQueue.setAlignmentX(Component.CENTER_ALIGNMENT);
        deQueue.setAlignmentY(Component.CENTER_ALIGNMENT);
        deQueue.addActionListener(dequeue);

        JButton empty = new JButton("Clear Queue");
        empty.setAlignmentX(Component.CENTER_ALIGNMENT);
        empty.setAlignmentY(Component.CENTER_ALIGNMENT);
        empty.addActionListener(emptyQueue);

        info.add(Box.createRigidArea(new Dimension(200, 50)));
        info.add(title);
        info.add(Box.createRigidArea(new Dimension(200, 50)));
        info.add(authors);
        info.add(Box.createRigidArea(new Dimension(200, 50)));
        info.add(enqueue);
        info.add(deQueue);
        info.add(empty);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(info);
        mainPanel.add(aQueue);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
