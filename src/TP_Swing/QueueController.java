package TP_Swing;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Tomas on 11/6/2017.
 */
public class QueueController {
    private QueueView queueView;
    private StaticQueue<Integer> queue;

    public QueueController(){
        queue = new StaticQueue<>(10);
        queueView = new QueueView(new Queue(), new Dequeue(), new EmptyQueue());
    }

    public class Queue implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int random = ThreadLocalRandom.current().nextInt(0, 1000);
            queue.enqueue(random);

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
}
