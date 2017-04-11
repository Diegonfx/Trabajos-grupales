package TrabajoPractico_BinaryTree;

import java.util.ArrayList;

/**
 * Created by Tomas on 10/4/2017.
 */
public class Tester {
    public static void main(String[] args){

        Ej13 ej13 = new Ej13();
        Ej14 ej14 = new Ej14();
        TP04_Methods api = new TP04_Methods();
        BinaryTree<Integer> tree6 = new BinaryTree<>(6);
        BinaryTree<Integer> tree5 = new BinaryTree<>(5);
        BinaryTree<Integer> tree4 = new BinaryTree<>(4);
        BinaryTree<Integer> tree3 = new BinaryTree<>(3);
        BinaryTree<Integer> tree2 = new BinaryTree<>(2,tree5,tree6);
        BinaryTree<Integer> tree1 = new BinaryTree<>(1,tree3,tree4);
        BinaryTree<Integer> root = new BinaryTree<>(0,tree1,tree2);

        BinaryTree<Integer> tree62 = new BinaryTree<>(4);
        BinaryTree<Integer> tree52 = new BinaryTree<>(2);
        BinaryTree<Integer> tree42 = new BinaryTree<>(6);
        BinaryTree<Integer> tree32 = new BinaryTree<>(3);
        BinaryTree<Integer> tree22 = new BinaryTree<>(5,tree52,tree62);
        BinaryTree<Integer> tree12 = new BinaryTree<>(1,tree32,tree42);
        BinaryTree<Integer> root2 = new BinaryTree<>(0,tree12,tree22);

        ArrayList<BinaryTree<Integer>> list = new ArrayList<>();
        list.add(root);
        System.out.println("Representacion del arbol: " + "\n    0" + "\n  1   2" + "\n 3 4 5 6");
        System.out.println("Recorrido preorden: ");
        api.preOrden(root);
        System.out.println("\n");
        System.out.println("Recorrido inorden: ");
        api.inOrden(root);
        System.out.println("\n");
        System.out.println("Recorrido postorden: ");
        api.postOrden(root);
        System.out.println("\n");
        System.out.println("Recorrido por nivel: ");
        api.byLevel(root);
        System.out.println("\n");

        api.serializeBinary(root,"C:\\Users\\Tomas\\Documents\\prueba arbol.txt");
        System.out.println("Para comprobar la serializacion, deserializamos el arbol y lo comparamos con el mismo: ");
        System.out.println(ej14.equalTrees(api.deserializeBinary("C:\\Users\\Tomas\\Documents\\prueba arbol.txt"),root));

        System.out.println("Es semejante al arbol 2? " + ej14.similarTrees(root, root2));
        System.out.println("Es isomorfo al arbol 2? " + ej14.isomorphicTrees(root,root2));

        System.out.println("Numero de Hojas: " + ej13.leaves(root));
        System.out.println("Cantidad de elementos en nivel 1: " + ej13.numberOfElementsAtLevel(root,1));
        System.out.println("Numero de ocurrencias de 0: " + ej13.ocurrencias(root,1));
        System.out.println("Altura del arbol: " + ej13.height(root));
        System.out.println("Suma de elementos del arbol: " + ej14.summation(root));
        System.out.println("El arbol es completo? " + ej14.treeIsComplete(root));
        System.out.println("El arbol es estable? " + ej14.treeIsStable(root));
        System.out.println("El arbol esta lleno? " + ej14.treeIsFull(root));
        ej14.showFrontier(root);
        System.out.print("Elementos de la frontera: ");
        ArrayList<Integer> myList = ej14.frontier(root);
        for (Integer i : myList) {
            System.out.print(i + " ");
        }

    }
}
