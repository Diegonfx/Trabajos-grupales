package TrabajoPractico4_Queue;

import java.util.EmptyStackException;

/**
 * Tester for the PriorityQueue
 * @author Diego Mancini
 * @author Tomas Iturralde
 */
public class Tester {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(3);
        queue.enqueue(1,0);
        queue.enqueue(2,0);
        queue.enqueue(3,0);
        queue.enqueue(4,1);
        queue.enqueue(5,1);
        queue.enqueue(6,1);
        queue.enqueue(7,2);
        queue.enqueue(8,2);
        queue.enqueue(9,2);
        queue.enqueue(10,0);

        try{
            System.out.println("Highest priority: " + queue.getHighestPriority());
            System.out.println("remove item: " + queue.dequeue());
            System.out.println("------------------");
            System.out.println("Highest priority: " + queue.getHighestPriority());
            System.out.println("remove item: " + queue.dequeue());
            System.out.println("------------------");
            System.out.println("Highest priority: " + queue.getHighestPriority());
            System.out.println("remove item: " + queue.dequeue());
            System.out.println("------------------");
            System.out.println("Highest priority: " + queue.getHighestPriority());
            System.out.println("remove item: " + queue.dequeue());
            System.out.println("------------------");
            System.out.println("Highest priority: " + queue.getHighestPriority());
            System.out.println("remove item: " + queue.dequeue());
            System.out.println("------------------");
            System.out.println("Highest priority: " + queue.getHighestPriority());
            System.out.println("remove item: " + queue.dequeue());
            System.out.println("------------------");
            System.out.println("Highest priority: " + queue.getHighestPriority());
            System.out.println("remove item: " + queue.dequeue());
            System.out.println("------------------");
            System.out.println("Highest priority: " + queue.getHighestPriority());
            System.out.println("remove item: " + queue.dequeue());
            System.out.println("------------------");
            System.out.println("Highest priority: " + queue.getHighestPriority());
            System.out.println("remove item: " + queue.dequeue());
            System.out.println("------------------");
            System.out.println("Highest priority: " + queue.getHighestPriority());
            System.out.println("remove item: " + queue.dequeue());
            System.out.println("------------------");
            System.out.println("Highest priority: " + queue.getHighestPriority());
            System.out.println("remove item: " + queue.dequeue());
        } catch (EmptyStackException e){
            System.out.println("There are no elements in the queue.");
        }
    }
}
