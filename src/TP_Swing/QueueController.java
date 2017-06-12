package TP_Swing;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            queue.enqueue();
        }
    }

    public class Dequeue implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            queue.dequeue();
        }
    }

    public class EmptyQueue implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            queue.empty();
        }
    }

    public class MultiplierFactor implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            queue.setMultiplierFactor();
        }
    }
}
