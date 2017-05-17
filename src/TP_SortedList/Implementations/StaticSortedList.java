package TP_SortedList.Implementations;

import java.io.Serializable;

/**
 * Implementation of a sorted list (static version).
 * @author Tomas Iturralde
 * @author Diego Mancini
 */
public class StaticSortedList<T extends Comparable<T>> implements SortedList<T>, Serializable{
    private static final int DEFAULT_CAPACITY = 10;
    private Comparable[] data;
    private int window;
    private int size;
    private final int capacity;

    public StaticSortedList() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public StaticSortedList(int capacity) {
        this.data = new Comparable[capacity];
        this.capacity = capacity;
        this.window = 0;
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    private StaticSortedList(int window, int size, int capacity, Object[] data) {
        this.window = window;
        this.size = size;
        this.capacity = capacity;
        this.data = (Comparable [])data;
    }

    @Override
    public void insert(T obj) {
        binaryInsert(obj,data,0,size-1);
    }

    /**
     * private method which uses the binary search to insert an object into the sorted list
     * (the object will be inserted in its right position, no further sorting will be needed).
     * @param k object to be inserted.
     * @param list list (already sorted) which will recieve the object.
     * @param first position in the list.
     * @param last position in the list.
     */
    @SuppressWarnings("unchecked")
    private void binaryInsert(Comparable k, Comparable[] list, int first, int last){
        if (first > last) {
            goTo(first);
            insertPrev(k);
        } else if (isVoid()) {
            data[0] = k;
            size++;
        }
        else {
            int middle = (first + last)/2;
            int tempResult = k.compareTo(list[middle]);
            if (tempResult == 0) {
                goTo(middle);
                insertNext(k);
            } else if (tempResult < 0) {
                binaryInsert(k , list , first , middle-1);
            } else {
                binaryInsert(k , list , middle+1 , last);
            }
        }
    }

    /**
     * @param obj to be inserted before the window.
     */
    private void insertPrev(Comparable obj) {
        if (size == data.length) enlarge();
        for (int i = data.length - 1; i > window; i--) data[i] = data[i - 1];
        data[window] = obj;
        size++;
    }

    /**
     * @param obj to be inserted after the window.
     */
    private void insertNext(Comparable obj) {
        if (size == data.length) enlarge();
        if (!isVoid()) window++;
        insertPrev(obj);
    }

    public void removeS(T element){
        int indexToRemove = binaryRemove(element, data, 0, size);
        goTo(indexToRemove);
        remove();
    }

    /**
     * private method which uses the binary search to return the position of an element to be deleted
     * in the list(no further sorting will be needed).
     * @param k element to be deleted.
     * @param list list which will lose the element.
     * @param first position in the list.
     * @param last position in the list.
     * @return the position of the element to be deleted.
     */
    @SuppressWarnings("unchecked")
    private int binaryRemove(Comparable k, Comparable[] list, int first, int last){
        if (first > last) {
            return -1;
        } else {
            int middle = (first + last)/2;
            int tempResult = k.compareTo(list[middle]);
            if (tempResult == 0) {
                return middle;
            } else if (tempResult < 0) {
                return binaryRemove(k , list , first , middle-1);
            } else {
                return binaryRemove(k , list , middle+1 , last);
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getActual() {
        if (isVoid()) throw new NullPointerException("The list is empty");
        return (T) data[window];
    }
    @Override
    public int getActualPosition() {
        return window;
    }
    @Override
    public boolean isVoid() {
        return data[0] == null;
    }
    @Override
    public boolean endList() {
        return window == data.length - 1;
    }
    @Override
    public StaticSortedList<T> clone() {
        Object[] cloned = new Object[data.length];
        for (int i = 0; i < data.length; i++) cloned[i] = data[i];
        return new StaticSortedList<T>(window, size, capacity, cloned);
    }

    @Override
    public void goNext() {
        if (window == size - 1) throw new IndexOutOfBoundsException("Reached the end of the list");
        window++;
    }
    @Override
    public void goPrev() {
        if (window == 0) throw new IndexOutOfBoundsException("Reached the beginning of the list");
        window--;
    }
    @Override
    public void goTo(int index) {
        if (index < 0 || index >= data.length)
            throw new IndexOutOfBoundsException("There is no such index in this list");
        window = index;
    }
    @Override
    public void remove() {
        for (int i = window; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        if (window >= size) window = size - 1;
    }
    @Override
    public int size() {
        return size;
    }
    @SuppressWarnings("unchecked")
    private void enlarge() {
        Comparable[] tempObjects = (Comparable []) new Object[data.length + DEFAULT_CAPACITY];
        for (int i = 0; i < data.length; i++) tempObjects[i] = data[i];
        data = tempObjects;
    }
}
