package TP_Swing;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Tomas on 11/6/2017.
 */
public class QueueController {
    private QueueView queueView;
    private StaticQueueSwing queue;

    public QueueController(){
        queue = new StaticQueueSwing();
        queueView = new QueueView(new Queue(), new Dequeue(), new EmptyQueue());
    }

    public class Queue implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (queueView.getTheQueue().getQuantity() != 20) {
                int number = randomNumberGenerator();
                if (queueView.getTheQueue().getBackend() != -1) {
                    deletePointer(queueView.getTheQueue().getBackend());
                }

                queue.enqueue(number);
                queueView.getTheQueue().enqueue(number);
                setFrontPointer(queueView.getTheQueue().getFront());
                setBackPointer(queueView.getTheQueue().getBackend());
                queueView.getNumbers()[0].setText("" + number);

                if (queueView.getTheQueue().getBackend() == 9) {
                    for (int i = 0; i < 5; i++) {
                        queueView.getTheQueue().getTheQueue()[i + 10].setVisible(true);
                        queueView.getPointersFoto()[i + 10].setVisible(true);
                        queueView.getPointers()[i + 10].setVisible(true);
                    }
                }

                if (queueView.getTheQueue().getBackend() == 14) {
                    for (int i = 0; i < 5; i++) {
                        queueView.getTheQueue().getTheQueue()[i + 15].setVisible(true);
                        queueView.getPointersFoto()[i + 15].setVisible(true);
                        queueView.getPointers()[i + 15].setVisible(true);
                    }
                }
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
            for (int i = 0; i < 10; i++) {
                queueView.getTheQueue().getTheQueue()[i+10].setVisible(false);
                queueView.getPointersFoto()[i+10].setVisible(false);
                queueView.getPointers()[i+10].setVisible(false);
            }
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

    private void createQueue(JPanel aQueue, StaticQueueSwing theQueue){
        aQueue.setSize(1000 , 1000);
        aQueue.setAlignmentX(Component.CENTER_ALIGNMENT);
        aQueue.setAlignmentY(Component.CENTER_ALIGNMENT);
        aQueue.setLayout(new GridLayout(0,theQueue.getLength()));
        for (int i = 0; i < theQueue.getTheQueue().length; i++) {
            aQueue.add(theQueue.getTheQueue()[i]);
        }
        queueView.setaQueue(aQueue);
    }
}
