package TP_SortedList.TP_06;

import java.io.Serializable;

/**
 * Implementation of a bus.
 * @author Tomas Iturralde
 * @author Diego Mancini
 */
public class Bus implements Comparable<Bus>, Serializable{
    private int lineNumber;
    private int internNumber;
    private int seats;
    private boolean allowsDisabled;

    public Bus(int lineNumber, int internNumber, int seats, boolean allowsDisabled) {
        this.lineNumber = lineNumber;
        this.internNumber = internNumber;
        this.seats = seats;
        this.allowsDisabled = allowsDisabled;
    }

    public int getLineNumber() {
        return lineNumber;
    }
    public int getInternNumber() {
        return internNumber;
    }
    public int getSeats() {
        return seats;
    }
    public boolean isAllowsDisabled() {
        return allowsDisabled;
    }
    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
    public void setInternNumber(int internNumber) {
        this.internNumber = internNumber;
    }
    public void setAllowsDisabled(boolean allowsDisabled) {
        this.allowsDisabled = allowsDisabled;
    }

    @Override
    public int compareTo(Bus o) {
        if (lineNumber < o.getLineNumber())
            return -1;
        else if (lineNumber > o.getLineNumber())
            return 1;
        else{
            if (internNumber < o.getInternNumber())
                return -1;
            else if (internNumber > o.getInternNumber())
                return 1;
            return 0;
        }
    }
}
