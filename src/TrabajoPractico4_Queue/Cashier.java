package TrabajoPractico4_Queue;

/**
 * Created by DiegoMancini on 7/4/17.
 */
public class Cashier {

    private String name;
    private double attendingTime;
    private boolean isAttending;
    private double minimumTime;
    private double maximumTime;
    private BankRTC rtc;

    public Cashier(String name, double minimumTime, double maximumTime , BankRTC rtc) {
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
        attendingTime = doubleRandomInclusive(getMaximumTime() , getMinimumTime());
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
    public double getAttendingTime() {
        return attendingTime;
    }
    public boolean isAttending() {
        return isAttending;
    }
    public double getMinimumTime() {
        return minimumTime;
    }
    public double getMaximumTime() {
        return maximumTime;
    }
    public void setAttendingTime(double attendingTime) {
        this.attendingTime = attendingTime;
    }
    public void setAttending(boolean attending) {
        isAttending = attending;
    }
    private double doubleRandomInclusive(double max, double min) {
        double r = Math.random();
        if (r < 0.5) {
            return ((1 - Math.random()) * (max - min) + min);
        }
        return (Math.random() * (max - min) + min);
    }
}
