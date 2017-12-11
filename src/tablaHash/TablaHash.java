package tablaHash;

import TP_Lists.Listas.DynamicList;

/**
 * Created by Tomás Iturralde on 12/08/17.
 * Materia: .
 */
public class TablaHash {
    private DynamicList<String>[] hashTable;

    @SuppressWarnings("unchecked")
    TablaHash(){
        hashTable = new DynamicList[27000];
        int m = 27000;
        for (int i = 0; i < m; i++) {
            hashTable[i] = new DynamicList<>();
        }
    }

    public void insert(String word){
        String aux = soundex(word);
        int key = hashFunction(aux);

        if(hashTable[key].isVoid()){
            hashTable[key].insertNext(word);
        }
        else {
            hashTable[key].goTo(hashTable[key].size() - 1);
            hashTable[key].insertNext(word);
        }
    }

    void getSimilar(String word){
        String aux = soundex(word);
        int key = hashFunction(aux);

        if(hashTable[key].size() > 0){
            for (int i = 0; i < hashTable[key].size() ; i++) {
                hashTable[key].goTo(i);
                System.out.println(hashTable[key].getActual());
            }
        } else {
            System.out.println("There are no similar words in the dictionary");
        }

    }

    public DynamicList<String> getSimilarSwing(String word){
        String aux = soundex(word);
        int key = hashFunction(aux);

        DynamicList<String> similarWords = new DynamicList<>();

        for (int i = 0; i < hashTable[key].size() ; i++) {
            hashTable[key].goTo(i);
            similarWords.insertNext(hashTable[key].getActual());
        }
        return similarWords;
    }

    private static int hashFunction(String soundexResult){
        String result = "";
        char aux = soundexResult.charAt(0);
        result += (int)aux - 65;
        result += soundexResult.substring(1,4);
        return Integer.parseInt(result);
    }

    private static String soundex(String s) {
        char[] x = s.toUpperCase().toCharArray();
        char firstLetter = x[0];

        // convert letters to numeric code
        for (int i = 0; i < x.length; i++) {
            switch (x[i]) {

                case 'B':
                case 'F':
                case 'P':
                case 'V':
                    x[i] = '1';
                    break;

                case 'C':
                case 'G':
                case 'J':
                case 'K':
                case 'Q':
                case 'S':
                case 'X':
                case 'Z':
                    x[i] = '2';
                    break;

                case 'D':
                case 'T':
                    x[i] = '3';
                    break;

                case 'L':
                    x[i] = '4';
                    break;

                case 'M':
                case 'N':
                    x[i] = '5';
                    break;

                case 'R':
                    x[i] = '6';
                    break;

                default:
                    x[i] = '0';
                    break;
            }
        }

        // remove duplicates
        String output = "" + firstLetter;
        for (int i = 1; i < x.length; i++)
            if (x[i] != x[i-1] && x[i] != '0')
                output += x[i];

        // pad with 0's or truncate
        output = output + "0000";
        return output.substring(0, 4);
    }
}
