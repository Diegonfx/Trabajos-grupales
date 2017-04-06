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
        view = new KnightsTourMenu(new Next()) ;
        knightsTour = new DefinitiveKnightsTour();
    }

    public class Next implements ActionListener  {
        @Override
        public void actionPerformed(ActionEvent e) {
            knightsTour.fillArrayList();

            view.getKnightsTourBoard()[0][0].setIcon(knight);
            view.getKnightsTourBoard()[knightsTour.next().getPositionInRow()][knightsTour.next().getPositionInColumn()].setIcon(knight);
//                view.getKnightsTourBoard()[knightsTour.previous(knightsTour.next()).getPositionInRow()][knightsTour.previous(knightsTour.next()).getPositionInColumn()].setIcon(null);
        }
    }

        /*
        view.getKnightsTourBoard()[knightsTour.getSpotsToIterate().get(i).getPositionInRow()][knightsTour.getSpotsToIterate().get(i).getPositionInRow()]
        for (int pos = 0; pos < knightsTour.getSpotsToIterate().size(); pos++) {
                System.out.println("VALUE: " + knightsTour.getSpotsToIterate().get(pos).getValue() + " ||  SPOT: " + knightsTour.getSpotsToIterate().get(pos).getName() + " ||  ROW: " + knightsTour.getSpotsToIterate().get(pos).getPositionInRow() + " ||  COLUMN: " + knightsTour.getSpotsToIterate().get(pos).getPositionInColumn());
            }
         */

}
