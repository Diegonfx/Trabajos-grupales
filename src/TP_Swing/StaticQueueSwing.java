package TP_Swing;

import javax.swing.*;
import java.awt.*;

/**
 * Implementation of a static queue adapted for swing.
 * @author Tomas Iturralde
 * @author Diego Mancini
 */
public class StaticQueueSwing {
    private JTextPane[] theQueue;
    private int size;
    private int front;
    private int backend;
    private int quantity;
    private int length;


    public StaticQueueSwing(){
        length = 10;
        theQueue = new JTextPane[10];
        for (int i = 0; i < 10; i++){
            theQueue[i] = new JTextPane();
            theQueue[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            theQueue[i].setFont(new Font("Arial", Font.PLAIN, 20));
            theQueue[i].setBackground(Color.WHITE);
            theQueue[i].setSize(100 , 100);
        }

        size = 0;
        front = 0;
        backend = front - 1;
    }

    public JTextPane[] getTheQueue() {
        return theQueue;
    }

    public boolean isFull() {
        return size == length;
    }

    public int enqueue(int number){
        backend = increment(backend);
        theQueue[backend].setText("" + number);
        size++;
        quantity++;
        return number;
    }

    public String dequeue(){
        if (isEmpty()) {
            throw new RuntimeException("Array is empty");
        }
        size--;
        String returnValue = theQueue[front].getText();
        theQueue[front].setText("");
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

    public void growQueue() {
            JTextPane[] newArray = new JTextPane[theQueue.length + 5];
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = new JTextPane();
                newArray[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                newArray[i].setFont(new Font("Arial", Font.PLAIN, 20));
                newArray[i].setBackground(Color.WHITE);
                newArray[i].setSize(100, 100);

            }
            for (int i = 0; i < size; i++) {

                newArray[i].setText(theQueue[front].getText());
                front = increment(front);
            }
        length = newArray.length;
        theQueue = newArray;
        front = 0;
        backend = size - 1;
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
}
