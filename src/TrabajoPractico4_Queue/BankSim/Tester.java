package TrabajoPractico4_Queue.BankSim;

/**
 * Created by DiegoMancini on 11/4/17.
 */
public class Tester {
    public static void main(String[] args) {
        BankRTC bankRTC_SimulationA = new BankRTC(new StrategyA());
        BankRTC bankRTC_SimulationB = new BankRTC(new StrategyB());
        int currentTime_A = bankRTC_SimulationA.getCurrentTime();
        int currentTime_B = bankRTC_SimulationB.getCurrentTime();

        for (int i = 0 ; i < 18000 ; i++) {
            ++currentTime_A;

            while (bankRTC_SimulationA.isBankIsOpen()) {

            }
            if (!bankRTC_SimulationA.isBankIsOpen() && !bankRTC_SimulationA.getEntranceQueue().isEmpty()) {

            } else {

            }
        }
        for (currentTime_B = 0 ; currentTime_B < 18000 ; currentTime_B++) {

            while (bankRTC_SimulationB.isBankIsOpen()) {

            }
            if (!bankRTC_SimulationB.isBankIsOpen() && !bankRTC_SimulationB.getEntranceQueue().isEmpty()) {

            } else {

            }
        }
    }


}
