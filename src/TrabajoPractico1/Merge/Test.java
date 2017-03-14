package TrabajoPractico1.Merge;

import TrabajoPractico1.Sort.Sort;

/**
 * Created by DiegoMancini on 13/3/17.
 */
public class Test {

    public static void main(String[] args) {
        Integer[] arregloATestear = new Integer[15];

        arregloATestear[0] = 1 ;
        arregloATestear[1] = 21 ;
        arregloATestear[2] = 3 ;
        arregloATestear[3] = 16 ;
        arregloATestear[4] = 5 ;
        arregloATestear[5] = 31;
        arregloATestear[6] = 12;
        arregloATestear[7] = 8 ;
        arregloATestear[8] = 51;
        arregloATestear[9] = 10 ;
        arregloATestear[10] = 11 ;
        arregloATestear[11] = 2 ;
        arregloATestear[12] = 13 ;
        arregloATestear[13] = 823 ;
        arregloATestear[14] = 3 ;

        Integer[] arregloTestear = new Integer[15];

        arregloTestear[0] = 9;
        arregloTestear[1] = 15;
        arregloTestear[2] = 7;
        arregloTestear[3] = 29;
        arregloTestear[4] = 32;
        arregloTestear[5] = 42;
        arregloTestear[6] = 51;
        arregloTestear[7] = 28;
        arregloTestear[8] = 95;
        arregloTestear[9] = 75;
        arregloTestear[10] = 19;
        arregloTestear[11] = 58;
        arregloTestear[12] = 36;
        arregloTestear[13] = 23;
        arregloTestear[14] = 142;

        Merge merge = new Merge();
        System.out.println("Pre ordenamiento");
        for (int i = 0 ; i < arregloATestear.length ; i++) {
            System.out.println("Position: " + i + " |||| Value: --> " + arregloATestear[i]);
        }
        System.out.println("-------------------------------------------");
        for (int i = 0 ; i < arregloTestear.length ; i++) {
            System.out.println("Position: " + i + " |||| Value: --> " + arregloTestear[i]);
        }
        System.out.println("-------------------------------------------");
        System.out.println("-------------------------------------------");
        Sort sort = new Sort();
        sort.selectionSort(arregloATestear);
        sort.selectionSort(arregloTestear);
        Comparable<Integer>[] array = merge.merge(arregloATestear, arregloTestear);
        System.out.println("Post ordenamiento");
        for (int i = 0 ; i < array.length ; i++) {
            System.out.println("Position: " + i + " ||  Value: --> " + array[i]);
        }
    }

}
