package TrabajoPractico4_Queue.BankSim;

import java.util.concurrent.ThreadLocalRandom;

public class Cashier {

    private String name;
    private int attendingTime;
    private boolean isAttending;
    private int minimumTime;
    private int maximumTime;
    private BankRTC rtc;

    public Cashier(String name, int minimumTime, int maximumTime , BankRTC rtc) {
        this.name = name;
        this.minimumTime = minimumTime;
        this.maximumTime = maximumTime;
        attendingTime = 0;
        isAttending = false;
        this.rtc = rtc;
    }

    public void attendClient(Client anyClient) {
        anyClient.setAttendedTime(rtc.getCurrentTime());
        anyClient.setAttended(true);
        isAttending = true;
        attendingTime = ThreadLocalRandom.current().nextInt(minimumTime , maximumTime);
        anyClient.setTimeWithCashier(attendingTime);
    }

    public void finishWithClient(Client anyClient) {
        anyClient.setExitTime(rtc.getCurrentTime());
        anyClient.setAttended(false);
        isAttending = false;
        attendingTime = 0;
    }


    public BankRTC getRtc() {
        return rtc;
    }
    public String getName() {
        return name;
    }
    public int getAttendingTime() {
        return attendingTime;
    }
    public boolean isAttending() {
        return isAttending;
    }
    public int getMinimumTime() {
        return minimumTime;
    }
    public int getMaximumTime() {
        return maximumTime;
    }
    public void setAttendingTime(int attendingTime) {
        this.attendingTime = attendingTime;
    }
    public void setAttending(boolean attending) {
        isAttending = attending;
    }
}
