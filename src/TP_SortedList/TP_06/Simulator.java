package TP_SortedList.TP_06;

import TP_SortedList.Implementations.StaticSortedList;

import java.util.Scanner;

/**
 * Created by Tomas on 16/5/2017.
 */
public class Simulator {
    public Simulator() {
        StaticSortedList<Bus> buses = new StaticSortedList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Ingresar nuevo colectivo a la lista");
        System.out.println("2 - Eliminar colectivo de la lista");
        System.out.println("3 - Obtener informe");
        System.out.println("4 - Colectivos aptos para discapacitados");
        System.out.println("5 - Colectivos con mas de 27 asientos");
        System.out.println("6 - Guardar lista de colectivos en un archivo");
        System.out.println("7 - Recuperar lista de colectivos de un archivo");
        System.out.println("Ingrese el numero de la accion a realizar: ");
        int action = scanner.nextInt();
        while (action != -1) {

            switch (action) {
                case 1:
                    buses.insert(createBus());
                    break;

                case 2:
                    buses.removeS(createBus());
                    break;

                case 3:
                    printList(buses);
                    break;

                case 4:
                    printDisabledList(buses);
                    break;

                case 5:
                    printSeatsList(buses);
                    break;

                case 6:

                    break;

                case 7:

                    break;

                default:
                    break;
            }
            System.out.println("1 - Ingresar nuevo colectivo a la lista");
            System.out.println("2 - Eliminar colectivo de la lista");
            System.out.println("3 - Obtener informe");
            System.out.println("4 - Colectivos aptos para discapacitados");
            System.out.println("5 - Colectivos con mas de 27 asientos");
            System.out.println("6 - Guardar lista de colectivos en un archivo");
            System.out.println("7 - Recuperar lista de colectivos de un archivo");
            System.out.println("Ingrese otra accion: ");
            action = scanner.nextInt();
        }
    }

    private Bus createBus(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de linea: ");
        int lineNumber = scanner.nextInt();
        System.out.println("Ingrese el numero de interno: ");
        int internNumber = scanner.nextInt();
        System.out.println("Ingrese el numero de asientos: ");
        int seats = scanner.nextInt();
        System.out.println("Es apto para discapacitados? (si/no): ");
        String response = scanner.next();
        boolean disabled = true;
        if (response.equals("no"))
            disabled = false;
        return new Bus(lineNumber, internNumber, seats, disabled);
    }

    private void printList(StaticSortedList<Bus> list){
        System.out.println("Informe de colectivos: ");
        for (int i = 0; i < list.size(); i++){
            list.goTo(i);
            System.out.println("Numero de linea: " + list.getActual().getLineNumber() +
                    ", numero de interno: " + list.getActual().getInternNumber() +
                    ", asientos: " + list.getActual().getSeats() +
                    ", disponibilidad para discapacitados: " + list.getActual().isAllowsDisabled());
        }
    }

    private void printDisabledList(StaticSortedList<Bus> list){
        System.out.println("Informe de colectivos: ");
        for (int i = 0; i < list.size(); i++){
            list.goTo(i);
            if (list.getActual().isAllowsDisabled()) {
                System.out.println("Numero de linea: " + list.getActual().getLineNumber() +
                        ", numero de interno: " + list.getActual().getInternNumber() +
                        ", asientos: " + list.getActual().getSeats() );
            }
        }
    }

    private void printSeatsList(StaticSortedList<Bus> list){
        System.out.println("Informe de colectivos: ");
        for (int i = 0; i < list.size(); i++){
            list.goTo(i);
            if (list.getActual().getSeats() >= 27) {
                System.out.println("Numero de linea: " + list.getActual().getLineNumber() +
                        ", numero de interno: " + list.getActual().getInternNumber() +
                        ", disponibilidad para discapacitados: " + list.getActual().isAllowsDisabled());
            }
        }
    }

    public static void main(String[] args) {
        Simulator simulator = new Simulator();
    }
}
