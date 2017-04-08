package TrabajoPractico4_Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by DiegoMancini on 7/4/17.
 */
public class BankRTC {

    private List<Cashier> cashiersList;
    private List<Client> listOfClients;
    private DynamicQueue<Client> firstSimulation;
    private List<DynamicQueue<Client>> secondSimulation;
    private double openingTime;
    private double closingTime;
    private double currentTime;
    private boolean cashiersAreFree;
    private String name;

    public BankRTC() {
        name = "RTC BANK ENTERPRISE";
        cashiersList = new ArrayList<>(3);
        cashiersList.add(new Cashier("Cashier number 1 ONE" , 0.5 , 1.5  , this));
        cashiersList.add(new Cashier("Cashier number 2 TWO" , 0.5 , 2 , this));
        cashiersList.add(new Cashier("Cashier number 3 THREE" , 0.5 , 2.5 , this));
        listOfClients = new ArrayList<>();
        firstSimulation = new DynamicQueue<>();
        secondSimulation = new ArrayList<>();
        DynamicQueue<Client> queueForCashierONE = new DynamicQueue<>();
        DynamicQueue<Client> queueForCashierTWO = new DynamicQueue<>();
        DynamicQueue<Client> queueForCashierTHREE = new DynamicQueue<>();
        secondSimulation.add(queueForCashierONE);
        secondSimulation.add(queueForCashierTWO);
        secondSimulation.add(queueForCashierTHREE);
        openingTime = 10.00;
        currentTime = 10.00;
        closingTime = 15.00;
        timePasses();
    }

    public DynamicQueue<Client> getShortestQueue() throws NullPointerException {
        DynamicQueue<Client> result = new DynamicQueue<>();
        try {
            for (int i = 0; i < secondSimulation.size(); i++) {
                if (secondSimulation.get(i).isEmpty()) {
                    result = secondSimulation.get(i);
                } else if (secondSimulation.get(i).getSize() < secondSimulation.get(i + 1).getSize()) {
                    result = secondSimulation.get(i);
                } else if (secondSimulation.get(i + 1).getSize() > secondSimulation.get(i).getSize()) {
                    result = secondSimulation.get(i + 1);
                } else if (secondSimulation.get(i).getSize() == secondSimulation.get(i+1).getSize()) {
                    result = secondSimulation.get(i);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } return result;
    }

    public void clientEnters(Client anyClient) {
        anyClient.setEnterTime(currentTime);
        listOfClients.add(anyClient);
        firstSimulation.enqueue(anyClient);
    }

    public void clientLeaves(Client anyClient) {
        anyClient.setExitTime(currentTime);
    }

    public void simulationOne() {
        clientEnters(firstSimulation.getFront());
        if (cashiersAreFree) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 2 + 1);
            cashiersList.get(randomNum).attendClient(firstSimulation.getFront());
            firstSimulation.dequeue();
        } else {
            for (int i = 0; i < cashiersList.size(); i++) {
                if (!cashiersList.get(i).isAttending()) {
                    cashiersList.get(i).attendClient(firstSimulation.getFront());
                    firstSimulation.dequeue();
                } else {
                    return;
                }
            }
        }
    }

    public void simulationTwo() {

    }

    private void timePasses() {
        while (currentTime <= closingTime) {
            currentTime += 0.0000000000001;
        }
    }
    public List<Cashier> getCashiersList() {
        return cashiersList;
    }
    public List<Client> getListOfClients() {
        return listOfClients;
    }
    public DynamicQueue<Client> getFirstSimulation() {
        return firstSimulation;
    }
    public List<DynamicQueue<Client>> getSecondSimulation() {
        return secondSimulation;
    }
    public double getOpeningTime() {
        return openingTime;
    }
    public double getClosingTime() {
        return closingTime;
    }
    public boolean getCashiersAreFree() {
        for (int i = 0 ; i < cashiersList.size() ; i++) {
            if (cashiersList.get(i).isAttending() == false) {
                return true;
            }
        } return false;
    }
    public String getName() {
        return name;
    }
    public void setCashiersAreFree(boolean cashiersAreFree) {
        this.cashiersAreFree = cashiersAreFree;
    }
    public double getCurrentTime() {
        return currentTime;
    }
    private double doubleRandomInclusive(double max, double min) {
        double r = Math.random();
        if (r < 0.5) {
            return ((1 - Math.random()) * (max - min) + min);
        }
        return (Math.random() * (max - min) + min);
    }
}
