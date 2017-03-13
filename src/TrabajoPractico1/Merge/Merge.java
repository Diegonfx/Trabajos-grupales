package TrabajoPractico1.Merge;

/**
 * Created by DiegoMancini on 10/3/17.
 */
public class Merge {

    // size of C array must be equal or greater than
    // sum of A and B arrays' sizes

    public int[] merge(int[] arrayA, int[] arrayB){
        int a = 0, b = 0, c = 0;
        int[] arrayC = new int[arrayA.length + arrayB.length];
        while(a < arrayA.length && b < arrayB.length){
            if (arrayA[a] < arrayB[b]){
                arrayC[c] = arrayA[a];
                a++;
            } else{
                arrayC[c] = arrayB[b];
                b++;
            }
            c++;
        }
        while (a < arrayA.length)
        {
            arrayC[c] = arrayA[a];
            a++;
            c++;
        }

        while (b < arrayB.length)
        {
            arrayC[c] = arrayB[b];
            b++;
            c++;
        }


        return arrayC;
    }

}
