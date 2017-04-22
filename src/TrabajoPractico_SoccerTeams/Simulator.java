package TrabajoPractico_SoccerTeams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Tester for the tournament solver.
 * @author Tomas Iturralde
 * @author Diego Mancini
 */
public class Simulator {

    public static void main(String[] args) {
        List<Team> torneoArgentinoTest = new ArrayList<>();

        Team boca = new Team("BOC" , 12);
        Team river = new Team("RIV" , 0);
        Team independiente = new Team("IND" , 7);
        Team racing = new Team("RAC" , 3);
        Team sanLorenzo = new Team("SLO" , 7);
        Team belgrano = new Team("BEL", 6);
        Team velez = new Team("VEL", 5);
        Team estudiantes = new Team("EST", 8);
        Team talleres = new Team("TAL", 1);
        Team gimnasia = new Team("GIM", 5);

        torneoArgentinoTest.add(boca);
        torneoArgentinoTest.add(river);
        torneoArgentinoTest.add(independiente);
        torneoArgentinoTest.add(racing);
        torneoArgentinoTest.add(sanLorenzo);
        torneoArgentinoTest.add(belgrano);
        torneoArgentinoTest.add(velez);
        torneoArgentinoTest.add(estudiantes);
        torneoArgentinoTest.add(talleres);
        torneoArgentinoTest.add(gimnasia);

        List<Match> matchesPlayed = new ArrayList<>();
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
        Match match11 = new Match(belgrano, gimnasia); //LOCAL
        Match match12 = new Match(belgrano, velez); //EMPATE
        Match match13 = new Match(belgrano, estudiantes); //EMPATE
        Match match14 = new Match(belgrano, talleres); //EMPATE
        Match match15 = new Match(gimnasia, velez); //EMPATE
        Match match16 = new Match(gimnasia,estudiantes); //EMPATE
        Match match17 = new Match(gimnasia,talleres); //LOCAL
        Match match18 = new Match(velez,estudiantes); //VISITANTE
        Match match19 = new Match(velez, talleres); //LOCAL
        Match match20 = new Match(estudiantes,talleres); //LOCAL

        matchesPlayed.add(match1);
        matchesPlayed.add(match2);
        matchesPlayed.add(match3);
        matchesPlayed.add(match4);
        matchesPlayed.add(match5);
        matchesPlayed.add(match6);
        matchesPlayed.add(match7);
        matchesPlayed.add(match8);
        matchesPlayed.add(match9);
        matchesPlayed.add(match10);
        matchesPlayed.add(match11);
        matchesPlayed.add(match12);
        matchesPlayed.add(match13);
        matchesPlayed.add(match14);
        matchesPlayed.add(match15);
        matchesPlayed.add(match16);
        matchesPlayed.add(match17);
        matchesPlayed.add(match18);
        matchesPlayed.add(match19);
        matchesPlayed.add(match20);

        Tournament primeraDivision = new Tournament("PRIMERA DIVISION" , torneoArgentinoTest , matchesPlayed);
        primeraDivision.solve();
        primeraDivision.printTable();
    }

}
