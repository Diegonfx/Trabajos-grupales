package TP_Swing;


import javax.swing.*;
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
            int number = randomNumberGenerator();
            if (queueView.getTheQueue().getBackend() != -1){
                deletePointer(queueView.getTheQueue().getBackend());
            }

            queue.enqueue(number);
            queueView.getTheQueue().enqueue(number);
            setFrontPointer(queueView.getTheQueue().getFront());
            setBackPointer(queueView.getTheQueue().getBackend());
            queueView.getNumbers()[0].setText("" + number);
            if (queueView.getTheQueue().isFull()) {

                //queueView.createQueue(queueView.getaQueue(), queueView.getTheQueue());
                queueView.getaQueue().revalidate();
                queueView.getaQueue().repaint();
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
}
