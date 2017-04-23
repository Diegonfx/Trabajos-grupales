package TP_Lists.TP_Metrovias_Iturralde;

import TrabajoPractico4_Queue.DynamicQueue;
import java.util.Random;

/**
 * Implementation of a window on a train station.
 * @author Tomas Iturralde
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

    /**
     * Probability of a window serving a customer.
     * 30% the customer will be served, 70% it won't.
     * @return true if the customer will be served, false if otherwise.
     */
    private boolean willServeCustomer(){
        Random random = new Random();
        float probability = random.nextFloat();
        return probability > 0 && probability <= 0.3;
    }

    /**
     * Method which based on the porbability of serving will serve the first customer on line.
     * @param currentTime of the day when the customer will be served.
     */
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

    /**
     * During the last 30 secs. every customer will be served no matter what.
     * @param currentTime of the day when the customer will be served.
     */
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

    /**
     * @return Average waiting time on line
     */
    public int averageTime(){
        return (clientTotalTime/clientsServed);
    }
}
