package TrabajoPractico1.Search;

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

        Search search = new Search();
        ModifiedSearch modifiedSearch = new ModifiedSearch();
        System.out.println("Pre ordenamiento");
        for (int i = 0 ; i < arregloATestear.length ; i++) {
            System.out.println("Position: " + i + " |||| Value: --> " + arregloATestear[i]);
        }
        System.out.println("-------------------------------------------");
//      sort."TIPO DE SEARCH DESEADO"(arregloATestear);
        System.out.println("Post ordenamiento");
        for (int i = 0 ; i < arregloATestear.length ; i++) {
            System.out.println("Position: " + i + " ||  Value: --> " + arregloATestear[i]);
        }
    }

}
