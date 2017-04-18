package TrabajoPractico_SoccerTeams;

import TrabajoPractico3.Stacks.StaticStack.StaticStack;

/**
 * Created by DiegoMancini on 12/4/17.
 */
public class Match {

    private Team homeTeam;
    private Team awayTeam;
    private int result;
    private boolean won;
    private boolean teamsDraw;
    private StaticStack<Outcome> stackOfResults;

    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        result = 0;
        won = false;
        teamsDraw = true;
        stackOfResults = new StaticStack<>(3);
        stackOfResults.push(new AwayTeamWon());
        stackOfResults.push(new MatchDraw());
        stackOfResults.push(new HomeTeamWon());
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
    public boolean hasWon() {
        return won;
    }
    public void setWon(boolean result) {
        this.won = result;
    }
    public boolean isTeamsDraw() {
        return teamsDraw;
    }
    public void setTeamsDraw(boolean teamsDraw) {
        this.teamsDraw = teamsDraw;
    }
    public StaticStack<Outcome> getStackOfResults() {
        return stackOfResults;
    }
}
