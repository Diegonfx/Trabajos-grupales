package TrabajoPractico3;

/**
 * This Class simulates a parking, which can only store one car next to the other.
 */
public class ParkingSimulator {
    private int income;
    private int top;
    private String[] parking;

    public ParkingSimulator(){
        income = 0;
        top = 0;
        parking = new String[50];
    }

    public int getIncome() {
        return income;
    }

    public int getTop() {
        return top;
    }

    public String[] getParking() {
        return parking;
    }

    /**
     * Parks a car at the first spot available. If the parking is full an exception will be thrown.
     * @param car to be parked at the first spot possible.
     */
    public void parkCar(String car){
        if (top == parking.length)
            throw new RuntimeException("The parking is full.");
        parking[top] = car;
        top++;
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
        ParkingSimulator street = new ParkingSimulator();
        for (int i = top; i > index; i--){
            street.parkCar(parking[i]);
            popCar();
        }
        parking[index] = null;
        top--;

        for (int i = street.getTop(); i >= 0; i--){
           parkCar(street.getParking()[i]);
           street.popCar();
        }
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public String peek(){
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
