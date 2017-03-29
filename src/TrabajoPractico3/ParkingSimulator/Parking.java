package TrabajoPractico3.ParkingSimulator;

/**
 * This Class simulates a parking, which can only store one car next to the other.
 * @author Tomas Iturralde
 * @author Diego Mancini
 */
public class Parking {
    private int income;
    private int top;
    private Car[] parking;

    public Parking(){
        income = 0;
        top = -1;
        parking = new Car[50];
    }

    public int getIncome() {
        return income;
    }

    public int getTop() {
        return top;
    }

    public Car[] getParking() {
        return parking;
    }

    /**
     * Parks a car at the first spot available. If the parking is full an exception will be thrown.
     * @param car to be parked at the first spot possible.
     */
    public void parkCar(Car car){
        if (top == parking.length)
            throw new RuntimeException("The parking is full.");
        parking[++top] = car;
        income += 5;
    }

    /**
     * removes the last car which was parked.
     */
    public void popCar(){
        parking[top] = null;
        top--;
    }

    /**
     * Removes a car in a specific position, but it needs to park every car before it in the street. After the car is removed,
     * every car in the street is parked again inside.
     * @param index position of the car to be removed.
     */
    public void removeCar(int index){
        Parking street = new Parking();
        for (int i = top; i > index; i--){
            street.parkCar(parking[i]);
            popCar();
        }
        popCar();

        for (int i = street.getTop(); i >= 0; i--){
           parkCar(street.getParking()[i]);
           street.popCar();
        }
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public Car peek(){
        if (!isEmpty())
            return parking[top];
        return null;
    }

    /**
     *
     * @return the amount of money was gained in a day.
     */
    public String totalDailyIncome(){
        return "Today's income was: " + income;
    }
}
