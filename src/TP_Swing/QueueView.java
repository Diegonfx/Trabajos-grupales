package TP_Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Tomas on 11/6/2017.
 */
public class QueueView extends JFrame {
    private StaticQueueSwing theQueue = new StaticQueueSwing();
    private JTextField[] numbers = new JTextField[3];

    public QueueView(ActionListener queue, ActionListener dequeue, ActionListener emptyQueue , ActionListener multiplierFactor){
        setTitle("Queue Model");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);

        JPanel aQueue = new JPanel();
        aQueue.setSize(1000 , 1000);
        aQueue.setAlignmentX(Component.CENTER_ALIGNMENT);
        aQueue.setAlignmentY(Component.CENTER_ALIGNMENT);
        aQueue.setLayout(new GridLayout(0,10));
        for (int i = 0; i < theQueue.getTheQueue().length; i++) {
            aQueue.add(theQueue.getTheQueue()[i]);
        }

        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.PAGE_AXIS));
        info.setSize(1000, 1000);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(0,3));
        buttons.setSize(1000,1000);

        JButton enqueue = new JButton("Enqueue");
        enqueue.setAlignmentX(Component.CENTER_ALIGNMENT);
        enqueue.setAlignmentY(Component.CENTER_ALIGNMENT);
        enqueue.addActionListener(queue);
        buttons.add(enqueue);

        JButton deQueue = new JButton("Dequeue");
        deQueue.setAlignmentX(Component.CENTER_ALIGNMENT);
        deQueue.setAlignmentY(Component.CENTER_ALIGNMENT);
        deQueue.addActionListener(dequeue);
        buttons.add(deQueue);

        JButton empty = new JButton("Clear Queue");
        empty.setAlignmentX(Component.CENTER_ALIGNMENT);
        empty.setAlignmentY(Component.CENTER_ALIGNMENT);
        empty.addActionListener(emptyQueue);
        buttons.add(empty);

        JButton applyMultiplier = new JButton("Apply Multiplier");
        applyMultiplier.setAlignmentX(Component.CENTER_ALIGNMENT);
        applyMultiplier.setAlignmentY(Component.CENTER_ALIGNMENT);
        applyMultiplier.addActionListener(multiplierFactor);

        JPanel multiplier = new JPanel();
        multiplier.setLayout(new GridLayout(0,3));
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new JTextField();
            numbers[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numbers[i].setFont(new Font("Arial", Font.PLAIN, 20));
            numbers[i].setBackground(Color.WHITE);
            numbers[i].setHorizontalAlignment(JTextField.CENTER);
            numbers[i].setSize(50,50);
            multiplier.add(numbers[i]);
        }

        JPanel labels = new JPanel();
        labels.setLayout(new GridLayout(0,3));
        labels.setSize(1000,1000);

        JLabel enqueued = new JLabel("Dato encolado:");
        enqueued.setFont(new Font(enqueued.getFont().getName(), Font.ROMAN_BASELINE, 20));
        labels.add(enqueued);

        JLabel multiply = new JLabel("Multiplicador:");
        multiply.setFont(new Font(multiply.getFont().getName(), Font.ROMAN_BASELINE, 20));
        labels.add(multiply);

        JLabel dequeued = new JLabel("Dato desencolado:");
        dequeued.setFont(new Font(dequeued.getFont().getName(), Font.ROMAN_BASELINE, 20));
        labels.add(dequeued);

        info.add(Box.createRigidArea(new Dimension(500, 50)));
        info.add(buttons);
        info.add(Box.createRigidArea(new Dimension(50,50)));
        info.add(labels);
        info.add(multiplier);
        info.add(applyMultiplier);

        JPanel mainPanel = new JPanel();
        mainPanel.setSize(1500,1500);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(aQueue);
        mainPanel.add(info);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public StaticQueueSwing getTheQueue() {
        return theQueue;
    }
    public JTextField[] getNumbers() {
        return numbers;
    }
}
