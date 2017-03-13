package TrabajoPractico1.Sort;

import java.util.Random;

/**
 * Created by DiegoMancini on 7/3/17.
 */
public class Sort {

    public <T extends Comparable<T>> void bubbleSort(T[] arr) {
        boolean swapped = true;
        int j = 0;
        T tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i].compareTo(arr[i+1]) < 0) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    public <T extends Comparable<T>> void selectionSort(T[] arr) {
        int i;
        int j;
        int minIndex;
        T tmp;
        int n = arr.length;
        for (i = 0; i < n - 1; i++) {
            minIndex = i;
            for (j = i + 1; j < n; j++)
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            if (minIndex != i) {
                tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }

    public <T extends Comparable<T>> void insertionSort(T[] arr) {
        int i, j;
        T newValue;
        for (i = 1; i < arr.length; i++) {
            newValue = arr[i];
            j = i;
            while (j > 0 && arr[j - 1].compareTo(newValue) > 0) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = newValue;
        }
    }

    public int partition(int[] arr, int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }

        return i;
    }
    public void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
    }

    public  static  void main ( String [] args ){
        int [] array  =  new  int [ Integer . MAX_VALUE / 10 ];
        long startTime  =  System.currentTimeMillis();
        fillWithRandoms ( array );
        long endTime  =  System.currentTimeMillis();
        System.out.println(endTime-startTime + "miliseconds");
        System.out.println((endTime-startTime)/1000 + "seconds");
    }

    public static void fillWithRandoms ( int[] array ){
        Random rand  =  new  Random ();
        for ( int i = 0 ; i < array.length ; i++){
            array [ i ]  = rand.nextInt (); }
    }

}
