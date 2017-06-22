package TP_Swing;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Tomas on 11/6/2017.
 */
public class QueueController {
    private QueueView queueView;
    private StaticQueueInteger queue;

    public QueueController(){
        queue = new StaticQueueInteger();
        queueView = new QueueView(new Queue(), new Dequeue(), new EmptyQueue() , new MultiplierFactor());
    }

    public class Queue implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int number = randomNumberGenerator();
            queue.enqueue(number);
            queueView.getTheQueue().enqueue(number);
            queueView.getNumbers()[0].setText("" + number);
        }
    }

    public class Dequeue implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            queue.dequeue();
            queueView.getNumbers()[2].setText(queueView.getTheQueue().dequeue());

        }
    }

    public class EmptyQueue implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            queue.empty();
            queueView.getTheQueue().empty();
        }
    }

    public class MultiplierFactor implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!queueView.getNumbers()[1].getText().equals("")) {
                queue.setMultiplierFactor(Integer.parseInt(queueView.getNumbers()[1].getText()));
                queueView.getTheQueue().setMultiplierFactor(Integer.parseInt(queueView.getNumbers()[1].getText()));
            }
        }
    }

    private int randomNumberGenerator(){
        return ThreadLocalRandom.current().nextInt(0, 1001);
    }
}
