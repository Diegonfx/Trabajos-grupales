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

    }

}
