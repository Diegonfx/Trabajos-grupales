package TpRAF2;

import java.io.IOException;
import java.util.Scanner;

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

            BookFile bookFile = new BookFile("Library");

            while (option != 6){
                switch(option){
                    case 1:
                        add(bookFile);
                        break;
                    case 2:
                        delete(bookFile);
                        break;
                    case 3:
                        modify(bookFile);
                        break;
                    case 4:
                        consults(bookFile);
                        break;
                    case 5:
                        inform(bookFile);
                        break;
                }
                option = menu();
            }
            bookFile.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private int menu(){
        System.out.println("1. Add book");
        System.out.println("2. Delete book");
        System.out.println("3. Modify book");
        System.out.println("4. Consults");
        System.out.println("5. Informs");
        System.out.println("6. End");
        System.out.println("Option: ");
        String opc = reader.nextLine();
        return Integer.parseInt(opc);
    }

    public void add(BookFile bookFile) throws IOException {
        int code;
        double price;
        char type;
        bookFile.end();

        try {
            System.out.println("Code: ");
            code = Integer.parseInt(reader.nextLine());
            System.out.println("Price: ");
            price = Double.parseDouble(reader.nextLine());
            System.out.println("Type('N' for novel or 'C' for comic): ");
            type = reader.nextLine().charAt(0);
            bookFile.write(new Book(code, price , type));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void delete(BookFile bookFile) {
        try {
            System.out.println("Enter book code: ");
            int code = Integer.parseInt(reader.nextLine());
            if (bookFile.delete(code)) {
                System.out.println("Successfully deleted"+"\n");
            }
            else
                System.out.println("Wrong code"+"\n");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void modify(BookFile bookFile) {
        try {
            System.out.println("Enter book code: ");
            int code = Integer.parseInt(reader.nextLine());
            if (bookFile.modify(code))
                System.out.println("Successfully modified"+"\n");
            else
                System.out.println("Wrong code"+"\n");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void consults(BookFile bookFile) throws IOException {
        System.out.println(" 1. Book data. \n 2. Amount of books. \n " +
                "3. Amount of novels. \n 4. Amount of comics. \n Choose an option:  ");
        int option = Integer.parseInt(reader.nextLine());
        switch (option){
            case 1:
                search(bookFile);
                break;
            case 2:
                getAmount(bookFile);
                break;
            case 3:
                getNovelAmount(bookFile);
                break;
            case 4:
                getComicAmount(bookFile);
                break;
            default:
                System.out.println("Wrong option"+"\n");
                break;
        }
    }

    private void inform(BookFile bookFile) throws IOException {
        System.out.println(" 1. All books data. \n " +
                "2. All novels. \n 3. All comics. \n Choose an option: ");
        int option = Integer.parseInt(reader.nextLine());
        switch (option) {
            case 1:
                bookFile.printEveryBook();
                break;
            case 2:
                bookFile.printEveryNovel();
                break;
            case 3:
                bookFile.printEveryComic();
                break;
            default:
                System.out.println("Wrong option"+"\n");
                break;
        }
    }

    public void search(BookFile bookFile) {
        Book book;
        try {
            System.out.println("Enter book code: ");
            int code = Integer.parseInt(reader.nextLine());
            book = bookFile.search(code);
            if (book.getBookCode() == 0)
                System.out.println("Invalid code"+"\n");
            else
                System.out.println(book.toString()+"\n");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void getAmount(BookFile bookFile) throws IOException {
        bookFile.amountOfActiveBooks(bookFile);
    }

    private static void getNovelAmount(BookFile bookFile) throws IOException {
        bookFile.amountOfNovels(bookFile);
    }

    private static void getComicAmount(BookFile bookFile) throws IOException {
        bookFile.amountOfComics(bookFile);
    }
}
