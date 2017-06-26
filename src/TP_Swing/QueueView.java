package TP_Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Creates the menu for the static queue.
 * @author Tomas Iturralde
 * @author Diego Mancini
 */
public class QueueView extends JFrame {
    private StaticQueueSwing theQueue = new StaticQueueSwing();
    private JTextPane[] numbers = new JTextPane[3];
    private JPanel aQueue = new JPanel();
    private JPanel pointer = new JPanel();
    private JTextPane[] pointers = new JTextPane[20];
    private JPanel pointerFoto = new JPanel();
    private JLabel[] pointersFoto = new JLabel[20];
    private JPanel mainPanel = new JPanel();

    public QueueView(ActionListener queue, ActionListener dequeue, ActionListener emptyQueue){
        setTitle("Queue Model");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(10000, 10000);

        aQueue.setSize(2000 , 2000);
        aQueue.setAlignmentX(Component.CENTER_ALIGNMENT);
        aQueue.setAlignmentY(Component.CENTER_ALIGNMENT);
        aQueue.setLayout(new GridLayout(0,theQueue.getLength()));
        for (int i = 0; i < theQueue.getLength(); i++) {
            aQueue.add(theQueue.getTheQueue()[i]);
        }

        pointer.setSize(3000 , 3000);
        pointer.setAlignmentX(Component.CENTER_ALIGNMENT);
        pointer.setAlignmentY(Component.CENTER_ALIGNMENT);
        pointer.setLayout(new GridLayout(0,theQueue.getLength()));
        for (int i = 0; i < theQueue.getLength(); i++) {
            pointers[i] = new JTextPane();
            pointers[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            pointers[i].setFont(new Font("Arial", Font.PLAIN, 20));
            pointers[i].setBackground(Color.WHITE);
            pointers[i].setSize(100 , 100);
            pointer.add(pointers[i]);
        }

        pointerFoto.setSize(3000 , 2000);
        pointerFoto.setAlignmentX(Component.CENTER_ALIGNMENT);
        pointerFoto.setAlignmentY(Component.CENTER_ALIGNMENT);
        pointerFoto.setLayout(new GridLayout(0,theQueue.getLength()));
        ImageIcon blank = new ImageIcon("src/TP_Swing/blank.png");
        for (int i = 0; i < theQueue.getLength(); i++) {
            pointersFoto[i] = new JLabel();
            pointersFoto[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            pointersFoto[i].setFont(new Font("Arial", Font.PLAIN, 20));
            pointersFoto[i].setBackground(Color.WHITE);
            pointersFoto[i].setSize(100 , 100);
            pointersFoto[i].setIcon(blank);
            pointerFoto.add(pointersFoto[i]);
        }

        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.PAGE_AXIS));
        info.setSize(500, 500);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(0,3));
        buttons.setSize(500,500);

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

        JPanel multiplier = new JPanel();
        multiplier.setLayout(new GridLayout(0,3));
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new JTextPane();
            numbers[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numbers[i].setFont(new Font("Arial", Font.PLAIN, 20));
            numbers[i].setBackground(Color.WHITE);
            numbers[i].setSize(50,50);
            multiplier.add(numbers[i]);
        }

        JPanel labels = new JPanel();
        labels.setLayout(new GridLayout(0,3));
        labels.setSize(1000,1000);

        JLabel enqueued = new JLabel("Dato encolado:");
        enqueued.setFont(new Font(enqueued.getFont().getName(), Font.ROMAN_BASELINE, 20));
        labels.add(enqueued);

        labels.add(Box.createRigidArea(new Dimension(50, 50)));

        JLabel dequeued = new JLabel("Dato desencolado:");
        dequeued.setFont(new Font(dequeued.getFont().getName(), Font.ROMAN_BASELINE, 20));
        labels.add(dequeued);

        info.add(labels);
        info.add(multiplier);
        info.add(Box.createRigidArea(new Dimension(500, 50)));
        info.add(buttons);
        info.add(Box.createRigidArea(new Dimension(50,50)));

        mainPanel.setSize(10000,10000);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(info);
        mainPanel.add(aQueue);
        mainPanel.add(pointerFoto);
        mainPanel.add(pointer);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public StaticQueueSwing getTheQueue() {
        return theQueue;
    }
    public JTextPane[] getNumbers() {
        return numbers;
    }
    public JPanel getPointer() {
        return pointer;
    }
    public JPanel getaQueue() {
        return aQueue;
    }
    public JPanel getPointerFoto() {
        return pointerFoto;
    }
    public JTextPane[] getPointers() {
        return pointers;
    }
    public JLabel[] getPointersFoto() {
        return pointersFoto;
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }
    public void setPointer(JPanel pointer) {
        this.pointer = pointer;
    }
    public void setPointers(JTextPane[] pointers) {
        this.pointers = pointers;
    }
    public void setPointerFoto(JPanel pointerFoto) {
        this.pointerFoto = pointerFoto;
    }
    public void setPointersFoto(JLabel[] pointersFoto) {
        this.pointersFoto = pointersFoto;
    }
    public void setaQueue(JPanel aQueue) {
        this.aQueue = aQueue;
    }
}
