package TrabajoPractico4_Queue;

/**
 * Created by DiegoMancini on 7/4/17.
 */
public class Client {

    private String name;
    private double enterTime;
    private double exitTime;
    private double attendedTime;
    private double timeWithCashier;
    private boolean isAttended;

    public Client(String name) {
        this.name = name;
        timeWithCashier = 0;
        enterTime = 0;
        exitTime = 0;
        attendedTime = 0;
        isAttended = false;
    }

    public double getTimeWithCashier() {
        return timeWithCashier;
    }
    public void setTimeWithCashier(double timeWithCashier) {
        this.timeWithCashier = timeWithCashier;
    }
    public String getName() {
        return name;
    }
    public double getEnterTime() {
        return enterTime;
    }
    public void setEnterTime(double enterTime) {
        this.enterTime = enterTime;
    }
    public double getExitTime() {
        return exitTime;
    }
    public void setExitTime(double exitTime) {
        this.exitTime = exitTime;
    }
    public double getAttendedTime() {
        return attendedTime;
    }
    public double timeInQueue() { return attendedTime - enterTime;}
    public double timeInBank() { return exitTime - enterTime ; }
    public void setAttendedTime(double timeWithCashier) {
        this.attendedTime = timeWithCashier;
    }
    public boolean isAttended() {
        return isAttended;
    }
    public void setAttended(boolean attended) {
        isAttended = attended;
    }
}
