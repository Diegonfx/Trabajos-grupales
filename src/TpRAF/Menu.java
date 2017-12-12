package TpRAF;

import java.io.*;
import java.util.*;

/**
 * Created by Tomás Iturralde on 10/12/17.
 * Materia: AyED.
 */
public class Menu {
    private Scanner reader;
    Menu() throws IOException {
        try{
            reader = new Scanner(System.in);
            int option = menu();

            CarFile carF = new CarFile("Ford");

            while (option <7){
                switch(option){
                    case 1:
                        add(carF);
                        break;
                    case 2:
                        delete(carF);
                        break;
                    case 3:
                        modify(carF);
                        break;
                    case 4:
                        consults(carF);
                        break;
                    case 5:
                        inform(carF);
                        break;
                    case 6:
                        getIndexFile(carF);
                        break;
                }
                option = menu();
            }
            carF.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private int menu(){
        System.out.println("1. Add car");
        System.out.println("2. Delete car");
        System.out.println("3. Modify car");
        System.out.println("4. Consults");
        System.out.println("5. Informs");
        System.out.println("6. Generate index");
        System.out.println("7. End");
        System.out.println("Option: ");
        String opc = reader.nextLine();
        return Integer.parseInt(opc);
    }

    private void consults(CarFile carFile) throws IOException {
        System.out.println(" 1. Book data. \n 2. Amount of cars. \n " +
                "3. Amount of full cars. \n 4. Amount of base cars. \n Choose an option:  ");
        int option = Integer.parseInt(reader.nextLine());
        switch (option){
            case 1:
                search(carFile);
                break;
            case 2:
                getAmount(carFile);
                break;
            case 3:
                getFullAmount(carFile);
                break;
            case 4:
                getBaseAmount(carFile);
                break;
            default:
                System.out.println("Wrong option"+"\n");
                break;
        }
    }

    private void inform(CarFile carFile) throws IOException {
        System.out.println(" 1. All cars data. \n " +
                "2. All full cars. \n 3. All base cars. \n Choose an option: ");
        int option = Integer.parseInt(reader.nextLine());
        switch (option) {
            case 1:
                carFile.printEveryCar();
                break;
            case 2:
                carFile.printEveryFullCar();
                break;
            case 3:
                carFile.printEveryBaseCar();
                break;
            default:
                System.out.println("Wrong option"+"\n");
                break;
        }
    }

    public void add(CarFile carFile) throws IOException {
        int code;
        double price;
        char type;
        carFile.end();

        try {
            System.out.println("Code: ");
            code = Integer.parseInt(reader.nextLine());
            System.out.println("Price: ");
            price = Double.parseDouble(reader.nextLine());
            System.out.println("Type('F' for full or 'B' for Base): ");
            type = reader.nextLine().charAt(0);
            carFile.write(new Car(code, price , type));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void sizeFile(CarFile carF){
        try {
            System.out.println("Size of the file is: " + carF.length());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void show(CarFile carF) {
        Car car;
        try {
            long cant = carF.amountOfCars();
            for (long i = 0; i < cant ; i++){
                car = carF.read();
                if(car.isActive())
                    System.out.println(car.toString()+"\n");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void search(CarFile carFile) {
        Car car;
        try {
            System.out.println("Enter car code: ");
            int code = Integer.parseInt(reader.nextLine());
            car = carFile.search(code);
            if (car.getCode() == 0)
                System.out.println("Invalid code"+"\n");
            else
                System.out.println(car.toString()+"\n");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void delete(CarFile carFile) {
        try {
            System.out.println("Enter car code: ");
            int code = Integer.parseInt(reader.nextLine());
            if (carFile.delete(code)) {
                System.out.println("Successfully deleted"+"\n");
            }
            else
                System.out.println("Wrong code"+"\n");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void modify(CarFile carFile) {
        try {
            System.out.println("Enter car code: ");
            int code = Integer.parseInt(reader.nextLine());
            if (carFile.modify(code))
                System.out.println("Successfully modified"+"\n");
            else
                System.out.println("Wrong code"+"\n");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    private static void getAmount(CarFile carFile) throws IOException {
        carFile.amountOfActiveCars(carFile);
    }

    private static void getFullAmount(CarFile carFile) throws IOException {
        carFile.amountOfFull(carFile);
    }

    private static void getBaseAmount(CarFile carFile) throws IOException {
        carFile.amountOfBase(carFile);
    }

    private void getIndexFile(CarFile carFile) throws IOException {
        File f = new File("Index file");
        FileWriter fileWriter = new FileWriter(f);
        Car car;
        carFile.start();
        long cant = carFile.amountOfCars();
        for (long i = 0; i < cant ; i++){
            long start  = carFile.carSize*i;
            long end = carFile.carSize * (i+1);
            car = carFile.read();
            if(car.isActive()){
                fileWriter.write("Car code: " + car.getCode()+ ". From byte" + start + " to byte " + end +".\n");
            }
        }
        fileWriter.close();
        System.out.println("Index file successfully made.");
    }
}
