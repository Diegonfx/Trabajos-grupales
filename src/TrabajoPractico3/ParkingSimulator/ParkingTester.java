package TrabajoPractico3.ParkingSimulator;

/**
 * Created by Tomas on 27/3/2017.
 */
public class ParkingTester {
    public static void main(String[] args) {
        Parking parking = new Parking();
        Car unCar0 = new Car("A","b", "c");
        Car unCar1 = new Car("B","b", "c");
        Car unCar2 = new Car("C","b", "c");
        Car unCar3 = new Car("D","b", "c");
        Car unCar4 = new Car("E","b", "c");
        Car unCar5 = new Car("F","b", "c");
        Car unCar6 = new Car("G","b", "c");
        Car unCar7 = new Car("H","b", "c");
        Car unCar8 = new Car("I","b", "c");
        Car unCar9 = new Car("J","b", "c");
        parking.parkCar(unCar0);
        parking.parkCar(unCar1);
        parking.parkCar(unCar2);
        parking.parkCar(unCar3);
        parking.parkCar(unCar4);
        parking.parkCar(unCar5);
        parking.parkCar(unCar6);
        parking.parkCar(unCar7);
        parking.parkCar(unCar8);
        parking.parkCar(unCar9);

        for (int i = 0; i <= parking.getTop() ; i++){
            System.out.println("Position:" + i + ", car parked: " + parking.getParking()[i].getBrand());
        }
        System.out.println("----------------------------");
        parking.removeCar(4);                //Book E should be removed.

        for (int i = 0; i <= parking.getTop() ; i++){
            System.out.println("Position:" + i + ", car parked: " + parking.getParking()[i].getBrand());
        }
    }
}
