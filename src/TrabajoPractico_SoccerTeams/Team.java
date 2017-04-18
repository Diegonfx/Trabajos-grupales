package TrabajoPractico_SoccerTeams;

/**
 * Created by DiegoMancini on 12/4/17.
 */
public class Team implements Comparable<Team> {

    private String name;
    private int points;
    private int matchesPlayed;
//    private int matchesWon;
//    private int matchesLost;
//    private int matchesDrawn;
//    private boolean wonMatch;
//    private boolean drawMatch;
//    private boolean lostMatch;

    public Team(String name , int points , int matchesPlayed) {
        this.name = name;
        this.points = points;
        this.matchesPlayed = matchesPlayed;
//        matchesDrawn = 0;
//        matchesLost = 0;
//        matchesWon = 0;
//        wonMatch = false;
//        drawMatch = true;
//        lostMatch = false;

    }

    @Override
    public int compareTo(Team z) {
        int res=0;
        if (this.getPoints() < z.getPoints()) {
            res=-1;
        }
        if (this.getPoints()> z.getPoints()){
            res=1;
        }
        return res;
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

//    public int getMatchesWon() {
//        return matchesWon;
//    }
//    public void setMatchesWon(int matchesWon) {
//        this.matchesWon = matchesWon;
//    }
//
//    public int getMatchesLost() {
//        return matchesLost;
//    }
//    public void setMatchesLost(int matchesLost) {
//        this.matchesLost = matchesLost;
//    }
//
//    public int getMatchesDrawn() {
//        return matchesDrawn;
//    }
//    public void setMatchesDrawn(int matchesDrawn) {
//        this.matchesDrawn = matchesDrawn;
//    }

//    public boolean isWonMatch() {
//        return wonMatch;
//    }
//    public void setWonMatch(boolean wonMatch) {
//        this.wonMatch = wonMatch;
//    }
//
//    public boolean isDrawMatch() {
//        return drawMatch;
//    }
//    public void setDrawMatch(boolean drawMatch) {
//        this.drawMatch = drawMatch;
//    }
//
//    public boolean isLostMatch() {
//        return lostMatch;
//    }
//    public void setLostMatch(boolean lostMatch) {
//        this.lostMatch = lostMatch;
//    }

}
