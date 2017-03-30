package TrabajoPractico3.Stacks.DynamicStack;

/**
 * Creates a dynamic stack using nodes
 * @author Tomas Iturralde
 * @author Diego Mancini
 */
public class DynamicStack<T>{

    private int length;
    private LinkedNode<T> topOfStack;

    public DynamicStack() {
        length = 0;
        topOfStack = null;
    }

    /** **/
    @SuppressWarnings("unchecked")
    public void push(T data) {
        LinkedNode newTopOfStack = new LinkedNode(data);
        if (topOfStack == null) {
            topOfStack = newTopOfStack;
        } else {
            newTopOfStack.next = topOfStack;
            topOfStack = newTopOfStack;
        }
        length++;
    }

    /** **/
    @SuppressWarnings("unchecked")
    public void pop() {
        LinkedNode oldTopOfStack = topOfStack;
        topOfStack = topOfStack.getNext();
        oldTopOfStack = null;
        length--;
    }

    /** **/
    public T peek() {
        return topOfStack.getData();
    }

    /** **/
    public boolean isEmpty() {
        if (length == 0) {
            return true;
        } return false;
    }

    /** **/
    @SuppressWarnings("unchecked")
    public int size() {
        return length;
    }

    public void empty() {
        topOfStack = null;
        length = 0;
    }

    /**
     * Creates a node which stores a type of data, and has a reference to the next node
     * @param <T> type of data used inside the node
     */
    private final static class LinkedNode<T> {

        private T data;
        private LinkedNode next;

        public LinkedNode(T data) {
            this.data = data;
        }

        public LinkedNode(T data, LinkedNode next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public LinkedNode getNext() {
            return next;
        }

    }
}
