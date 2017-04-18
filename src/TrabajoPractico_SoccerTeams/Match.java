package TrabajoPractico_SoccerTeams;

/**
 * Created by DiegoMancini on 12/4/17.
 */
public class Match {

    private Team homeTeam;
    private Team awayTeam;
    private int result;
    private final static int WIN = 1;
    private final static int DRAW = 0;
    private final static int LOSE = -1;
    private boolean homeTeamWon;
    private boolean awayTeamWon;
    private boolean teamsDraw;

    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        result = DRAW;
        homeTeamWon = false;
        awayTeamWon = false;
        teamsDraw = true;
    }

    //GETTERS AND SETTERS
    public Team getHomeTeam() {
        return homeTeam;
    }
    public Team getAwayTeam() {
        return awayTeam;
    }
    public int getResult() {
        return result;
    }
    public void setResult(int result) {
        this.result = result;
    }
    public boolean isHomeTeamWon() {
        return homeTeamWon;
    }
    public void setHomeTeamWon(boolean homeTeamWon) {
        this.homeTeamWon = homeTeamWon;
    }
    public boolean isAwayTeamWon() {
        return awayTeamWon;
    }
    public void setAwayTeamWon(boolean awayTeamWon) {
        this.awayTeamWon = awayTeamWon;
    }
    public boolean isTeamsDraw() {
        return teamsDraw;
    }
    public void setTeamsDraw(boolean teamsDraw) {
        this.teamsDraw = teamsDraw;
    }

}
