package TpRAF;

import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Diego Mancini on 12/10/17.
 * Materia: AyED.
 */
public class CarFile {
    private File f;
    private RandomAccessFile raf;
    int carSize = 16;
    int bytes = 0;
    private Scanner reader ;

    CarFile(String nombre)throws FileNotFoundException {
        f = new File(nombre);
        raf = new RandomAccessFile(f,"rw");
        reader = new Scanner(System.in);
    }

    public void write(Car c) throws IOException {
        raf.writeInt(c.getCode());
        raf.writeDouble(c.getPrice());
        raf.writeBoolean(c.isAvailable());
        raf.writeChar(c.getType());
        raf.writeBoolean(c.isActive());
        bytes += carSize;
    }
    public void close() throws IOException {
        raf.close();
    }

    public long length ()throws IOException{
        return raf.length();
    }

    Car read() throws IOException{
        return new Car(raf.readInt(), raf.readDouble(),
                raf.readBoolean(), raf.readChar(),raf.readBoolean());
    }

    long amountOfCars() throws IOException {
        return raf.length()/carSize;
    }

    void amountOfActiveCars(CarFile carFile) throws IOException {
        Car car;
        int amountActive =0;
        start();
        try {
            long cant = carFile.amountOfCars();
            for (long i = 0; i < cant ; i++){
                car = carFile.read();
                if (car.isActive())
                    amountActive++;
            }
            System.out.println("Amount of cars: " + amountActive+"\n");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    void amountOfFull(CarFile carFile) throws IOException {
        Car car;
        start();
        int amountFull =0;
        try {
            long cant = carFile.amountOfCars();
            for (long i = 0; i < cant ; i++){
                car = carFile.read();
                if (car.isActive() && car.isFull())
                    amountFull++;
            }
            System.out.println("Amount of full cars: " + amountFull+"\n");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    void amountOfBase(CarFile carFile) throws IOException {
        Car car;
        start();
        int amountBase =0;
        try {
            long cant = carFile.amountOfCars();
            for (long i = 0; i < cant ; i++){
                car = carFile.read();
                if (car.isActive() && car.isBase())
                    amountBase++;
            }
            System.out.println("Amount of base cars: " + amountBase+"\n");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Car search(int code) throws IOException{
        long cant = amountOfCars();
        start();
        Car car;
        for (int i =0 ; i < cant;i++){
            car = read();
            if(car.isActive() && (car.getCode() == code)){
                return car;
            }
        }
        return new Car();
    }


    void start() throws IOException{
        raf.seek(0);
    }

    public void end() throws IOException{
        raf.seek(raf.length());
    }

    public void goTo(long number) throws IOException{
        raf.seek((number-1)*carSize);
    }

    boolean delete(int code) throws IOException{
        Car car = search(code);
        if (car.getCode()!=0){
            raf.seek(raf.getFilePointer()-carSize);
            car.setActive(false);
            write(car);
            return true;
        }
        else
            return false;
    }

    //Este tendria que ir en menu
    boolean modify(int code) throws IOException{
        Car car = search(code);
        if (car.getCode()!=0){
            raf.seek(raf.getFilePointer()-carSize);
            System.out.println("Enter 1 to modify code, 2 to modify price, 3 to modify type or 4 to change availability: ");
            int option = Integer.parseInt(reader.nextLine());
            if (option == 1){
                System.out.println("Enter new code: ");
                int newCode = Integer.parseInt(reader.nextLine());
                car.setCode(newCode);
            }else if (option == 2){
                System.out.println("Enter new price: ");
                int newprice = Integer.parseInt(reader.nextLine());
                car.setPrice(newprice);
            }else if (option == 3){
                System.out.println("Enter new type('F' for full or 'B' for Base): ");
                char newType = reader.nextLine().charAt(0);
                car.setType(newType);
            }else if (option == 4) {
                System.out.println("Enter 1 for change to available or 2 for change to not available: ");
                int newOption = Integer.parseInt(reader.nextLine());
                if (newOption == 1){
                    car.setAvailable(true);
                }else if (newOption == 2){
                    car.setAvailable(false);
                }else{
                    System.out.println("Invalid option \n");
                }
            }else {
                System.out.println("Wrong option"+"\n");
            }
            write(car);
            return true;
        }
        else
            return false;
    }


    void printEveryCar() throws IOException {
        long cant = amountOfCars();
        start();
        Car car;
        for (int i =0 ; i < cant;i++){
            car = read();
            if(car.isActive()){
                System.out.println(car.toString()+"\n");
            }
        }
    }

    void printEveryFullCar() throws IOException {
        long cant = amountOfCars();
        start();
        Car car;
        for (int i =0 ; i < cant;i++){
            car = read();
            if (car.isActive() && car.isFull()) {
                System.out.println(car.toString()+"\n");
            }
        }
    }

    void printEveryBaseCar() throws IOException {
        long cant = amountOfCars();
        start();
        Car car;
        for (int i =0 ; i < cant;i++){
            car = read();
            if (car.isActive() && car.isBase()) {
                System.out.println(car.toString()+"\n");
            }
        }
    }

}
