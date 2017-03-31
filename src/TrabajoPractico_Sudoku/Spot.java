package TrabajoPractico_Sudoku;

/**
 * Created by Tomas on 30/3/2017.
 */
public class Spot {
    private int value;
    private boolean isOccupied;

    public Spot(){
        value = 0;
        isOccupied = false;
    }

    public int getValue() {
        return value;
    }
    public boolean isOccupied() {
        return isOccupied;
    }

    public void setValue(int aValue) {
        this.value = aValue;
        if (aValue == 0)
            setOccupied(false);
        setOccupied(true);
    }

    private void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
