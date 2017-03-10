package TrabajoPractico1.Search;

/**
 * Created by DiegoMancini on 7/3/17.
 *
 */
public class Search {

    public static void main(String[] args) {

        int[] arregloATestear = new int[15];

        arregloATestear[0] = 1 ;
        arregloATestear[1] = 2 ;
        arregloATestear[2] = 3 ;
        arregloATestear[3] = 4 ;
        arregloATestear[4] = 5 ;
        arregloATestear[5] = 6 ;
        arregloATestear[6] = 7 ;
        arregloATestear[7] = 8 ;
        arregloATestear[8] = 9 ;
        arregloATestear[9] = 10 ;
        arregloATestear[10] = 11 ;
        arregloATestear[11] = 12 ;
        arregloATestear[12] = 13 ;
        arregloATestear[13] = 14 ;
        arregloATestear[14] = 15 ;

        binarySearch(arregloATestear , 10);

    }

    public static boolean isSecuencial(int[] arrayToSearch , int number) {
        int amountOfComparisons = 0;
        for (int i = 0 ; i < arrayToSearch.length ; i++) {
            amountOfComparisons++;
            if ( (arrayToSearch[i] == number)) {
                System.out.println("Amount of comparisons: " + amountOfComparisons );
                return true;
            }
        } return false;

    }

    public static boolean isBinary(int[] arrayToSearch , int number) {
        int amountOfComparsions = 0;
        int low = 0;
        int high = arrayToSearch.length - 1;

        for (int i = 0 ; i < arrayToSearch.length ; i++) {

            if (arrayToSearch[i] < arrayToSearch[i+1]) {

                while(high >= low) {
                    int middle = (low + high) / 2;
                    if(arrayToSearch[middle] == number) {
                        System.out.println("Amount of comparisons: " + amountOfComparsions);
                        return true;
                    }
                    if(arrayToSearch[middle] < number) {
                        low = middle + 1;
                    }
                    if(arrayToSearch[middle] > number) {
                        high = middle - 1;
                    }
                    amountOfComparsions++;
                } return false;

            } else {
                throw new RuntimeException("Array not sorted");
            }
        } return false;
    }

    private static boolean binarySearch(int[] array, int number, int first, int last){

        if(first > last){ //condicion de corte
            return false;
        }

        int middleIndex = (first + last)/2;

        if(number == array[middleIndex]){
            return true;
        }
        else if(number < array[middleIndex]){
            return binarySearch(array, number, 0, middleIndex-1);
        }
        else{
            return binarySearch(array, number, middleIndex + 1, last);
        }
    }

    public static boolean binarySearch(int[] array, int number){
        return binarySearch(array, number, 0, array.length-1);
    }

}
