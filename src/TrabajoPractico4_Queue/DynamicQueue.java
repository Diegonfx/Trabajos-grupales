package TrabajoPractico4_Queue;


/**
 * Created by DiegoMancini on 7/4/17.
 */
public class DynamicQueue<T> {

    private class Node<T>{
        private Node next;
        private T element;

        private Node(T t){
            element = t;
        }
        private T getElement(){
            return element;
        }
        private Node getNext(){
            return next;
        }
    }
    private Node<T> front;
    private Node<T> backend;
    private int size;

    public DynamicQueue() {
        front = null;
        backend = null;
        size = 0;
    }

    public void enqueue(T object) {
        if (isEmpty()) {
            backend = front = new Node<>(object);
        } else {
            backend = backend.next = new Node<T>(object);
            size++;
        }
    }
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("DATA dequeue");
        } else {
            T returnValue = front.element;
            front = front.next;
            size--;
            return returnValue;
        }
    }
    public T getFront() {
        if (isEmpty()) {
            throw new RuntimeException("DATA getFront");
        } else {
            return front.element;
        }
    }
    public boolean isEmpty() {
        if (front == null) {
            return true;
        } return false;
    }
    public void makeEmpty() {
        front = null;
        backend = null;
        size = 0;
    }
    public int getSize() {
        return size;
    }
    public Node<T> getBackendNode() {
        return backend;
    }
    public Node<T> getFrontNode() { return front; }
}
