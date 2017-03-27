package TrabajoPractico3.LexicographicAnalyzer.Exercise;

import java.io.IOException;

/**
 * Created by DiegoMancini on 25/3/17.
 */
public class LATester {

    public static void main(String[] args) {
        LexicographicAnalyzer analyzer = new LexicographicAnalyzer();
        try {
            analyzer.analizeText("src\\TrabajoPractico3\\LexicographicAnalyzer\\Exercise\\prueba.txt");
        }catch (IOException e){

        }
        System.out.println(analyzer.countErrors());
    }

}
