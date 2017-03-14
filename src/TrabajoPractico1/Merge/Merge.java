package TrabajoPractico1.Merge;

/**
 * Created by DiegoMancini on 10/3/17.
 */
public class Merge <T extends Comparable<T>> {

    public Comparable[] merge(T[] arrayA, T[] arrayB){
        int a = 0, b = 0, c = 0;
        Comparable[] arrayC = new Comparable[arrayA.length + arrayB.length];
        while(a < arrayA.length && b < arrayB.length){
            if (arrayA[a].compareTo(arrayB[b]) < 0){
                arrayC[c] = arrayA[a];
                a++;
            } else{
                arrayC[c] = arrayB[b];
                b++;
            } c++;
        }
        while (a < arrayA.length) {
            arrayC[c] = arrayA[a];
            a++;
            c++;
        }
        while (b < arrayB.length) {
            arrayC[c] = arrayB[b];
            b++;
            c++;
        }  return arrayC;
    }

}

