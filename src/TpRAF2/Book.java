package TpRAF2;

/**
 * Created by Diego Mancini on 10/12/17.
 * Materia: AyED.
 */
public class Book {
        private int bookCode;
        private double price;
        private boolean available;
        private char bookType;
        private boolean active;

    Book(int bookCode, double price, char bookType) {
        this.bookCode = bookCode;
        this.price = price;
        this.bookType = bookType;
        available = true;
        active = true;
    }

    Book(int bookCode, double price, boolean available, char bookType, boolean active) {
        this.bookCode = bookCode;
        this.price = price;
        this.bookType = bookType;
        this.available = available;
        this.active = active;
    }

    Book(){
        bookCode = 0;
        price = 0;
        available = false;
        bookType = 'X';
        active = false;
    }

    void setBookCode(int bookCode) {
        this.bookCode = bookCode;
    }

    void setPrice(double price) {
        this.price = price;
    }

    void setAvailable(boolean available) {
        this.available = available;
    }

    void setBookType(char bookType) {
        this.bookType = bookType;
    }

    @SuppressWarnings("all")
    void setActive(boolean active) {
        this.active = active;
    }

    int getBookCode() {
        return bookCode;
    }

    double getPrice() {
        return price;
    }

    boolean isAvailable() {
        return available;
    }

    char getBookType() {
        return bookType;
    }

    boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "-----\nBook: \n" +
                "Code: " + bookCode +
                "\nPrice: " + price +
                "\nAvailable:" + available +
                "\nType:" + bookType +
                "\nActive:" + active +
                "\n------"+"\n";
    }

    boolean isNovel(){
        return bookType == 'N' || bookType == 'n';
    }

    boolean isComic(){
        return bookType == 'C' || bookType == 'c';
    }

    boolean isForKids() {
        return bookType == 'K' || bookType == 'k';
    }
}
