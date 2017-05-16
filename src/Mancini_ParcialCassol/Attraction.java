package Mancini_ParcialCassol;


import Mancini_ParcialCassol.Colas.DynamicQueue;
import Mancini_ParcialCassol.Colas.StaticQueue;
import Mancini_ParcialCassol.Stacks.StaticStack.StaticStack;

/**
 * @author Diego Mancini
 */
public class Attraction implements Comparable<Attraction> {

    private final String name;
    private final int capacity;
    private DynamicQueue<Client> regularLane;
    private StaticQueue<Client> fastPassLane;
    private StaticStack<Client> clientsUsingAttraction;
    private double timeInQueue;

    public Attraction(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        regularLane = new DynamicQueue<>();
        fastPassLane = new StaticQueue<>(20);
        clientsUsingAttraction = new StaticStack<>(capacity);
        timeInQueue = 0;
    }

    /**
     * Performs the action where the attraction gets used by the clients in the queues.
     */
    public void operate(ThemePark themePark) {
        int peopleUsing = 0;
        if (peopleUsing < capacity) {
            for (int i = 0 ; i < fastPassLane.getSize() ; i++) {
                fastPassLane.getFront().setExitTime(themePark.getCurrentTime());
                timeInQueue += fastPassLane.getFront().getExitTime() - fastPassLane.getFront().getTimeInRegularQueue();
                clientsUsingAttraction.push(fastPassLane.dequeue());
                peopleUsing++;
            } for (int i = 0; i < regularLane.getSize() ; i++ ) {
                regularLane.getFront().setExitTime(themePark.getCurrentTime());
                timeInQueue += regularLane.getFront().getExitTime() - regularLane.getFront().getTimeInRegularQueue();
                clientsUsingAttraction.push(regularLane.dequeue());
                peopleUsing++;
            }
            if (peopleUsing < capacity && fastPassLane.isEmpty() && regularLane.isEmpty()) {
                return;
            }
        }
    }

    /**
     * Performs the action where the clients leave the attraction and return to the hub.
     */
    public void returnToHub(ThemePark southerlands) {
        for (int i = 0 ; i < clientsUsingAttraction.size() ; i++) {
            southerlands.hub().insertNext(clientsUsingAttraction.peek());
            clientsUsingAttraction.pop();
        }
    }

    /**
     * Performs the action where the attraction gets its popularity defined.
     */
    public int getPopularity() {
        int popularity = 10;
        if (regularLane.getSize() == 0) {
            popularity = 10;
        }
        else if (regularLane.getSize() >= 80) {
            popularity = 1;
        } else if (regularLane.getSize() >= 70 && regularLane.getSize() <= 79) {
            popularity = 2;
        }  else if (regularLane.getSize() >= 60  && regularLane.getSize() <= 69) {
            popularity = 3;
        }  else if (regularLane.getSize() >= 50 && regularLane.getSize() <= 59) {
            popularity = 4;
        }  else if (regularLane.getSize() >= 40 && regularLane.getSize() <= 49) {
            popularity = 5;
        }  else if (regularLane.getSize() >= 30 && regularLane.getSize() <= 39) {
            popularity = 6;
        }  else if (regularLane.getSize() >= 20 && regularLane.getSize() <= 29) {
            popularity = 7;
        }  else if (regularLane.getSize() >= 10 && regularLane.getSize() <= 19) {
            popularity = 8;
        }  else if (regularLane.getSize() >= 1 && regularLane.getSize() <= 9) {
            popularity = 9;
        }
        return popularity;
    }

    //              GETTERS AND SETTERS
    public String getName() {
        return name;
    }
    public int getCapacity() {
        return capacity;
    }
    public DynamicQueue<Client> getRegularLane() {
        return regularLane;
    }
    public StaticQueue<Client> getFastPassLane() {
        return fastPassLane;
    }
    public StaticStack<Client> getClientsUsingAttraction() {
        return clientsUsingAttraction;
    }

    public double getTimeInQueue() {
        return timeInQueue;
    }

    @Override
    public int compareTo(Attraction o) {
        if (this.getPopularity() > o.getPopularity()) {
            return 1;
        } else if (this.getPopularity() < o.getPopularity()) {
            return -1;
        } else {
            return 0;
        }
    }
}
