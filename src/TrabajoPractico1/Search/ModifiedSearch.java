package TrabajoPractico1.Search;

/**
 * Created by Tomas on 13/3/2017.
 */
public class ModifiedSearch {

    public int modifSecuencialSearch(int k, int[] list){

        for (int i = 0; i < list.length; i++){
            if (list[i] == k)
                return i;
            throw new RuntimeException("El elemento no pertenece a este arreglo.");
        }
        return -1;
    }

    private int modifBinarySearch(int k, int[] list, int first, int last){
        if (first > last)
            return -1;
        int middle = (first + last)/2;
        int i = list[middle];
        if (k > list[last] || k < list[first])
            throw new RuntimeException("El elemento no pertenece a este arreglo.");
        if (k == i)
            return middle;
        if (k < i)
            return modifBinarySearch(k, list, first, middle - 1);
        else
            return modifBinarySearch(k, list, middle + 1, list.length - 1);

    }

    public int modifBinarySearch(int k, int[] list){
        return modifBinarySearch(k, list, 0, list.length - 1);
    }
}
