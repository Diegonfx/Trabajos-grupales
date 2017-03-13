package TrabajoPractico1.Sort;

/**
 * Created by Tomas on 13/3/2017.
 */
public class ModifiedSort {

    public <T extends Comparable<T>>  void selectionSort(T[] arr) {
        selectionSort(arr, 0);
    }


    private <T extends Comparable<T>>  void selectionSort(T[] arr, int index) {
        if (index < arr.length - 1) {
            int smallestIndex = index;
            for (int i = index + 1; i < arr.length; i++) {
                if (arr[i].compareTo(arr[smallestIndex]) < 0) {
                    smallestIndex = i;
                }
            }

            T t = arr[index];
            arr[index] = arr[smallestIndex];
            arr[smallestIndex] = t;
            selectionSort(arr, index + 1);
        }
    }
}
