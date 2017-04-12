package TrabajoPractico4_Queue.BankSim;

import TrabajoPractico4_Queue.DynamicQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by DiegoMancini on 7/4/17.
 */
public class BankRTC {

    // Internal Collaborators
    private List<Cashier> cashiersList;
    private List<Client> listOfClients;
    private DynamicQueue<Client> entranceQueue;
    private List<DynamicQueue<Client>> listOfQueues;
    private int openingTime;
    private int closingTime;
    private int currentTime;
    private boolean cashiersAreFree;
    private String name;
    private int clientNumber = 0;
    private boolean bankIsOpen;
    private Strategy usedStrategy;

    //CONSTRUCTOR
    public BankRTC(Strategy usedStrategy) {
        name = "RTC BANK ENTERPRISE";
        cashiersList = new ArrayList<>(3);
        cashiersList.add(new Cashier("Cashier number 1 ONE" , 30 , 90  , this));
        cashiersList.add(new Cashier("Cashier number 2 TWO" , 30 , 120 , this));
        cashiersList.add(new Cashier("Cashier number 3 THREE" , 30 , 150 , this));
        listOfClients = new ArrayList<>();
        entranceQueue = new DynamicQueue<>();
        listOfQueues = new ArrayList<>();
        DynamicQueue<Client> queueForCashierONE = new DynamicQueue<>();
        DynamicQueue<Client> queueForCashierTWO = new DynamicQueue<>();
        DynamicQueue<Client> queueForCashierTHREE = new DynamicQueue<>();
        listOfQueues.add(queueForCashierONE);
        listOfQueues.add(queueForCashierTWO);
        listOfQueues.add(queueForCashierTHREE);
        openingTime = 0;
        currentTime = 0;
        closingTime = 18000;
        bankIsOpen = false;
        this.usedStrategy = usedStrategy;
    }

    private DynamicQueue<Client> getShortestQueue() throws NullPointerException {
        DynamicQueue<Client> result = new DynamicQueue<>();
        try {
            if (listOfQueues.get(0).getSize() == listOfQueues.get(1).getSize() && listOfQueues.get(0).getSize() == listOfQueues.get(2).getSize() ) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 2 + 1);
                result = listOfQueues.get(randomNum);
            } else if (listOfQueues.get(0).getSize() < listOfQueues.get(1).getSize() && listOfQueues.get(1).getSize() < listOfQueues.get(2).getSize()) {
                result = listOfQueues.get(0);
            } else if (listOfQueues.get(0).getSize() > listOfQueues.get(1).getSize() && listOfQueues.get(1).getSize() > listOfQueues.get(2).getSize()) {
                result = listOfQueues.get(2);
            } else {
                result = listOfQueues.get(1);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } return result;
    }
    public void clientEnters() {
        int randomNumberOfClients = ThreadLocalRandom.current().nextInt(5 , 10);
        Client[] clientsEntering = new Client[randomNumberOfClients];
        if (randomNumberOfClients == 0) {
            System.out.println("NO CLIENTS HAVE ENTERED");
        }
        for (int i = 0 ; i < clientsEntering.length ; i++) {
            clientsEntering[i] = new Client("Client number: " + ++clientNumber);
            clientsEntering[i].setEnterTime(currentTime);
            listOfClients.add(clientsEntering[i]);
            entranceQueue.enqueue(clientsEntering[i]);
        }
    }
    public void distributeClients() {
            DynamicQueue<Client> queueToAssignClient = getShortestQueue();
            queueToAssignClient.enqueue(entranceQueue.dequeue());
    }
    public void clientLeaves(Client anyClient) {
        anyClient.setExitTime(currentTime);
        entranceQueue.dequeue();
    }
    public void opens() {
        bankIsOpen = true;
        clientEnters();
    }
    public void closes() {
        bankIsOpen = false;
    }
    public void operate() {
        if (usedStrategy.isUsingStrategyA()) {
            usedStrategy.useStrategy(this , entranceQueue);
        } else if (usedStrategy.isUsingStrategyB()) {
            usedStrategy.useStrategy(this , entranceQueue);
        }
    }
    public void cashiersFullWaiting() {

        if (!cashiersAreFree) {
            int minCashier1 = cashiersList.get(0).getMinimumTime();
            int maxCashier1 = cashiersList.get(0).getMaximumTime();
            int minCashier2 = cashiersList.get(1).getMinimumTime();
            int maxCashier2 = cashiersList.get(1).getMaximumTime();
            int minCashier3 = cashiersList.get(1).getMinimumTime();
            int maxCashier3 = cashiersList.get(1).getMaximumTime();
            while (minCashier1 <= maxCashier1) {
                minCashier1++;
                if (minCashier1 == maxCashier3) {
                    cashiersList.get(0).finishWithClient();
                }
            }
            while (minCashier2 <= maxCashier2) {
                minCashier2++;
                if (minCashier2 == maxCashier2) {
                    cashiersList.get(1).finishWithClient();
                }
            }
            while (minCashier3 <= maxCashier3) {
                minCashier3++;
                if (minCashier3 == maxCashier3) {
                    cashiersList.get(2).finishWithClient();
                }
            }
        }
    }
    //GETTERS AND SETTERS METHODS
    public List<Cashier> getCashiersList() {
        return cashiersList;
    }
    public List<Client> getListOfClients() {
        return listOfClients;
    }
    public DynamicQueue<Client> getEntranceQueue() {
        return entranceQueue;
    }
    public List<DynamicQueue<Client>> getListOfQueues() {
        return listOfQueues;
    }
    public int getOpeningTime() {
        return openingTime;
    }
    public int getClosingTime() {
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
    public int getCurrentTime() {
        return currentTime;
    }
    private void timePasses() {
        currentTime += 0.00000001;
        if (currentTime == 15.0) {
            System.out.println("BANK IS CLOSED");
            bankIsOpen = false;
        }
    }
    public boolean isOpen() {
        return bankIsOpen;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    public Strategy getUsedStrategy() {
        return usedStrategy;
    }
    public void setUsedStrategy(Strategy usedStrategy) {
        this.usedStrategy = usedStrategy;
    }
    public void setBankIsOpen(boolean bankIsOpen) {
        this.bankIsOpen = bankIsOpen;
    }
}
