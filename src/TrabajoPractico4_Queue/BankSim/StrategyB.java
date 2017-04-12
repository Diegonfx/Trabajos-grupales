package TrabajoPractico4_Queue.BankSim;

import TrabajoPractico4_Queue.DynamicQueue;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by DiegoMancini on 11/4/17.
 */
public class StrategyB implements Strategy {

    @Override
    public void goStrategyA(BankRTC aBank) {
        aBank.setUsedStrategy(new StrategyA());
    }

    @Override
    public void gostrategyB(BankRTC aBank) {
        throw new RuntimeException("ALREADY USING STRATEGY B");
    }

    @Override
    public boolean isUsingStrategyA() {
        return false;
    }

    @Override
    public boolean isUsingStrategyB() {
        return true;
    }

    @Override
    public void useStrategy(BankRTC bankRTC, DynamicQueue<Client> clientsQueue) {
        while (!clientsQueue.isEmpty()) {

            if (!bankRTC.getCashiersAreFree()) {
                bankRTC.cashiersFullWaiting();
            }
            if (bankRTC.getCashiersAreFree()) {
                for (int i = 0 ; i < 10 ; i++) {
                    bankRTC.distributeClients();
                }
                int random = ThreadLocalRandom.current().nextInt(0 , 3) ;
                bankRTC.getCashiersList().get(random).attendClient(bankRTC.getListOfQueues().get(random).getFront());
                bankRTC.getCashiersList().get(random).setAttending(true);
                int timeWithCashier = bankRTC.getCashiersList().get(random).getAttendingTime();
                if (bankRTC.getListOfQueues().get(random).getFront().getEnterTime()-bankRTC.getListOfQueues().get(random).getFront().getTimeWithCashier() < 0) {
                    bankRTC.getListOfQueues().get(random).getFront().setAttendedTime(0);
                }else {
                    bankRTC.getListOfQueues().get(random).getFront().setAttendedTime(bankRTC.getListOfQueues().get(random).getFront().getEnterTime()-bankRTC.getListOfQueues().get(random).getFront().getTimeWithCashier());
                }                bankRTC.getListOfQueues().get(random).getFront().setTimeWithCashier(timeWithCashier);
                bankRTC.clientLeaves(bankRTC.getListOfQueues().get(random).getFront());
            } else
                for (int i = 0 ; i < bankRTC.getCashiersList().size() ; i++) {
                    if (!bankRTC.getCashiersList().get(i).isAttending()) {
                        for (int j = 0 ; j < 10 ; j++) {
                            bankRTC.distributeClients();
                        }
                        bankRTC.getCashiersList().get(i).attendClient(bankRTC.getListOfQueues().get(i).getFront());
                        bankRTC.getCashiersList().get(i).setAttending(true);
                        int timeWithCashier = bankRTC.getCashiersList().get(i).getAttendingTime();
                        if (bankRTC.getListOfQueues().get(i).getFront().getEnterTime()-bankRTC.getListOfQueues().get(i).getFront().getTimeWithCashier() < 0) {
                            bankRTC.getListOfQueues().get(i).getFront().setAttendedTime(0);
                        }else {
                            bankRTC.getListOfQueues().get(i).getFront().setAttendedTime(bankRTC.getListOfQueues().get(i).getFront().getEnterTime()-bankRTC.getListOfQueues().get(i).getFront().getTimeWithCashier());
                        }
                        bankRTC.getListOfQueues().get(i).getFront().setTimeWithCashier(timeWithCashier);
                        bankRTC.clientLeaves(bankRTC.getListOfQueues().get(i).getFront());
                    }
                }
        }
    }
}
