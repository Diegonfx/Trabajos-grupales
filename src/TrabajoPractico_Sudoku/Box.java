package TrabajoPractico_Sudoku;

/**
 * Created by Tomas on 30/3/2017.
 */
public class Box {
    private Spot[][] box;

    public Box(){
        box = new Spot[3][3];
    }

    public Spot[][] getBox() {
        return box;
    }

    public void addNumberToSpot(int numberToAdd, int positionInRow, int positionInColumn){
        if (positionInRow > 2 || positionInRow < 0 || positionInColumn > 2 || positionInColumn < 0 || numberToAdd > 9 || numberToAdd < 0)
            throw new RuntimeException("Action not possible.");
        if ( !box[positionInRow][positionInColumn].isOccupied() && checkForAvailability(numberToAdd))
                box[positionInRow][positionInColumn].setValue(numberToAdd);

    }

    private boolean checkForAvailability(int numberToCheck){
        boolean result = true;
        for (Spot[] aBox : box) {
            for (Spot aSpot : aBox) {
                if (aSpot.getValue() == numberToCheck) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
