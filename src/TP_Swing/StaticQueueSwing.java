package TP_Swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tomas on 21/6/2017.
 */
public class StaticQueueSwing {
    private JTextPane[] theQueue = new JTextPane[10];
    private int size;
    private int front;
    private int backend;
    private int quantity;
    private int length;
    private int multiplierFactor;

    public StaticQueueSwing(){
        for (int i = 0; i < 10; i++){
            theQueue[i] = new JTextPane();
            theQueue[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            theQueue[i].setFont(new Font("Arial", Font.PLAIN, 20));
            theQueue[i].setBackground(Color.WHITE);
            theQueue[i].setSize(50 , 50);
        }
        length = 10;
        size = 0;
        front = 0;
        backend = front - 1;
        multiplierFactor = 2;
    }

    public JTextPane[] getTheQueue() {
        return theQueue;
    }

    public boolean isFull() {
        if (size  == length) {
            return true;
        } else
            return false;
    }

    public int enqueue(int number){
        if (size == theQueue.length) {
            growQueue();
        } else {
            backend = increment(backend);
            theQueue[backend].setText("" + number);
            size++;
            quantity++;
            theQueue[backend].setBackground(Color.CYAN);
        }
        return number;
    }

    public String dequeue(){
        if (isEmpty()) {
            throw new RuntimeException("Array is empty");
        }
        size--;
        String returnValue = theQueue[front].getText();
        theQueue[front].setText("");
        theQueue[front].setBackground(Color.RED);
        front = increment(front);
        quantity--;
        return returnValue;
    }

    private int increment(int size) {
        if (++size == theQueue.length) {
            size = 0;
        } return size;
    }

    public void empty(){
        for (int i = 0; i < theQueue.length; i++) {
            theQueue[i].setText("");
            theQueue[i].setBackground(Color.WHITE);
        }
        size = 0;
        front = 0;
        backend = front-1;
        quantity = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void setMultiplierFactor(int multiplierFactor) {
        this.multiplierFactor = multiplierFactor;
    }

    public void growQueue() {
        JTextPane[] newArray = new JTextPane[theQueue.length * multiplierFactor];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = new JTextPane();
            newArray[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            newArray[i].setFont(new Font("Arial", Font.PLAIN, 20));
            newArray[i].setBackground(Color.WHITE);
            newArray[i].setSize(50 , 50);
        }
        for (int i = 0; i < size; i++ ) {
            front = increment(front);
            newArray[i].setText(theQueue[front].getText());
        }
        length = newArray.length;
        theQueue = newArray;
        front = 0;
        backend = size-1;
    }

    public int getSize() {
        return size;
    }

    public int getLength() {
        return length;
    }

    public int getFront() {
        return front;
    }

    public int getBackend() {
        return backend;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMultiplierFactor() {
        return multiplierFactor;
    }
}
