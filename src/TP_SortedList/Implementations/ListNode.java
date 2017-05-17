package TP_SortedList.Implementations;

import java.io.Serializable;

/**
 * Created by DiegoMancini on 17/5/17.
 */
public class ListNode<T> implements Serializable{

    T element;
    ListNode<T> before;
    ListNode<T> next;

    public ListNode() {

    }

    public ListNode(T element) {
        this.element = element;
    }

    public ListNode(T element, ListNode<T> before, ListNode<T> next) {
        this.element = element;
        this.before = before;
        this.next = next;
    }
}
