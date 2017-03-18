package TrabajoPractico_Distancia;

/**
 * Created by DiegoMancini on 17/3/17.
 */
public class Tester {

    public static void main(String[] args) {
        String name = "marcos";
        String name2 = "marian";

        String word1 = "Marcos";
        String word2 = "Marianito";

        DistanceCalculator distanceCalculator = new DistanceCalculator();

        System.out.println(distanceCalculator.hammingDistance(name , name2));
        System.out.println(distanceCalculator.levenshteinDistance(word1 , word2));
    }

}
