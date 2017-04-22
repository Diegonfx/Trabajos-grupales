package TrabajoPractico_SoccerTeams;

/**
 * Implementation of a team.
 * @author Tomas Iturralde
 * @author Diego Mancini
 */
public class Team implements Comparable<Team> {

    private String name;
    private int points;

    public Team(String name , int points) {
        this.name = name;
        this.points = points;
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
}
