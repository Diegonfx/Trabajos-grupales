package TPSwing_StaticQueue;

import java.util.Random;

/**
 * Created by DiegoMancini on 9/6/17.
 */
public class StaticQueueInteger {

    private int[] data;
    private int size;
    private int front;
    private int backend;
    private int initialCapacity = 10;
    private int quantity;

    public StaticQueueInteger() {
        data = new int[initialCapacity];
        size = 0;
        front = 0;
        backend = front - 1;
    }
    public StaticQueueInteger(int capacity) {
        data = new int[capacity];
        size = 0;
        front = 0;
        backend = front - 1;
    }

    public void enqueue(int customGrowSize) {
        Random r = new Random();
        int low = 0;
        int high = 1001;
        int result = r.nextInt(high-low) + low;
        if (size == data.length) {
            doubleQueue(customGrowSize);
        } else {
            backend = increment(backend);
            data[backend] = result;
            size++;
            quantity++;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Array is empty");
        }
        size--;
        int returnValue = data[front];
        front = increment(front);
        quantity--;
        return returnValue;
    }


    private void doubleQueue(int amount) {
        int[] newArray = new int[data.length * amount];
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

    public int getFront() {
        if (isEmpty()) {
            throw new RuntimeException("Array is empty");
        }
        return data[front];
    }

    public int getActual() {
        return data[quantity];
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

    public int[] getData() {
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


}
