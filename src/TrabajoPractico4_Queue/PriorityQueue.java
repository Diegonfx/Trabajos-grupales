package TrabajoPractico4_Queue;

import java.util.EmptyStackException;

/**
 * Class that creates a priority queue.
 * @author Diego Mancini
 * @author Tomas Iturralde
 */
public class PriorityQueue<T> {
    private DynamicQueue<T>[] arrayOfQueuesByPriority;

    @SuppressWarnings("unchecked")
    public PriorityQueue(int amountOfPriority) {
        arrayOfQueuesByPriority = new DynamicQueue[amountOfPriority];
        for (int i = 0 ; i < arrayOfQueuesByPriority.length ; i++) {
            arrayOfQueuesByPriority[i] = new DynamicQueue<>();
        }
    }

    public void enqueue(T object, int priorityValue) {
        if (priorityValue < arrayOfQueuesByPriority.length) {
            arrayOfQueuesByPriority[priorityValue].enqueue(object);
        }
    }

    public T dequeue() {
        for (int i = 0 ; i < arrayOfQueuesByPriority.length ; i++) {
            if (!arrayOfQueuesByPriority[i].isEmpty()) { return arrayOfQueuesByPriority[i].dequeue(); }
        } throw new EmptyStackException();
    }

    public boolean isEmpty() {
        for (int i = 0; i < arrayOfQueuesByPriority.length; i++) {
            if (!arrayOfQueuesByPriority[i].isEmpty()) { return false; }
        } return true;
    }

    public T getHighestPriority() {
        for (int i = 0; i < arrayOfQueuesByPriority.length; i++) {
            if (!arrayOfQueuesByPriority[i].isEmpty()) {
                return arrayOfQueuesByPriority[i].getFront();
            }
        } throw new EmptyStackException();
    }

    public void empty() {
        for (int i = 0; i < arrayOfQueuesByPriority.length; i++) {
            arrayOfQueuesByPriority[i] = null;
        }
    }

    public DynamicQueue<T> getQueueByPriority(int priority) {
        return arrayOfQueuesByPriority[priority];
    }
}
