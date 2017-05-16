package Mancini_ParcialCassol;


import TP_Lists.Listas.List;
import TrabajoPractico3.SimpleCalculator.Scanner;

/**
 * @author Diego Mancini
 */
public class Simulator {

    public Result run() {
        ThemePark southerland = new ThemePark();
        Result result = new Result(southerland);
        int amountOfAttractions = Scanner.getInt("Insert amount of attractions between 4-8 --> ");
        southerland.openAttractions(amountOfAttractions);
        int clientLeftUntil18HS = 0 ;
        int clientLeftBetween18HSto19HS ;
        int clientLeftAtClosure;
        for (int i = 1 ; i <= 600 ; i++) {
            southerland.addCurrent(1);
            if (i <= 540) {
                southerland.clientsEnter();
                southerland.clientTakesAction();
                for (int j = 0 ; j < southerland.getAttractionsList().size() ; j++) {
                    southerland.getAttractionsList().goTo(j);
                    southerland.getAttractionsList().getActual().operate(southerland);
                }
                if (i % 5 == 0 ) {
                    for (int j = 0 ; j < southerland.getAttractionsList().size() ; j++) {
                        southerland.getAttractionsList().goTo(j);
                        southerland.getAttractionsList().getActual().returnToHub(southerland);
                    }
                }

            } else if (i >= 541 && i < 599) {
                clientLeftUntil18HS = southerland.getAmountOfClientsLeft()  ;
                southerland.clientTakesAction();
                for (int j = 0 ; j < southerland.getAttractionsList().size() ; j++) {
                    southerland.getAttractionsList().goTo(j);
                    southerland.getAttractionsList().getActual().operate(southerland);
                }
                if (i % 5 == 0 ) {
                    for (int j = 0 ; j < southerland.getAttractionsList().size() ; j++) {
                        southerland.getAttractionsList().goTo(j);
                        southerland.getAttractionsList().getActual().returnToHub(southerland);
                    }
                }
            } else {
                clientLeftBetween18HSto19HS = (southerland.getAmountOfClientsLeft() - clientLeftUntil18HS);
                southerland.emptyPark();
                clientLeftAtClosure = (southerland.getAmountOfClientsLeft() - clientLeftBetween18HSto19HS);
                result.setAmountOfRegular(southerland.getRegularTickets());
                result.setAmountOfFastPass(southerland.getFastPass());
                result.setMoneyFromRegular(southerland.moneyFromRegularTickets());
                result.setMoneyFromFastPass(southerland.moneyFromFastPassTickets());
                result.setPorcentageTo18HS(clientLeftUntil18HS % southerland.getAmountOfClients());
                result.setPorcentageFrom18HSto19HS(clientLeftBetween18HSto19HS % southerland.getAmountOfClients());
                result.setPorcentageAtClosure(clientLeftAtClosure % southerland.getAmountOfClients());
                Mancini_ParcialCassol.Listas.List<Attraction> ranking = southerland.getAttractionsList();
                result.setRankingOfAttractions(ranking);
            }
        }
        System.out.println("\n 1. Compras de ticket normal: " + result.getAmountOfRegular() + "\n 2. Compras de ticket fast pass: " + result.getAmountOfFastPass()
         + "\n 3. Monto recaudado de ticket comun: " + result.getMoneyFromRegular() + "\n 4. Monto recaudado de ticket fast pass: " + result.getMoneyFromFastPass()
         + "\n 5. Porcentaje que dejaron el parque antes de las 18hs: " + result.getPorcentageTo18HS()
         + "\n 6. Porcentaje que dejaron el parque entre las 18hs y las 19hs : " + result.getPorcentageFrom18HSto19HS()
         + "\n 7. Porcentaje que dejaron el parque a las 19hs: " + result.getPorcentageAtClosure()
         + "\n 8. Ranking de atracciones: " + result.getRankingOfAttractions().getActual().getName() + " ||| Time in queue: " + result.getRankingOfAttractions().getActual().getTimeInQueue());
        return result;
    }

}
