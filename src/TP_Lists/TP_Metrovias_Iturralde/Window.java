package TP_Lists.TP_Metrovias_Iturralde;

import TrabajoPractico4_Queue.DynamicQueue;

import java.util.Random;

/**
 * Created by Tomas on 19/4/2017.
 */
public class Window {
    private DynamicQueue<Client> line = new DynamicQueue<>();
    private int freeTime;
    private double totalIncome;
    private int clientsServed;
    private int clientTotalTime;


    public Window(){
        line = new DynamicQueue<>();
        freeTime = 0;
        totalIncome = 0;
        clientsServed = 0;
        clientTotalTime = 0;
    }

    public DynamicQueue<Client> getLine() {
        return line;
    }
    public int getFreeTime() {
        return freeTime;
    }
    public float getTotalIncome() {
        return (float)totalIncome;
    }
    public int getClientsServed() {
        return clientsServed;
    }
    public int getClientTotalTime() {
        return clientTotalTime;
    }

    private boolean willServeCustomer(){
        Random random = new Random();
        float probability = random.nextFloat();
        return probability > 0 && probability <= 0.3;
    }

    public void serveCustomers(int currentTime){
        if (!line.isEmpty()) {
            if (willServeCustomer()) {
                clientTotalTime += (currentTime - line.getFront().getInitTime());
                line.dequeue();
                clientsServed++;
                totalIncome += 0.7;
            }
        }
        else
            freeTime += 10;
    }

    public void serveCustomersAtEnd(int currentTime){
        if (!line.isEmpty()) {
            while (!line.isEmpty()){
                clientTotalTime += currentTime - line.getFront().getInitTime();
                line.dequeue();
                clientsServed++;
                totalIncome += 0.7;
            }
        }freeTime += 10;
    }

    public int averageTime(){
        return (clientTotalTime/clientsServed);
    }
}
