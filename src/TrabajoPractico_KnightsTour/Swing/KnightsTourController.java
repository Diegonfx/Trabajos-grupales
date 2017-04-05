package TrabajoPractico_KnightsTour.Swing;

import TrabajoPractico_KnightsTour.Implementation.DefinitiveKnightsTour;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by DiegoMancini on 5/4/17.
 */
public class KnightsTourController {

    private KnightsTourMenu view;
    private DefinitiveKnightsTour knightsTour;
    private ImageIcon knight = new ImageIcon("/Users/DiegoMancini/IdeaProjects/Trabajos grupales/src/TrabajoPractico_KnightsTour/Swing/horseknight.png");

    public KnightsTourController() {
        view = new KnightsTourMenu(new Solve()) ;
        knightsTour = new DefinitiveKnightsTour();
    }

    public class Solve implements ActionListener  {
        @Override
        public void actionPerformed(ActionEvent e) {
            knightsTour.fillArrayList();
            for (int pos = 0; pos < knightsTour.getSpotsToIterate().size(); pos++) {
                System.out.println("VALUE: " + knightsTour.getSpotsToIterate().get(pos).getValue() + " ||  SPOT: " + knightsTour.getSpotsToIterate().get(pos).getName() + " ||  ROW: " + knightsTour.getSpotsToIterate().get(pos).getPositionInRow() + " ||  COLUMN: " + knightsTour.getSpotsToIterate().get(pos).getPositionInColumn());
            }
        }
    }

        /*
        view.getKnightsTourBoard()[knightsTour.getSpotsToIterate().get(i).getPositionInRow()][knightsTour.getSpotsToIterate().get(i).getPositionInRow()]
        System.out.println("VALUE: " + knightsTour.getSpotsToIterate().get(pos).getValue() + " ||  SPOT: " + knightsTour.getSpotsToIterate().get(pos).getName() + " ||  ROW: " + knightsTour.getSpotsToIterate().get(pos).getPositionInRow() + " ||  COLUMN: " + knightsTour.getSpotsToIterate().get(pos).getPositionInColumn());
         */

}
