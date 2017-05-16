package Mancini_ParcialCassol.Colas;

/**
 * Class that creates a queue (static).
 * @author Diego Mancini
 * @author Tomas Iturralde
 */
public class StaticQueue<T> {

    private T[] data;
    private int size;
    private int front;
    private int backend;
    private int initialCapacity = 10;
    private int quantity;

    public StaticQueue() {
        data = (T[]) new Object[initialCapacity];
        size = 0;
        front = 0;
        backend = front - 1;
    }
    public StaticQueue(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
        front = 0;
        backend = front - 1;
    }

    public void enqueue(T object) {
        if (size == data.length) {
            doubleQueue();
        } else {
            backend = increment(backend);
            data[backend] = object;
            size++;
            quantity++;
        }
    }
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Array is empty");
        }
        size--;
        T returnValue = data[front];
        front = increment(front);
        quantity--;
        return returnValue;
    }
    public T getFront() {
        if (isEmpty()) {
            throw new RuntimeException("Array is empty");
        }
        return data[front];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void empty() {
        size = 0;
        front = 0;
        backend = front-1;
        quantity = 0;
    }
    public T[] getData() {
        return data;
    }
    public int getSize() {
        return size;
    }
    public int getBackend() {
        return backend;
    }
    public int getInitialCapacity() {
        return initialCapacity;
    }
    public int getQuantity() {
        return quantity;
    }

    /**
     * method grow()
     */
    private void doubleQueue() {
        T[] newArray = (T[]) new Object[data.length * 2];
        for (int i = 0; i < size; i++ ) {
            front = increment(front);
            newArray[i] = data[front];
        }
        data = newArray;
        front = 0;
        backend = size-1;
    }

    /**
     * Internal method to increment the value of size+1 if the value of size is at least data.length -1.
     * If it happens to be the same value, it would be assigned the value 0 (start of array) due to circular linking chain
     * Circular linking chain means that to reutilize the array, if the stored object at front isn't at position 0, it will store the back object
     * at position 0 and start from there.
     * @param size is the value to be increased by one
     * @return the size of the value
     */
    private int increment(int size) {
        if (++size == data.length-1) {
            size = 0;
        } return size;
    }

}
