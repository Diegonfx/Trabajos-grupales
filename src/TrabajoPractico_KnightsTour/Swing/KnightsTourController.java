package TrabajoPractico_KnightsTour.Swing;

import TrabajoPractico_KnightsTour.Implementation.DefinitiveKnightsTour;
import TrabajoPractico_KnightsTour.Implementation.Spot;
import com.sun.org.glassfish.external.statistics.annotations.Reset;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;

import javax.swing.*;
import javax.swing.colorchooser.DefaultColorSelectionModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * It controlls the view of the knight's tour
 * @author Tomas Iturralde
 * @author Diego Mancini
 */
public class KnightsTourController {

    private KnightsTourMenu view;
    private DefinitiveKnightsTour knightsTour;
    private ImageIcon knight = new ImageIcon("src/TrabajoPractico_KnightsTour/Swing/horseknight.png");

    public KnightsTourController() {
        view = new KnightsTourMenu(new Next() , new Clear()) ;
        knightsTour = new DefinitiveKnightsTour();
    }

    public class Next implements ActionListener  {
        @Override
        public void actionPerformed(ActionEvent e) {
            knightsTour.fillArrayList();
            int a = 0, b = 0;
            for (int i = 0; i < 1; i++) {
                a = knightsTour.getSpotsToIterate().get(i).getPositionInRow();
                b = knightsTour.getSpotsToIterate().get(i).getPositionInColumn();
            }
            knightsTour.next();
            view.getKnightsTourBoard()[a][b].setIcon(knight);
                if (knightsTour.getSpotsToIterate().get(0).getValue() == 0 && knightsTour.getSpotsToIterate().get(1).getValue() == 1 ) {
                    view.getKnightsTourBoard()[knightsTour.getSpotsToIterate().get(1).getPositionInRow()][knightsTour.getSpotsToIterate().get(1).getPositionInColumn()].setBackground(Color.GREEN);
                } else if (knightsTour.getSpotsToIterate().get(0).getValue() == 1 && knightsTour.getSpotsToIterate().get(1).getValue() == 2) {
                    view.getKnightsTourBoard()[knightsTour.getSpotsToIterate().get(1).getPositionInRow()][knightsTour.getSpotsToIterate().get(1).getPositionInColumn()].setBackground(Color.RED);
                } else if ((knightsTour.getSpotsToIterate().get(0).getValue() == 2 && knightsTour.getSpotsToIterate().get(1).getValue() == 3)) {
                    view.getKnightsTourBoard()[knightsTour.getSpotsToIterate().get(1).getPositionInRow()][knightsTour.getSpotsToIterate().get(1).getPositionInColumn()].setBackground(Color.BLUE);
                } else if(knightsTour.getSpotsToIterate().get(0).getValue() == 3 && knightsTour.getSpotsToIterate().get(1).getValue() == 4) {
                    view.getKnightsTourBoard()[knightsTour.getSpotsToIterate().get(1).getPositionInRow()][knightsTour.getSpotsToIterate().get(1).getPositionInColumn()].setBackground(Color.MAGENTA);
                } else if (knightsTour.getSpotsToIterate().get(0).getValue() == 3 && knightsTour.getSpotsToIterate().get(1).getValue() == 2) {
                    view.getKnightsTourBoard()[knightsTour.getSpotsToIterate().get(1).getPositionInRow()][knightsTour.getSpotsToIterate().get(1).getPositionInColumn()].setBackground(Color.RED);
                } else if ((knightsTour.getSpotsToIterate().get(0).getValue() == 2 && knightsTour.getSpotsToIterate().get(1).getValue() == 1)) {
                    view.getKnightsTourBoard()[knightsTour.getSpotsToIterate().get(1).getPositionInRow()][knightsTour.getSpotsToIterate().get(1).getPositionInColumn()].setBackground(Color.GREEN);
                } else if(knightsTour.getSpotsToIterate().get(0).getValue() == 1 && knightsTour.getSpotsToIterate().get(1).getValue() == 0) {
                    view.getKnightsTourBoard()[knightsTour.getSpotsToIterate().get(1).getPositionInRow()][knightsTour.getSpotsToIterate().get(1).getPositionInColumn()].setBackground(Color.GRAY);
                }
            }
        }

    public class Clear implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    view.getKnightsTourBoard()[i][j].setIcon(null);
                }
            }
        }
    }
}


