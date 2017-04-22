package TrabajoPractico_SoccerTeams;

import TrabajoPractico3.Stacks.StaticStack.StaticStack;

/**
 * Created by DiegoMancini on 12/4/17.
 */
public class Match {

    private Team homeTeam;
    private Team awayTeam;
    private int result;
    private StaticStack<Integer> stackOfResults;

    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        result = 0;
        stackOfResults = new StaticStack<>(3);
        stackOfResults.push(-1);
        stackOfResults.push(0);
        stackOfResults.push(1);
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
    public StaticStack<Integer> getStackOfResults() {
        return stackOfResults;
    }
}
