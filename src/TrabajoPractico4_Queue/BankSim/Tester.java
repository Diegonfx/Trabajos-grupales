package TrabajoPractico4_Queue.BankSim;

/**
 * Created by DiegoMancini on 11/4/17.
 */
public class Tester {
    public static void main(String[] args) {
        BankRTC bankRTC_SimulationA = new BankRTC(new StrategyA());
        BankRTC bankRTC_SimulationB = new BankRTC(new StrategyB());
        for (int i = 1 ; i < 18000 ; i++) {

            while (bankRTC_SimulationA.isBankIsOpen()) {

            }
            if (!bankRTC_SimulationA.isBankIsOpen() && !bankRTC_SimulationA.getEntranceQueue().isEmpty()) {

            } else {

            }
        }
    }


}
