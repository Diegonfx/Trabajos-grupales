package TrabajoPractico_SoccerTeams;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by DiegoMancini on 12/4/17.
 */
public class Tournament {

    private String name;
    private List<Team> teamsList;
    private List<Match> matchesList;
    private HashMap<Team, Integer> possibleResults;

    public Tournament(String name , List<Team> teamsList , List<Match> matchesList) {
        this.name = name;
        this.teamsList = teamsList;
        this.matchesList = matchesList;
        possibleResults = new HashMap<>();
        for (int i = 0; i < matchesList.size(); i+=2){
            for (int j = 1; j < matchesList.size(); j += 2){
                possibleResults.put(matchesList.get(i).getHomeTeam(), 0);
                possibleResults.put(matchesList.get(j).getAwayTeam(), 0);
            }

        }
    }

    public void printTable() {
        System.out.println("TOURNAMENT '' " + this.getName() + " '' CURRENT TABLE");
        System.out.print(" - Team ---- Points ---- \n");
        Collections.sort(teamsList , Collections.reverseOrder());
        System.out.println("    " + teamsList.get(0).getName() +  "        " + teamsList.get(0).getPoints());
        for (int i = 1; i < teamsList.size(); i++) {
            System.out.println("    " + teamsList.get(i).getName() +  "         " + teamsList.get(i).getPoints());
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

    public void solve(){
        for (int i = 0; i < matchesList.size(); i++){
            while (!matchesList.get(i).getStackOfResults().isEmpty()){
                if (isPossible(matchesList.get(i), matchesList.get(i).getStackOfResults().peek())){
                    if (matchesList.get(i).getStackOfResults().peek() == 1){
                        possibleResults.put(matchesList.get(i).getHomeTeam(), possibleResults.get(matchesList.get(i).getHomeTeam())+3);
                        matchesList.get(i).setResult(matchesList.get(i).getStackOfResults().peek());
                        break;
                    }
                    else if (matchesList.get(i).getStackOfResults().peek() == -1){
                        possibleResults.put(matchesList.get(i).getAwayTeam(), possibleResults.get(matchesList.get(i).getAwayTeam())+3);
                        matchesList.get(i).setResult(matchesList.get(i).getStackOfResults().peek());
                        break;
                    }
                    else if (matchesList.get(i).getStackOfResults().peek() == 0){
                        possibleResults.put(matchesList.get(i).getHomeTeam(), possibleResults.get(matchesList.get(i).getHomeTeam())+1);
                        possibleResults.put(matchesList.get(i).getAwayTeam(), possibleResults.get(matchesList.get(i).getAwayTeam())+1);
                        matchesList.get(i).setResult(matchesList.get(i).getStackOfResults().peek());
                        break;
                    }
                }
                matchesList.get(i).getStackOfResults().pop();
            }
            if (matchesList.get(i).getStackOfResults().isEmpty()){
                matchesList.get(i).getStackOfResults().push(1);
                matchesList.get(i).getStackOfResults().push(0);
                matchesList.get(i).getStackOfResults().push(-1);
                if (matchesList.get(i-1).getStackOfResults().peek() == 1)
                    possibleResults.put(matchesList.get(i-1).getHomeTeam(), possibleResults.get(matchesList.get(i-1).getHomeTeam())-3);
                else if (matchesList.get(i-1).getStackOfResults().peek() == -1)
                    possibleResults.put(matchesList.get(i-1).getAwayTeam(), possibleResults.get(matchesList.get(i-1).getAwayTeam())-3);
                else if (matchesList.get(i-1).getStackOfResults().peek() == 0){
                    possibleResults.put(matchesList.get(i-1).getHomeTeam(), possibleResults.get(matchesList.get(i-1).getHomeTeam())-1);
                    possibleResults.put(matchesList.get(i-1).getAwayTeam(), possibleResults.get(matchesList.get(i-1).getAwayTeam())-1);
                }
                matchesList.get(i-1).getStackOfResults().pop();
                i -= 2;
            }
        }
    }

    private boolean isPossible(Match matchPlayed, int possibleResult){
        if (possibleResult == 1 && matchPlayed.getHomeTeam().getPoints() >= possibleResults.get(matchPlayed.getHomeTeam())+3)
            return true;
        if (possibleResult == -1 && matchPlayed.getAwayTeam().getPoints() >= possibleResults.get(matchPlayed.getAwayTeam())+3)
            return true;
        if (possibleResult == 0 && matchPlayed.getHomeTeam().getPoints() >= possibleResults.get(matchPlayed.getHomeTeam())+1 && matchPlayed.getAwayTeam().getPoints() >= possibleResults.get(matchPlayed.getAwayTeam())+1)
            return true;
        return false;
    }
}
