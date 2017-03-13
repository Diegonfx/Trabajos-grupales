package TrabajoPractico1.Sort;

/**
 * Created by Tomas on 13/3/2017.
 */
public class ModifiedSort {
    public void selectionSort(double[] arr) {
        selectionSort(arr, 0);
    }


    private void selectionSort(double[] arr, int index) {
        if (index < arr.length - 1) {
            int smallestIndex = index;
            for (int i = index + 1; i < arr.length; i++) {
                if (arr[i] < arr[smallestIndex]) {
                    smallestIndex = i;
                }
            }

            double t = arr[index];
            arr[index] = arr[smallestIndex];
            arr[smallestIndex] = t;
            selectionSort(arr, index + 1);
        }
    }
}
