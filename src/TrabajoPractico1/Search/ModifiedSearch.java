package TrabajoPractico1.Search;

/**
 * Created by Tomas on 13/3/2017.
 */
public class ModifiedSearch <T extends Comparable<T>> {

    public int secuentialSearch(T k, T[] list){

        for (int i = 0; i < list.length; i++){
            if (list[i] == k)
                return i;
            throw new RuntimeException("El elemento no pertenece a este arreglo.");
        }
        return -1;
    }

    private int binarySearch(T k, T[] list, int first, int last){
        if (first > last) {
            return -1;
        } else {
            int middle = (first + last)/2;
            int tempResult = k.compareTo(list[middle]);
            if (tempResult == 0) {
                return middle;
            } else if (tempResult < 0) {
                return binarySearch(k , list , first , middle-1);
            } else {
                return binarySearch(k , list , middle+1 , last);
            }
        }
    }

    public int binarySearch(T k, T[] list){
        return binarySearch(k, list, 0, list.length - 1);
    }

}
