package TrabajoPractico4_Queue.BankSim;

/**
 * Created by DiegoMancini on 7/4/17.
 */
public class Client {

    private String name;
    private int enterTime;
    private int exitTime;
    private int attendedTime;
    private int timeWithCashier;
    private boolean isAttended;

    public Client(String name) {
        this.name = name;
        timeWithCashier = 0;
        enterTime = 0;
        exitTime = 0;
        attendedTime = 0;
        isAttended = false;
    }

    public int getTimeWithCashier() {
        return timeWithCashier;
    }
    public void setTimeWithCashier(int timeWithCashier) {
        this.timeWithCashier = timeWithCashier;
    }
    public String getName() {
        return name;
    }
    public int getEnterTime() {
        return enterTime;
    }
    public void setEnterTime(int enterTime) {
        this.enterTime = enterTime;
    }
    public int getExitTime() {
        return exitTime;
    }
    public void setExitTime(int exitTime) {
        this.exitTime = exitTime;
    }
    public int getAttendedTime() {
        return attendedTime;
    }
    public int timeInQueue() { return attendedTime - enterTime;}
    public int timeInBank() { return exitTime - enterTime ; }
    public void setAttendedTime(int timeWithCashier) {
        this.attendedTime = timeWithCashier;
    }
    public boolean isAttended() {
        return isAttended;
    }
    public void setAttended(boolean attended) {
        isAttended = attended;
    }
}
