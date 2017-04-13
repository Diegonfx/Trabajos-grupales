package TrabajoPractico_SoccerTeams;

/**
 * Created by DiegoMancini on 12/4/17.
 */
public class Team {

    private String name;
    private int points;
    private int matchesPlayed;
    private int matchesWon;
    private int matchesLost;
    private int matchesDrawn;
    private int goalsFor;
    private int goalsAgainst;
    private int goalDifference;
    private int positionInTournament;
    private boolean wonMatch;
    private double winCoef;

    public Team(String name , double winCoef) {
        this.name = name;
        points = 0;
        matchesDrawn = 0;
        matchesLost = 0;
        matchesWon = 0;
        matchesPlayed = 0;
        goalsAgainst = 0;
        goalsFor = 0;
        goalDifference = goalsFor-goalsAgainst;
        positionInTournament = 0;
        wonMatch = true;
        this.winCoef = winCoef;
    }

    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public int getMatchesPlayed() {
        return matchesPlayed;
    }
    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }
    public int getMatchesWon() {
        return matchesWon;
    }
    public void setMatchesWon(int matchesWon) {
        this.matchesWon = matchesWon;
    }
    public int getMatchesLost() {
        return matchesLost;
    }
    public void setMatchesLost(int matchesLost) {
        this.matchesLost = matchesLost;
    }
    public int getMatchesDrawn() {
        return matchesDrawn;
    }
    public void setMatchesDrawn(int matchesDrawn) {
        this.matchesDrawn = matchesDrawn;
    }
    public int getGoalsFor() {
        return goalsFor;
    }
    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }
    public int getGoalsAgainst() {
        return goalsAgainst;
    }
    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }
    public int getGoalDifference() {
        return goalDifference;
    }
    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }
    public int getPositionInTournament() {
        return positionInTournament;
    }
    public void setPositionInTournament(int positionInTournament) {
        this.positionInTournament = positionInTournament;
    }
    public boolean isWonMatch() {
        return wonMatch;
    }
    public void setWonMatch(boolean wonMatch) {
        this.wonMatch = wonMatch;
    }
    public double getWinCoef() {
        return winCoef;
    }
    public void setWinCoef(double winCoef) {
        this.winCoef = winCoef;
    }
}
