package tablaHash;

/**
 * Created by Diego Mancini on 08/12/17.
 * Materia: AyED.
 */
public class Main {
    private static TablaHash dictionary = new TablaHash();
    public static void main(String[] args) {
        dictionary.insert("Beer");
        dictionary.insert("Bearer");

        int choice = 0;
        while (choice != 3){
            choice = Scanner.getInt(" 1. Add a word \n 2. Get similar words \n 3. Exit \n Choose an option: ");
            switch (choice){
                case 1:
                    addWord();
                    break;
                case 2:
                    getSimilarWords();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Please enter a valid operation.");
            }
        }

    }

    private static void addWord(){
        String newWord = Scanner.getString("Enter the word to add: ");
        dictionary.insert(newWord);
    }

    private static void getSimilarWords(){
        String word = Scanner.getString("Enter word: ");
        dictionary.getSimilar(word);
    }

}
