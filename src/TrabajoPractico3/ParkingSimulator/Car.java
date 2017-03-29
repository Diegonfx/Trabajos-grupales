package TrabajoPractico3.ParkingSimulator;

/**
 * Creates a car with the following atributes: a license plate, a brand, a color and a model
 * @author Tomas Iturralde
 * @author Diego Mancini
 */
public class Car {
    private String plate;
    private String brand;
    private String model;
    private String color;

    public Car(String brand, String model, String color) {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public String getPlate() {
        return plate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
