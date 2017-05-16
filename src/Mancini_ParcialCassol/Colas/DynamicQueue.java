package Mancini_ParcialCassol.Colas;


/**
 * Class that creates a queue (dynamic).
 * @author Diego Mancini
 * @author Tomas Iturralde
 */
public class DynamicQueue<T> {
    private Node<T> front;
    private Node<T> backend;
    private int size;

    public DynamicQueue() {
        front = null;
        backend = null;
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public void enqueue(T object) {
        if (isEmpty()) {
            backend = front = new Node<>(object);
        } else {
            backend = backend.next = new Node<T>(object);
            size++;
        }
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (this.isEmpty()) {
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

    /**
     * Private Class used to create nodes for the dynamic queue to use.
     * @param <Q> type of data the node uses.
     */
    private class Node<Q>{
        private Node next;
        private Q element;

        private Node(Q t){
            element = t;
        }
        private Q getElement(){
            return element;
        }
        private Node getNext(){
            return next;
        }
    }
}
