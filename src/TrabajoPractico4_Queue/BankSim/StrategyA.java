package TrabajoPractico4_Queue.BankSim;

import TrabajoPractico4_Queue.DynamicQueue;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by DiegoMancini on 11/4/17.
 */
public class StrategyA implements Strategy {

    @Override
    public void goStrategyA(BankRTC aBank) {
        throw new RuntimeException("ALREADY USING STRATEGY A");
    }

    @Override
    public void gostrategyB(BankRTC aBank) {
        aBank.setUsedStrategy(new StrategyB());
    }

    @Override
    public boolean isUsingStrategyA() {
        return true;
    }

    @Override
    public boolean isUsingStrategyB() {
        return false;
    }

    @Override
    public void useStrategy(BankRTC bankRTC, DynamicQueue<Client> clientsQueue) {
        while (!clientsQueue.isEmpty()) {
            if (!bankRTC.getCashiersAreFree()) {
                bankRTC.cashiersFullWaiting();
            }
            if (bankRTC.getCashiersAreFree()) {
                int random = ThreadLocalRandom.current().nextInt(0 , 3) ;
                bankRTC.getCashiersList().get(random).attendClient(clientsQueue.getFront());
                bankRTC.getCashiersList().get(random).setAttending(true);
                int timeWithCashier = bankRTC.getCashiersList().get(random).getAttendingTime();
                clientsQueue.getFront().setAttendedTime(bankRTC.getCurrentTime());
                clientsQueue.getFront().setTimeWithCashier(timeWithCashier);
            } else
                for (int i = 0 ; i < bankRTC.getCashiersList().size() ; i++) {
                    if (!bankRTC.getCashiersList().get(i).isAttending()) {
                        bankRTC.getCashiersList().get(i).attendClient(clientsQueue.getFront());
                        bankRTC.getCashiersList().get(i).attendClient(clientsQueue.getFront());
                        bankRTC.getCashiersList().get(i).setAttending(true);
                        int timeWithCashier = bankRTC.getCashiersList().get(i).getAttendingTime();
                        clientsQueue.getFront().setAttendedTime(bankRTC.getCurrentTime());
                        clientsQueue.getFront().setTimeWithCashier(timeWithCashier);
                    }
                }
        }
    }

}
