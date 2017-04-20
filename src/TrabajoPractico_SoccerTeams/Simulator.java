package TrabajoPractico_SoccerTeams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by DiegoMancini on 13/4/17.
 */
public class Simulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de equipos: ");
        int teams = scanner.nextInt();
        System.out.println("Ingrese la cantidad de partidos jugados: ");
        int matches = scanner.nextInt();

        List<Team> teams1 = new ArrayList<>(teams);
        List<Match> matchesPlayed = new ArrayList<>(matches);
        Tournament tournament = new Tournament("Torneo", teams1, matchesPlayed);

        System.out.println("Ingrese el nombre del equipo: ");
        String input = scanner.next();
        while (!input.equals("-1")){
            System.out.println("Ingrese cuantos puntos tiene: ");
            int points = scanner.nextInt();
            Team team = new Team(input, points);
            teams1.add(team);
            System.out.println("Ingrese el siguiente equipo: ");
            input = scanner.next();
        }

       /* System.out.println("Ingrese el equipo local del primer partido: ");
        String input1 = scanner.next();
        while (!input1.equals("-1")){
            for (int i = 0; i < teams1.size(); i++){
                if (teams1.get(i).getName().equals(input1)){
                    Team homeTeam = teams1.get(i);

                    System.out.println("Ingrese el equipo visitante: ");
                    String away = scanner.next();
                    for (int j = 0; j < teams1.size(); j++) {
                        if (teams1.get(j).getName().equals(away)){
                            Team awayTeam = teams1.get(i);
                            Match match = new Match(homeTeam, awayTeam);
                        } else {
                            System.out.println("Not a Team!");
                            break;
                        }
                    }

                } else {
                    System.out.println("Not a Team!");
                    break;
                }
            }
            System.out.println("Ingrese el equipo local del siguiente partido: ");
            input1 = scanner.next();
        }





        List<Team> torneoArgentinoTest = new ArrayList<>();

        Team boca = new Team("BOC" , 12);
        Team river = new Team("RIV" , 0);
        Team independiente = new Team("IND" , 4);
        Team racing = new Team("RAC" , 3);
        Team sanLorenzo = new Team("SLO" , 7);

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
        primeraDivision.printTable();*/
    }

}
