package TrabajoPractico4_Queue.BankSim;

import TrabajoPractico4_Queue.DynamicQueue;

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

    }
}
