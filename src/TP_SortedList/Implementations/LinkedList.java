package TP_SortedList.Implementations;

import java.io.Serializable;

/**
 * Created by DiegoMancini on 17/5/17.
 */
public class LinkedList<T> implements Serializable{

    private ListNode<T> head;
    private ListNode<T> tail;
    private ListNode<T> current;
    private int length;

    public LinkedList(){
        head = new ListNode<>();
        tail = new ListNode<>();
        head.next = tail;
        tail.before = head;
    }

    public void first(){
        current = head;
    }

    public boolean before(){
        if (current != head.next){
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
        if(current != tail.before){
            return true;
        }
        return false;
    }

    public void insertBefore(T x){
        if (isEmpty()){
            insertEmpty(x);
            return;
        }

        ListNode<T> aux = new ListNode<>(x, current.before, current);
        current.before.next = aux;
        current.before = aux;
        length++;
    }

    public void insertAfter(T x){
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

    public void remove(){
        current = current.before;
        current.next.next.before = current;
        current.next = current.next.next;
        length--;
    }
    public boolean isEmpty(){
        return (length == 0);
    }

    public boolean contains(Object x){
        if (!isEmpty()){
            ListNode<T> aux = head.next;
            while(aux.next != null){
                if( aux.element == x){
                    return true;
                }
                aux = aux.next;
            }
        }
        return false;
    }

    public T get(){
        return (current.element);
    }

    public int getCursorIndex(){
        ListNode<T> aux = head.next;
        int counter = 1;
        while (aux != current){
            counter ++;
            aux = aux.next;
        }
        return counter;
    }

    public int getLength() {
        return length;
    }

}
