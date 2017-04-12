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
        int timeSinceLastClient = 0;
        int timeAfterClose = 0;

        bankRTC_SimulationA.opens();
        bankRTC_SimulationA.clientEnters();
        bankRTC_SimulationA.clientEnters();
        bankRTC_SimulationA.clientEnters();
        for (int i = 0 ; i <= 18000 ; i++) {
            bankRTC_SimulationA.setCurrentTime(++currentTime_A);
            timeSinceLastClient++;
            if (timeSinceLastClient == 90) {
                bankRTC_SimulationA.clientEnters();
                timeSinceLastClient = 0;
            }
                bankRTC_SimulationA.operate();
                if (currentTime_A == 18000) {
                    bankRTC_SimulationA.closes();
                }
            if (!bankRTC_SimulationA.isOpen() && !bankRTC_SimulationA.getEntranceQueue().isEmpty()) {
                while (!bankRTC_SimulationA.getEntranceQueue().isEmpty()) {
                    timeAfterClose++;
                bankRTC_SimulationA.operate();
                }
            }
        }

//        bankRTC_SimulationB.opens();
//        bankRTC_SimulationB.clientEnters();
//        bankRTC_SimulationB.clientEnters();
//        bankRTC_SimulationB.clientEnters();
//        for (int i = 0 ; i <= 18000 ; i++) {
//            ++currentTime_B;
//            timeSinceLastClient++;
//            if (timeSinceLastClient == 90) {
//                bankRTC_SimulationB.clientEnters();
//                timeSinceLastClient = 0;
//            }
//                bankRTC_SimulationB.operate();
//                if (currentTime_B == 18000) {
//                    bankRTC_SimulationB.closes();
//                }
//            if (!bankRTC_SimulationB.isOpen() && !bankRTC_SimulationB.getEntranceQueue().isEmpty()) {
//                while (!bankRTC_SimulationB.getListOfQueues().isEmpty() && !bankRTC_SimulationB.getEntranceQueue().isEmpty()) {
//                    timeAfterClose++;
//                    bankRTC_SimulationB.operate();
//                }
//            }
//        }

        for (int i = 0; i < bankRTC_SimulationA.getListOfClients().size(); i++) {
            System.out.println(" Name of client: " + bankRTC_SimulationA.getListOfClients().get(i).getName() +
                    "\n Time it was attended: " + bankRTC_SimulationA.getListOfClients().get(i).getAttendedTime() +
                    "\n Time it entered the bank: " + bankRTC_SimulationA.getListOfClients().get(i).getEnterTime() +
                    "\n Time it left the bank: " + bankRTC_SimulationA.getListOfClients().get(i).getExitTime() +
                    "\n Time it spent with cashier: " + bankRTC_SimulationA.getListOfClients().get(i).getTimeWithCashier());
        }

    }




}
