package TrabajoPractico_SoccerTeams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by DiegoMancini on 12/4/17.
 */
public class Tournament {

    private String name;
    private List<Team> teamsList;
    private List<Match> matchesList;

    public Tournament(String name , List<Team> teamsList , List<Match> matchesList) {
        this.name = name;
        this.teamsList = teamsList;
        this.matchesList = matchesList;
    }

    public void printTable() {
        System.out.println("TOURNAMENT '' " + this.getName() + " '' CURRENT TABLE");
        System.out.print(" - Team ---- Points ---- Matches ---- \n");
        Collections.sort(teamsList , Collections.reverseOrder());
        System.out.println("    " + teamsList.get(0).getName() +  "        " + teamsList.get(0).getPoints() + "           " + teamsList.get(0).getMatchesPlayed());
        for (int i = 1; i < teamsList.size(); i++) {
            System.out.println("    " + teamsList.get(i).getName() +  "         " + teamsList.get(i).getPoints() + "           " + teamsList.get(i).getMatchesPlayed());
        }
        System.out.println("\nRESULTS MEANING: --> ||| HOME TEAM WON = 1  |||  AWAY TEAM WON = -1  |||  TEAMS DRAW = 0 \n");
        int position = 1;
        for (int i = 0 ; i < matchesList.size() ; i++) {
            System.out.println("Match " + position + ": (H) " + matchesList.get(i).getHomeTeam().getName() + " x " + matchesList.get(i).getAwayTeam().getName() + " (A) " + "----> RESULT = " + matchesList.get(i).getResult());
            position++;
        }
    }

    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Team> getTeamsList() {
        return teamsList;
    }
    public void setTeamsList(List<Team> teamsList) {
        this.teamsList = teamsList;
    }
    public List<Match> getMatchesList() {
        return matchesList;
    }
    public void setMatchesList(List<Match> matchesList) {
        this.matchesList = matchesList;
    }

}
