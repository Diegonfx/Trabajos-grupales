package TP_Lists.TP_Metrovias_Iturralde;

/**
 * Created by Tomas on 22/4/2017.
 */
public class Simulator {
    public static void main(String[] args) {
        Metrovias metrovias = new Metrovias(5);
        metrovias.simulation();

        for (int i = 0; i < metrovias.getWindowsOpen().size(); i++) {
            metrovias.getWindowsOpen().goTo(i);
            System.out.println("El tiempo medio de la fila " + i + " es de: " + metrovias.getWindowsOpen().getActual().averageTime() + " segundos");
            System.out.println("El monto total recaudado por la fila " + i + " es de: " + metrovias.getWindowsOpen().getActual().getTotalIncome() + " pesos");
            System.out.println("El tiempo ocioso de la fila " + i + " es de: " + metrovias.getWindowsOpen().getActual().getFreeTime() + " segundos");
            System.out.println("La cantidad de personas servidas por la fila " + i + " es de: " + metrovias.getWindowsOpen().getActual().getClientsServed());
            System.out.println("--------------");
        }

    }
}
