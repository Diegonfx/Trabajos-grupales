package TrabajoPractico_KnightsTour;

import TrabajoPractico_KnightsTour.Implementation.DefinitiveKnightsTour;
import TrabajoPractico_KnightsTour.Swing.KnightsTourController;

/**
 * Created by DiegoMancini on 3/4/17.
 */
public class KnightsTourMain {

    public static void main(String[] args) {
//        DefinitiveKnightsTour knightsTour = new DefinitiveKnightsTour();
//        knightsTour.fillArrayList();
//        for (int i = 0 ; i < knightsTour.getSpotsToIterate().size() ; i++) {
//            System.out.println("VALUE: " + knightsTour.getSpotsToIterate().get(i).getValue()+" ||  SPOT: " + knightsTour.getSpotsToIterate().get(i).getName() + " ||  ROW: " + knightsTour.getSpotsToIterate().get(i).getPositionInRow() + " ||  COLUMN: " + knightsTour.getSpotsToIterate().get(i).getPositionInColumn());
//        }
//        jt.getMovements();
        new KnightsTourController();
    }


}
