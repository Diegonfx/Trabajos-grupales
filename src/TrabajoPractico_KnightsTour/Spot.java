package TrabajoPractico_KnightsTour;

/**
 * Created by DiegoMancini on 30/3/17.
 */
public class Spot {

    private int positionInRow;
    private int positionInColumn;
    private String name;
    private int value;

    public Spot() {
        positionInRow = 0;
        positionInColumn = 0;
        name = addName(positionInRow, positionInColumn);
        value = -1;
    }

    public Spot(int row, int column) {
        this.positionInRow = row;
        this.positionInColumn = column;
        name = addName(row , column);
        value = -1;
    }

    public int getPositionInRow() {
        return positionInRow;
    }
    public int getPositionInColumn() {
        return positionInColumn;
    }
   public String getName() {
        return name;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    private final String addName(int row , int column) {
        String name = "";
        if (row == 0 && column == 0) {
            name = "A1";
        } else if (row == 0 && column == 1) {
            name = "A2";
        } else if (row == 0 && column == 2) {
            name = "A3";
        } else if (row == 0 && column == 3) {
            name = "A4";
        } else if (row == 0 && column == 4) {
            name = "A5";
        } else if (row == 0 && column == 5) {
            name = "A6";
        } else if (row == 0 && column == 6) {
            name = "A7";
        } else if (row == 0 && column == 7) {
            name = "A8";
        } else if (row == 1 && column == 0) {
            name = "B1";
        } else if (row == 1 && column == 1) {
            name = "B2";
        } else if (row == 1 && column == 2) {
            name = "B3";
        } else if (row == 1 && column == 3) {
            name = "B4";
        } else if (row == 1 && column == 4) {
            name = "B5";
        } else if (row == 1 && column == 5) {
            name = "B6";
        } else if (row == 1 && column == 6) {
            name = "B7";
        } else if (row == 1 && column == 7) {
            name = "B8";
        } else if (row == 2 && column == 0) {
            name = "C1";
        } else if (row == 2 && column == 1) {
            name = "C2";
        } else if (row == 2 && column == 2) {
            name = "C3";
        } else if (row == 2 && column == 3) {
            name = "C4";
        } else if (row == 2 && column == 4) {
            name = "C5";
        } else if (row == 2 && column == 5) {
            name = "C6";
        } else if (row == 2 && column == 6) {
            name = "C7";
        } else if (row == 2 && column == 7) {
            name = "C8";
        } else if (row == 3 && column == 0) {
            name = "D1";
        } else if (row == 3 && column == 1) {
            name = "D2";
        } else if (row == 3 && column == 2) {
            name = "D3";
        } else if (row == 3 && column == 3) {
            name = "D4";
        } else if (row == 3 && column == 4) {
            name = "D5";
        } else if (row == 3 && column == 5) {
            name = "D6";
        } else if (row == 3 && column == 6) {
            name = "D7";
        } else if (row == 3 && column == 7) {
            name = "D8";
        } else if (row == 4 && column == 0) {
            name = "E1";
        } else if (row == 4 && column == 1) {
            name = "E2";
        } else if (row == 4 && column == 2) {
            name = "E3";
        } else if (row == 4 && column == 3) {
            name = "E4";
        } else if (row == 4 && column == 4) {
            name = "E5";
        } else if (row == 4 && column == 5) {
            name = "E6";
        } else if (row == 4 && column == 6) {
            name = "E7";
        } else if (row == 4 && column == 7) {
            name = "E8";
        } else if (row == 5 && column == 0) {
            name = "F1";
        } else if (row == 5 && column == 1) {
            name = "F2";
        } else if (row == 5 && column == 2) {
            name = "F3";
        } else if (row == 5 && column == 3) {
            name = "F4";
        } else if (row == 5 && column == 4) {
            name = "F5";
        } else if (row == 5 && column == 5) {
            name = "F6";
        } else if (row == 5 && column == 6) {
            name = "F7";
        } else if (row == 5 && column == 7) {
            name = "F8";
        } else if (row == 6 && column == 0) {
            name = "G1";
        } else if (row == 6 && column == 1) {
            name = "G2";
        } else if (row == 6 && column == 2) {
            name = "G3";
        } else if (row == 6 && column == 3) {
            name = "G4";
        } else if (row == 6 && column == 4) {
            name = "G5";
        } else if (row == 6 && column == 5) {
            name = "G6";
        } else if (row == 6 && column == 6) {
            name = "G7";
        } else if (row == 6 && column == 7) {
            name = "G8";
        } else if (row == 7 && column == 0) {
            name = "H1";
        } else if (row == 7 && column == 1) {
            name = "H2";
        } else if (row == 7 && column == 2) {
            name = "H3";
        } else if (row == 7 && column == 3) {
            name = "H4";
        } else if (row == 7 && column == 4) {
            name = "H5";
        } else if (row == 7 && column == 5) {
            name = "H6";
        } else if (row == 7 && column == 6) {
            name = "H7";
        } else if (row == 7 && column == 7) {
            name = "H8";
        } return name;
    }
    public void setPositionInRow(int positionInRow) {
        this.positionInRow = positionInRow;
    }
    public void setPositionInColumn(int positionInColumn) {
        this.positionInColumn = positionInColumn;
    }
}
