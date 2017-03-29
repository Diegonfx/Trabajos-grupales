package TrabajoPractico3.Stacks.StaticStack;

/**
 * Creates a static stack using an array
 * @author Tomas Iturralde
 * @author Diego Mancini
 */
public class StaticStack<T>{

    private int top;
    private int capacity;
    private Object[] data;

    public StaticStack(int desiredSize) {
        top = -1;
        capacity = desiredSize;
        data = new Object[capacity];
    }

    /**
     * Adds an object to the last position in the stack, if the stack is full it enlarges it and then adds the object.
     * @param o to be added to the stack.
     */
    public void push(T o) {
        if (top + 1 == data.length ) {
            grow();
        }
        data[++top] = o;
    }

    /**
     * Takes out the last element added to the stack.
     */
    public void pop() {
        top--;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (!isEmpty()) {
            return (T)data[top];
        }
        return null;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public void empty() {
        top = -1;
    }

    /**
     * private method used to enlarge the size of the array, because a stack should have unlimited capacity.
     * It creates another array with double the size of the original one, copies everything from the first one
     * to the new one, then the new one is assigned to the original one.
     */
    private void grow() {
        Object[] data2 = new Object[2 * capacity];
        for (int i = 0 ; i < capacity ; i++) {
            data2[i] = data[i];
        }
        data = data2;
    }
}
