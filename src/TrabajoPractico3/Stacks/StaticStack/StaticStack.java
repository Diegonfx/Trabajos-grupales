package TrabajoPractico3.Stacks.StaticStack;

import ua.ayed.stack.Stack;

/**
 * Created by DiegoMancini on 24/3/17.
 */
public class StaticStack<T> implements Stack {

    private int top;
    private int capacity;
    private Object[] data;

    public StaticStack(int desiredSize) {
        top = -1;
        capacity = desiredSize;
        data = new Object[capacity];
    }

    @Override
    public void push(Object o) {
        if (top + 1 == data.length ) {
            grow();
        }
        data[++top] = o;
    }

    @Override
    public void pop() {
        top--;
    }

    @Override
    public Object peek() {
        if (!isEmpty()) {
            return data[top];
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else return false;
    }

    @Override
    public int size() {
        return top+1;
    }

    @Override
    public void empty() {
        top = -1;
    }


    private void grow() {
        Object[] data2 = new Object[2 * capacity];
        for (int i = 0 ; i < capacity ; i++) {
            data2[i] = data[i];
        }
        data = data2;
    }
}
