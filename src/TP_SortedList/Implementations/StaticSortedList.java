package TP_SortedList.Implementations;

/**
 * Created by Tomas on 10/5/2017.
 */
public class StaticSortedList<T extends Comparable<T>> implements SortedList<T>{
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

    private void insertPrev(Comparable obj) {
        if (size == data.length) enlarge();
        for (int i = data.length - 1; i > window; i--) data[i] = data[i - 1];
        data[window] = obj;
        size++;
    }

    private void insertNext(Comparable obj) {
        if (size == data.length) enlarge();
        if (!isVoid()) window++;
        insertPrev(obj);
    }

    public void removeS(T element){
        int indexToRemove = binarySearch(element, data, 0, size);
        goTo(indexToRemove);
        remove();
    }

    @SuppressWarnings("unchecked")
    private int binarySearch(Comparable k, Comparable[] list, int first, int last){
        if (first > last) {
            return -1;
        } else {
            int middle = (first + last)/2;
            int tempResult = k.compareTo(list[middle]);
            if (tempResult == 0) {
                return middle;
            } else if (tempResult < 0) {
                return binarySearch(k , list , first , middle-1);
            } else {
                return binarySearch(k , list , middle+1 , last);
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

    public static void main(String[] args) {
        StaticSortedList<Integer> list = new StaticSortedList<>();
        list.insert(2);
        list.insert(1);
        list.insert(7);
        list.insert(3);
        list.insert(1);
        list.insert(9);
        list.insert(4);
        list.insert(9);
        list.insert(2);
        list.insert(5);
        list.insert(8);

        for (int i = 0; i < list.size(); i++){
            list.goTo(i);
            System.out.println(list.getActual());
        }


    }
}
