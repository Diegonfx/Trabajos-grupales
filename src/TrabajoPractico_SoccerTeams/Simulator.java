package TrabajoPractico_SoccerTeams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DiegoMancini on 13/4/17.
 */
public class Simulator {

    public static void main(String[] args) {
        List<Team> torneoArgentinoTest = new ArrayList<>();

        Team boca = new Team("BOC" , 12 , 4);
        Team river = new Team("RIV" , 0 , 4);
        Team independiente = new Team("IND" , 4 , 4);
        Team racing = new Team("RAC" , 3 , 4);
        Team sanLorenzo = new Team("SLO" , 7 , 4);

        torneoArgentinoTest.add(boca);
        torneoArgentinoTest.add(river);
        torneoArgentinoTest.add(independiente);
        torneoArgentinoTest.add(racing);
        torneoArgentinoTest.add(sanLorenzo);

        List<Match> matchesPLayed = new ArrayList<>();
        Match match1 = new Match(boca , river); //LOCAL
        Match match2 = new Match(boca , independiente); //LOCAL
        Match match3 = new Match(boca , racing); //LOCAL
        Match match4 = new Match(boca , sanLorenzo); //LOCAL
        Match match5 = new Match(river , independiente); //VISITANTE
        Match match6 = new Match(river , racing); //VISITANTE
        Match match7 = new Match(river , sanLorenzo); //VISITANTE
        Match match8 = new Match(independiente , racing); //LOCAL
        Match match9 = new Match(independiente , sanLorenzo); //EMPATE
        Match match10 = new Match(racing , sanLorenzo); //VISITANTE
        matchesPLayed.add(match1);
        matchesPLayed.add(match2);
        matchesPLayed.add(match3);
        matchesPLayed.add(match4);
        matchesPLayed.add(match5);
        matchesPLayed.add(match6);
        matchesPLayed.add(match7);
        matchesPLayed.add(match8);
        matchesPLayed.add(match9);
        matchesPLayed.add(match10);

        Tournament primeraDivision = new Tournament("PRIMERA DIVISION" , torneoArgentinoTest , matchesPLayed);
        primeraDivision.printTable();
    }

}
