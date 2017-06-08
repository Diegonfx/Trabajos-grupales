package TP_SortedList.TP_06;

import TP_SortedList.Implementations.DynamicSortedList;
import java.io.*;
import java.util.Scanner;

/**
 * Main Simulator for the bus system.
 * @author Tomas Iturralde
 * @author Diego Mancini
 */
public class Simulator {
    public Simulator() {
        DynamicSortedList<Bus> buses = new DynamicSortedList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n1 - Ingresar nuevo colectivo a la lista");
        System.out.println("2 - Eliminar colectivo de la lista");
        System.out.println("3 - Obtener informe");
        System.out.println("4 - Colectivos aptos para discapacitados");
        System.out.println("5 - Colectivos con mas de 27 asientos");
        System.out.println("6 - Guardar lista de colectivos en un archivo");
        System.out.println("7 - Recuperar lista de colectivos de un archivo");
        System.out.println("-1 - Terminar el programa");
        System.out.println("Ingrese el numero de la accion a realizar: ");
        int action = scanner.nextInt();
        while (action != -1) {

            switch (action) {
                case 1:
                    buses.insert(createBus());
                    break;

                case 2:
                    buses.remove(createBus());
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
                    serializeBinary(buses, "src\\TP_SortedList\\TP_06\\serializedList.txt");
                    break;

                case 7:
                    deserializeBinary("src\\TP_SortedList\\TP_06\\serializedList.txt");
                    break;

                default:
                    break;
            }
            System.out.println("\n1 - Ingresar nuevo colectivo a la lista");
            System.out.println("2 - Eliminar colectivo de la lista");
            System.out.println("3 - Obtener informe");
            System.out.println("4 - Colectivos aptos para discapacitados");
            System.out.println("5 - Colectivos con mas de 27 asientos");
            System.out.println("6 - Guardar lista de colectivos en un archivo");
            System.out.println("7 - Recuperar lista de colectivos de un archivo");
            System.out.println("-1 - Terminar el programa");
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

    private void printList(DynamicSortedList<Bus> list){
        System.out.println("\nInforme de colectivos: ");
        for (int i = 0; i < list.size(); i++){
            list.goTo(i);
            System.out.println("Numero de linea: " + list.getActual().getLineNumber() +
                    ", numero de interno: " + list.getActual().getInternNumber() +
                    ", asientos: " + list.getActual().getSeats() +
                    ", disponibilidad para discapacitados: " + list.getActual().isAllowsDisabled());
        }
    }

    private void printDisabledList(DynamicSortedList<Bus> list){
        System.out.println("\nInforme de colectivos con disponibilidad para discapacitados: ");
        for (int i = 0; i < list.size(); i++){
            list.goTo(i);
            if (list.getActual().isAllowsDisabled()) {
                System.out.println("Numero de linea: " + list.getActual().getLineNumber() +
                        ", numero de interno: " + list.getActual().getInternNumber() +
                        ", asientos: " + list.getActual().getSeats() );
            }
        }
    }

    private void printSeatsList(DynamicSortedList<Bus> list){
        System.out.println("\nInforme de colectivos con asientos para 27 o mas personas: ");
        for (int i = 0; i < list.size(); i++){
            list.goTo(i);
            if (list.getActual().getSeats() >= 27) {
                System.out.println("Numero de linea: " + list.getActual().getLineNumber() +
                        ", numero de interno: " + list.getActual().getInternNumber() +
                        ", disponibilidad para discapacitados: " + list.getActual().isAllowsDisabled());
            }
        }
    }

    public <T extends Comparable<T>> void serializeBinary(DynamicSortedList<T> list,String fileName){
        try {
            File file = new File(fileName);

            if (!file.exists()) {
                file.createNewFile();
            }

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

            oos.writeObject(list);
            System.out.println("Serialized");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends Comparable<T>> DynamicSortedList<T> deserializeBinary(String fileName){
        ObjectInputStream ois;
        try{
            ois = new ObjectInputStream(new FileInputStream(fileName));
            Object obj = ois.readObject();

            if(obj instanceof DynamicSortedList){
                System.out.println("Deserialized");
                return (DynamicSortedList<T>) obj;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        Simulator simulator = new Simulator();
    }
}
