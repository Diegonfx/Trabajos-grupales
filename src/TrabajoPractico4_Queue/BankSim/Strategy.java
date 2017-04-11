package TrabajoPractico4_Queue.BankSim;

import TrabajoPractico4_Queue.DynamicQueue;

/**
 * Created by DiegoMancini on 11/4/17.
 */
public interface Strategy {

    void goStrategyA(BankRTC aBank);

    void gostrategyB(BankRTC aBank);

    boolean isUsingStrategyA();

    boolean isUsingStrategyB();

    void useStrategy(BankRTC bankRTC , DynamicQueue<Client> clientsQueue);
}
