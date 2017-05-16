package Mancini_ParcialCassol;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Diego Mancini
 * The client owns a ticket which will be either a FastPass Ticket or a Regular Ticket, defined by probability
 */
public class Client {

    private String name;
    private Ticket ticket;
    private int timeInRegularQueue;
    private int timeLeftQueue;
    private int timeWaited;

    public Client(String name) {
        this.name = name;
        int prob = ThreadLocalRandom.current().nextInt(1 , 10);
        if (prob <= 3) {
            ticket = new FastPassTicket();
        } else {
            ticket = new RegularTicket();
        }
        timeInRegularQueue = 0;
    }

    public String getName() {
        return name;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public int getTimeInRegularQueue() {
        return timeInRegularQueue;
    }

    public int getExitTime() {
        return timeLeftQueue;
    }

    public void setTimeInRegularQueue(int time) {
        timeInRegularQueue += time;
    }

    public void setExitTime(int exitTime) {
        this.timeLeftQueue = exitTime;
    }

    public int getTimeWaited() {
        timeWaited = getExitTime() - getTimeInRegularQueue();
        return timeWaited;
    }
}
