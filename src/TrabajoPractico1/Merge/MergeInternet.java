package TrabajoPractico1.Merge;

/**
 * Created by DiegoMancini on 10/3/17.
 */
public class MergeInternet {

    // size of C array must be equal or greater than
    // sum of A and B arrays' sizes

    public void merge(int[] A, int[] B, int[] C) {
        int i, j, k, m, n;
        i = 0;
        j = 0;
        k = 0;
        m = A.length;
        n = B.length;
        while (i < m && j < n) {
            if (A[i] <= B[j]) {
                C[k] = A[i];
                i++;
            } else {
                C[k] = B[j];
                j++;
            }
            k++;
        }
        if (i < m) {
            for (int p = i; p < m; p++) {
                C[k] = A[p];
                k++;
            }
        } else {
            for (int p = j; p < n; p++) {
                C[k] = B[p];
                k++;
            }
        }
    }

}
