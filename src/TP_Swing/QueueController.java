package TP_Swing;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Controller of a static queue.
 * @author Tomas Iturralde
 * @author Diego Mancini
 */
public class QueueController {
    private QueueView queueView;
    private StaticQueueSwing queue;
    private int growCounter;

    public QueueController(){
        queue = new StaticQueueSwing();
        queueView = new QueueView(new Queue(), new Dequeue(), new EmptyQueue());
    }

    public class Queue implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (queueView.getTheQueue().getQuantity() != queueView.getTheQueue().getLength()) {
                int number = randomNumberGenerator();
                if (queueView.getTheQueue().getBackend() != -1) {
                    deletePointer(queueView.getTheQueue().getBackend());
                }

                queue.enqueue(number);
                queueView.getTheQueue().enqueue(number);
                setFrontPointer(queueView.getTheQueue().getFront());
                setBackPointer(queueView.getTheQueue().getBackend());
                queueView.getNumbers()[0].setText("" + number);

            } else if (growCounter < 2){
                queueView.getMainPanel().remove(queueView.getaQueue());
                queueView.getMainPanel().remove(queueView.getPointerFoto());
                queueView.getMainPanel().remove(queueView.getPointer());
                queueView.getTheQueue().growQueue();
                queue.growQueue();
                JPanel newQueue = createQueue(queueView.getTheQueue());
                JPanel newPointer = growPointer(queueView.getTheQueue());
                JPanel newPointerFoto = growPointerFoto(queueView.getTheQueue());
                queueView.setaQueue(newQueue);
                queueView.getMainPanel().add(newQueue);
                queueView.getMainPanel().add(newPointerFoto);
                queueView.getMainPanel().add(newPointer);
                queueView.getMainPanel().revalidate();
                queueView.getMainPanel().repaint();
                queueView.revalidate();
                queueView.repaint();
                queueView.pack();
                queueView.setLocationRelativeTo(null);
                growCounter++;
            }
        }
    }

    public class Dequeue implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            deletePointer(queueView.getTheQueue().getFront());
            queue.dequeue();
            queueView.getNumbers()[2].setText(queueView.getTheQueue().dequeue());
            if (!queueView.getTheQueue().isEmpty())
                setFrontPointer(queueView.getTheQueue().getFront());
        }
    }

    public class EmptyQueue implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            deletePointer(queueView.getTheQueue().getFront());
            deletePointer(queueView.getTheQueue().getBackend());
            queue.empty();
            queueView.getTheQueue().empty();

        }
    }

    private int randomNumberGenerator(){
        return ThreadLocalRandom.current().nextInt(0, 1001);
    }

    private void setFrontPointer(int position){
        queueView.getPointers()[position].setText("Head");
        ImageIcon arrow = new ImageIcon("src/TP_Swing/arrow.png");
        queueView.getPointersFoto()[position].setIcon(arrow);
    }

    private void setBackPointer(int position){
        queueView.getPointers()[position].setText("Back");
        ImageIcon arrow = new ImageIcon("src/TP_Swing/arrow.png");
        queueView.getPointersFoto()[position].setIcon(arrow);
    }

    private void deletePointer(int position){
        queueView.getPointers()[position].setText("");
        ImageIcon blank = new ImageIcon("src/TP_Swing/blank.png");
        queueView.getPointersFoto()[position].setIcon(blank);
    }

    private JPanel createQueue(StaticQueueSwing theQueue){
        JPanel aQueue = new JPanel();
        aQueue.setSize(2000 , 2000);
        aQueue.setAlignmentX(Component.CENTER_ALIGNMENT);
        aQueue.setAlignmentY(Component.CENTER_ALIGNMENT);
        aQueue.setLayout(new GridLayout(0,theQueue.getLength()));
        for (int i = 0; i < theQueue.getTheQueue().length; i++) {
            aQueue.add(theQueue.getTheQueue()[i]);
        }
        return aQueue;
    }

    private JPanel growPointer(StaticQueueSwing queue){
        JTextPane[] pointers = new JTextPane[queue.getLength()];
        JPanel pointer = new JPanel();
        pointer.setSize(3000 , 3000);
        pointer.setAlignmentX(Component.CENTER_ALIGNMENT);
        pointer.setAlignmentY(Component.CENTER_ALIGNMENT);
        pointer.setLayout(new GridLayout(0,queue.getLength()));
        for (int i = 0; i < queue.getLength(); i++) {
            pointers[i] = new JTextPane();
            pointers[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            pointers[i].setFont(new Font("Arial", Font.PLAIN, 20));
            pointers[i].setBackground(Color.WHITE);
            pointers[i].setSize(100 , 100);
            pointer.add(pointers[i]);
        }
        pointers[queue.getFront()].setText("Head");
        pointers[queue.getBackend()].setText("Back");
        queueView.setPointer(pointer);
        queueView.setPointers(pointers);
        return pointer;
    }

    private JPanel growPointerFoto(StaticQueueSwing queue){
        JLabel[] pointersFoto = new JLabel[queue.getLength()];
        JPanel pointerFoto = new JPanel();
        pointerFoto.setSize(3000 , 2000);
        pointerFoto.setAlignmentX(Component.CENTER_ALIGNMENT);
        pointerFoto.setAlignmentY(Component.CENTER_ALIGNMENT);
        pointerFoto.setLayout(new GridLayout(0,queue.getLength()));
        ImageIcon blank = new ImageIcon("src/TP_Swing/blank.png");
        ImageIcon arrow = new ImageIcon("src/TP_Swing/arrow.png");
        for (int i = 0; i < queue.getLength(); i++) {
            pointersFoto[i] = new JLabel();
            pointersFoto[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            pointersFoto[i].setFont(new Font("Arial", Font.PLAIN, 20));
            pointersFoto[i].setBackground(Color.WHITE);
            pointersFoto[i].setSize(100 , 100);
            pointersFoto[i].setIcon(blank);
            pointerFoto.add(pointersFoto[i]);
        }
        pointersFoto[queue.getFront()].setIcon(arrow);
        pointersFoto[queue.getBackend()].setIcon(arrow);
        queueView.setPointersFoto(pointersFoto);
        queueView.setPointerFoto(pointerFoto);
        return pointerFoto;
    }
}
