package TP_SortedList.Implementations;

import TP_Lists.Listas.DynamicList;
import TP_Lists.Listas.GeneralList;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Created by Tomas on 10/5/2017.
 */
public class DynamicSortedList<T extends Comparable<T>> implements Iterable<T> , Serializable, SortedList<T>  {

    private ListNode<T> head;
    private ListNode<T> tail;
    private ListNode<T> current;
    private int length;
    private class SortedListIterator implements Iterator<T> {

        public SortedListIterator() {
        DynamicSortedList.this.first();
        }

        @Override
        public boolean hasNext() {
            return DynamicSortedList.this.hasNext();
        }

        @Override
        public T next() {
            DynamicSortedList.this.current = current.next;
            return DynamicSortedList.this.getActual();
        }

        @Override
        public void remove() {
            DynamicSortedList.this.remove();
        }
    }

    public DynamicSortedList(){
        head = new ListNode<>();
        tail = new ListNode<>();
        head.next = tail;
        tail.before = head;
        length = 0;
    }

    public boolean contains(T object){
        this.first();
        while (this.next() && (object.compareTo(this.getActual()) >= 0)){
            if(this.getActual().equals(object)){
                return true;
            }
        }
        return false;
    }

    public void remove(T object){
        if(contains(object)){
            this.first();
            while (this.next()&&(object.compareTo(this.getActual()) >= 0)){
                if(this.getActual().equals(object)){
                    this.remove();
                }
            }
        }
    }

    @Override
    public void insert(T obj) {
        if(this.isEmpty()){
            this.insertAfter(obj);
            return;
        }

        this.first();
        while (this.next() && (obj.compareTo(this.getActual()) >= 0));


        if(obj.compareTo(this.getActual())>=0){
            this.insertAfter(obj);
        }else {
            this.insertBefore(obj);
        }
    }

    @Override
    public void goNext() {
        if(current.next == tail) throw new IndexOutOfBoundsException("Reached the end of this List");
        current = current.next;
    }

    @Override
    public void goPrev() {
        if(current == head.next) throw new IndexOutOfBoundsException("Reached the beginning of this List");
        goBack();
    }
    private void goBack(){
        ListNode<T> aux = head;
        while(current != aux.next){
            aux = aux.next;
        }
        current = aux;
    }

    @Override
    public void goTo(int n) {
        current = head.next;
        for(int i = 0; i < n; i++){
            current = current.next;
        }
    }

    @Override
    public T getActual() {
        return current.element;
    }

    @Override
    public int getActualPosition() {
        int pos = 0;
        if (!isVoid()) {
            ListNode<T> aux = head;
            for (; aux.next != current; pos++) aux = aux.next;
        }
        return pos;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isVoid() {
        return head.next == tail;
    }

    @Override
    public boolean endList() {
        return current.next == tail;
    }

    @Override
    public GeneralList<T> clone() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new SortedListIterator();
    }

    public void first(){
        current = head;
    }

    public boolean before(){
        if (current != current.next){
            current = current.before;
            return true;
        }
        return false;
    }

    public boolean next(){
        current = current.next;
        return hasNext();
    }

    public boolean hasNext(){
        if(current != current.before){
            return true;
        }
        return false;
    }

    private void insertBefore(T x){
        if (isEmpty()){
            insertEmpty(x);
            return;
        }

        ListNode<T> aux = new ListNode<>(x, current.before, current);
        current.before.next = aux;
        current.before = aux;
        length++;
    }

    private void insertAfter(T x){
        if (isEmpty()) {
            insertEmpty(x);
            return;
        }

        ListNode<T> aux = new ListNode<>(x, current, current.next);
        current.next.before = aux;
        current.next = aux;


        length++;
    }

    private void insertEmpty(T x) {
        ListNode<T> aux = new ListNode<>(x, head, tail);
        head.next = aux;
        tail.before = aux;
        length++;
    }

    @Override
    public void remove(){
        current = current.before;
        current.next.next.before = current;
        current.next = current.next.next;
        length--;
    }

    public boolean isEmpty(){
        return (length == 0);
    }

    public static void main(String[] args) {

        DynamicSortedList<Integer> list = new DynamicSortedList<>();

        list.insert(10);
        list.insert(8);
        list.insert(4);
        list.insert(3);
        list.insert(9);
        //Si agregas uno mayor que el primero, crashea. Despues corre bien sino
        //list.insert(100);



        for (int i = 0; i < list.size(); i++){
            list.goTo(i);
            System.out.println(list.getActual());
        }


    }


}
