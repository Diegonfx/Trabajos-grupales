package TrabajoPractico4_Queue;

import java.util.EmptyStackException;

/**
 * Created by DiegoMancini on 8/4/17.
 */
public class PriorityQueue<T> {

    private DynamicQueue<T> [] arrayOfQueuesByPriority;

    public PriorityQueue(int amountOfPriority) {
        arrayOfQueuesByPriority = new DynamicQueue[amountOfPriority];
        for (int i = 0 ; i < arrayOfQueuesByPriority.length ; i++) {
            arrayOfQueuesByPriority[i] = new DynamicQueue<T>();
        }
    }

    public void enqueue(T object, int priorityValue) {
        if (priorityValue < arrayOfQueuesByPriority.length) {
            arrayOfQueuesByPriority[priorityValue].enqueue(object);
        }
    }
    public T dequeue() {
        for (int i = 0 ; i < arrayOfQueuesByPriority.length ; i++) {
            if (!arrayOfQueuesByPriority[i].isEmpty()) {
                return arrayOfQueuesByPriority[i].dequeue();
            }
        } throw new EmptyStackException();
    }
    public boolean isEmpty() {
        for (int i = 0; i < arrayOfQueuesByPriority.length; i++) {
            if (!arrayOfQueuesByPriority[i].isEmpty()) {
                return false;
            }
        } return true;
    }
    public DynamicQueue<T> getQueueByPriority(int priority) {
        return arrayOfQueuesByPriority[priority];
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
    public int getSize() {
        int result = 0;
        for (int i = 0; i < arrayOfQueuesByPriority.length; i++) {
            result += arrayOfQueuesByPriority[i].getSize();
        } return result;
    }

}
