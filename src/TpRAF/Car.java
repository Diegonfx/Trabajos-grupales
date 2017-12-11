package TpRAF;

/**
 * Created by Diego Mancini on 12/10/17.
 * Materia: AyED.
 */
public class Car {
        private int code;
        private double price;
        private boolean available;
        private char type;
        private boolean active;

    Car(int codigo, double precio, char tipo) {
        this.code = codigo;
        this.price = precio;
        this.type = tipo;
        available = true;
        active = true;
    }

    Car(int code, double price, boolean available, char type, boolean active) {
        this.code = code;
        this.price = price;
        this.type = type;
        this.available = available;
        this.active = active;
    }

    Car(){
        code = 0;
        price = 0;
        available = false;
        type = 'N';
        active = false;
    }

    void setCode(int code) {
        this.code = code;
    }

    void setPrice(double price) {
        this.price = price;
    }

    void setAvailable(boolean available) {
        this.available = available;
    }

    public void setType(char type) {
        this.type = type;
    }

    void setActive(boolean active) {
        this.active = active;
    }

    int getCode() {
        return code;
    }

    double getPrice() {
        return price;
    }

    boolean isAvailable() {
        return available;
    }

    public char getType() {
        return type;
    }

    boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "-----\nCar: \n" +
                "Code: " + code +
                "\nPrice: " + price +
                "\nAvailable:" + available +
                "\nType:" + type +
                "\nActive:" + active +
                "\n------"+"\n";
    }

    boolean isFull(){
        return type == 'F' || type == 'f';
    }

    boolean isBase(){
        return type == 'B' || type == 'b';
    }

}
