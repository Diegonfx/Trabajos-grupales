package TrabajoPractico3.Stacks.DynamicStack;

/**
 * Created by DiegoMancini on 24/3/17.
 */
public class DynamicStack<T>{

    private LinkedNode<T> topOfStack;

    public DynamicStack() {
        topOfStack = null;
    }

    @SuppressWarnings("unchecked")
    public void push(T data) {
        LinkedNode newTopOfStack = new LinkedNode(data);
        newTopOfStack.next = topOfStack;
        topOfStack = newTopOfStack;
    }

    @SuppressWarnings("unchecked")
    public void pop() {
        LinkedNode oldTopOfStack = topOfStack;
        topOfStack = topOfStack.next;
        oldTopOfStack = null;
    }

    public T peek() {
        return topOfStack.data;
    }

    public boolean isEmpty() {
        if (topOfStack != null) {
            return false;
        } return true;
    }

    @SuppressWarnings("unchecked")
    public int size() {
        int result = 0;
        while (topOfStack != null) {
            LinkedNode oldTopOfStack = topOfStack;
            topOfStack = topOfStack.next;
            result ++;
        }
        return result;
    }

    public void empty() {
        topOfStack = null;
    }

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
