package TpRAF2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * Created by Diego Mancini on 10/12/17.
 * Materia: AyED.
 */
public class BookFile {
    private File f;
    private RandomAccessFile raf;
    int bookSize = 16;
    private int bytes = 0;
    private Scanner reader ;

    BookFile(String fileName) throws FileNotFoundException {
        f = new File(fileName);
        raf = new RandomAccessFile(f,"rw");
        reader = new Scanner(System.in);
    }

    public void write(Book c) throws IOException {
        raf.writeInt(c.getBookCode());
        raf.writeDouble(c.getPrice());
        raf.writeBoolean(c.isAvailable());
        raf.writeChar(c.getBookType());
        raf.writeBoolean(c.isActive());
        bytes += bookSize;
    }
    public void close() throws IOException {
        raf.close();
    }

    public long length ()throws IOException{
        return raf.length();
    }

    Book read() throws IOException{
        return new Book(raf.readInt(), raf.readDouble(),
                raf.readBoolean(), raf.readChar(),raf.readBoolean());
    }

    long amountOfBooks() throws IOException {
        return raf.length()/ bookSize;
    }

    void amountOfActiveBooks(BookFile bookFile) throws IOException {
        Book book;
        int amountActive = 0;
        start();
        try {
            long cant = bookFile.amountOfBooks();
            for (long i = 0; i < cant ; i++){
                book = bookFile.read();
                if (book.isActive())
                    amountActive++;
            }
            System.out.println("Amount of books: " + amountActive+"\n");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    void amountOfNovels(BookFile bookFile) throws IOException {
        Book book;
        start();
        int novelAmount =0;
        try {
            long cant = bookFile.amountOfBooks();
            for (long i = 0; i < cant ; i++){
                book = bookFile.read();
                if (book.isActive() && book.isNovel())
                    novelAmount++;
            }
            System.out.println("Amount of novels: " + novelAmount+"\n");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    void amountOfComics(BookFile bookFile) throws IOException {
        Book book;
        start();
        int comicAmount =0;
        try {
            long cant = bookFile.amountOfBooks();
            for (long i = 0; i < cant ; i++){
                book = bookFile.read();
                if (book.isActive() && book.isComic())
                    comicAmount++;
            }
            System.out.println("Amount of comics: " + comicAmount+"\n");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Book search(int code) throws IOException{
        long cant = amountOfBooks();
        start();
        Book book;
        for (int i =0 ; i < cant;i++){
            book = read();
            if(book.isActive() && (book.getBookCode() == code)){
                return book;
            }
        }
        return new Book();
    }


    void start() throws IOException{
        raf.seek(0);
    }

    public void end() throws IOException{
        raf.seek(raf.length());
    }

    public void goTo(long number) throws IOException{
        raf.seek((number-1)* bookSize);
    }

    boolean delete(int code) throws IOException{
        Book book = search(code);
        if (book.getBookCode()!=0){
            raf.seek(raf.getFilePointer()- bookSize);
            book.setActive(false);
            write(book);
            return true;
        }
        else
            return false;
    }

    //Este tendria que ir en menu
    boolean modify(int code) throws IOException{
        Book book = search(code);
        if (book.getBookCode()!=0){
            raf.seek(raf.getFilePointer()- bookSize);
            System.out.println("Enter 1 to modify code, 2 to modify price, 3 to modify type or 4 to change availability: ");
            int option = Integer.parseInt(reader.nextLine());
            if (option == 1){
                System.out.println("Enter new code: ");
                int newCode = Integer.parseInt(reader.nextLine());
                book.setBookCode(newCode);
            }else if (option == 2){
                System.out.println("Enter new price: ");
                int newprice = Integer.parseInt(reader.nextLine());
                book.setPrice(newprice);
            }else if (option == 3){
                System.out.println("Enter new type('N' for novel or 'C' for comic): ");
                char newType = reader.nextLine().charAt(0);
                book.setBookType(newType);
            }else if (option == 4) {
                System.out.println("Enter 1 for change to available or 2 for change to not available: ");
                int newOption = Integer.parseInt(reader.nextLine());
                if (newOption == 1){
                    book.setAvailable(true);
                }else if (newOption == 2){
                    book.setAvailable(false);
                }else{
                    System.out.println("Invalid option \n");
                }
            }else {
                System.out.println("Wrong option"+"\n");
            }
            write(book);
            return true;
        }
        else
            return false;
    }


    void printEveryBook() throws IOException {
        long cant = amountOfBooks();
        start();
        Book book;
        for (int i =0 ; i < cant;i++){
            book = read();
            if(book.isActive()){
                System.out.println(book.toString()+"\n");
            }
        }
    }

    void printEveryNovel() throws IOException {
        long cant = amountOfBooks();
        start();
        Book book;
        for (int i =0 ; i < cant;i++){
            book = read();
            if (book.isActive() && book.isNovel()) {
                System.out.println(book.toString()+"\n");
            }
        }
    }

    void printEveryComic() throws IOException {
        long cant = amountOfBooks();
        start();
        Book book;
        for (int i =0 ; i < cant;i++){
            book = read();
            if (book.isActive() && book.isComic()) {
                System.out.println(book.toString()+"\n");
            }
        }
    }

}
