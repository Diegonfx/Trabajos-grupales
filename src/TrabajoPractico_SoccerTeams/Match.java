package TrabajoPractico_SoccerTeams;

/**
 * Created by DiegoMancini on 12/4/17.
 */
public class Match {

    private Team homeTeam;
    private Team awayTeam;
    private int resultHomeTeam;
    private int resultAwayTeam;

    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        resultAwayTeam = 0;
        resultHomeTeam = 0;
    }

    //GETTERS AND SETTERS
    public Team getHomeTeam() {
        return homeTeam;
    }
    public Team getAwayTeam() {
        return awayTeam;
    }
    public int getResultHomeTeam() {
        return resultHomeTeam;
    }
    public int getResultAwayTeam() {
        return resultAwayTeam;
    }
    public void setResultHomeTeam(int resultHomeTeam) {
        this.resultHomeTeam = resultHomeTeam;
    }
    public void setResultAwayTeam(int resultAwayTeam) {
        this.resultAwayTeam = resultAwayTeam;
    }

}
