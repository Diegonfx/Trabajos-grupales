package TrabajoPractico_SoccerTeams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DiegoMancini on 12/4/17.
 */
public class Tournament {

    private String name;
    private List<Team> teamsList;
    private List<Match> matchesList;
    private final static int POINTS_WIN = 3;
    private final static int POINTS_DRAW = 1;
    private final static int POINTS_LOSE = 0;

    public Tournament(String name , List<Team> teamsList) {
        this.name = name;
        this.teamsList = teamsList;
        matchesList = new ArrayList<>();
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
    public static int getPointsWin() {
        return POINTS_WIN;
    }
    public static int getPointsDraw() {
        return POINTS_DRAW;
    }
    public static int getPointsLose() {
        return POINTS_LOSE;
    }
}
