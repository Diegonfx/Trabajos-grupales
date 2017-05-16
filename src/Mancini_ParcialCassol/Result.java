package Mancini_ParcialCassol;


import Mancini_ParcialCassol.Listas.DynamicList;
import Mancini_ParcialCassol.Listas.List;

/**
 * @author Diego Mancini
 * It holds all the data gathered from the simulation of a day in the park
 */
public class Result {

    private ThemePark southerlands;
    private int amountOfRegular;
    private int amountOfFastPass;
    private int moneyFromRegular;
    private int moneyFromFastPass;
    private double porcentageTo18HS;
    private double porcentageFrom18HSto19HS;
    private double porcentageAtClosure;
    private List<Attraction> rankingOfAttractions;

    public Result(ThemePark southerlands) {
        this.southerlands = southerlands;
        amountOfRegular = 0;
        amountOfFastPass = 0;
        moneyFromRegular = 0;
        moneyFromFastPass = 0;
        porcentageTo18HS = 0;
        porcentageFrom18HSto19HS = 0;
        porcentageAtClosure = 0;
        rankingOfAttractions = new DynamicList<>();
    }

    public void setAmountOfRegular(int regular) {
        this.amountOfRegular = regular;
    }

    public void setAmountOfFastPass(int amountOfFastPass) {
        this.amountOfFastPass = amountOfFastPass;
    }

    public void setMoneyFromRegular(int moneyFromRegular) {
        this.moneyFromRegular = moneyFromRegular;
    }

    public void setMoneyFromFastPass(int moneyFromFastPass) {
        this.moneyFromFastPass = moneyFromFastPass;
    }

    public void setPorcentageTo18HS(double porcentageTo18HS) {
        this.porcentageTo18HS = porcentageTo18HS;
    }

    public void setPorcentageFrom18HSto19HS(double porcentageFrom18HSto19HS) {
        this.porcentageFrom18HSto19HS = porcentageFrom18HSto19HS;
    }

    public void setPorcentageAtClosure(double porcentageAtClosure) {
        this.porcentageAtClosure = porcentageAtClosure;
    }

    public void setRankingOfAttractions(List<Attraction> rankingOfAttractions) {
        this.rankingOfAttractions = rankingOfAttractions;
    }

    public ThemePark getSoutherlands() {
        return southerlands;
    }

    public int getAmountOfRegular() {
        return amountOfRegular;
    }

    public int getAmountOfFastPass() {
        return amountOfFastPass;
    }

    public int getMoneyFromRegular() {
        return moneyFromRegular;
    }

    public int getMoneyFromFastPass() {
        return moneyFromFastPass;
    }

    public double getPorcentageTo18HS() {
        return porcentageTo18HS;
    }

    public double getPorcentageFrom18HSto19HS() {
        return porcentageFrom18HSto19HS;
    }

    public double getPorcentageAtClosure() {
        return porcentageAtClosure;
    }

    public List<Attraction> getRankingOfAttractions() {
        return rankingOfAttractions;
    }
}
