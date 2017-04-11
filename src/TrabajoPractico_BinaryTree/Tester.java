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

        api.serializeBinary(root,"C:\\Users\\Tomas\\Documents\\prueba arbol.txt");
        System.out.println("Des-serializamos el arbol y lo comparamos consigo mismo, para comprobar que funciona: ");
        System.out.println(ej14.equalTrees(root, api.deserializeBinary("C:\\Users\\Tomas\\Documents\\prueba arbol.txt")));
        System.out.println("Son semejantes el arbol 1 y el arbol 2? " + ej14.similarTrees(root, root2));
        System.out.println("Son isomorfos el arbol 1 y el arbol 2? " + ej14.isomorphicTrees(root,root2));
        System.out.println("Numero de Hojas en el arbol 1: " + ej13.leaves(root));
        System.out.println("Cantidad de elementos en nivel 1: " + ej13.numberOfElementsAtLevel(root,1));
        System.out.println("Numero de ocurrencias de 0 en el arbol 1: " + ej13.ocurrencias(root,0));
        System.out.println("Altura del arbol 1: " + ej13.height(root));
        System.out.println("Suma de elementos del arbol 1: " + ej14.summation(root));
        System.out.println("Suma de elementos multiplos de 3 del arbol 1: " + ej14.summationOf3(root));
        System.out.println("El arbol 1 es completo? " + ej14.treeIsComplete(root));
        System.out.println("El arbol 1 es estable? " + ej14.treeIsStable(root));
        System.out.println("El arbol 1 esta lleno? " + ej14.treeIsFull(root));
        ej14.showFrontier(root);
        System.out.print("Elementos de la frontera: ");
        ArrayList<Integer> myList = ej14.frontier(root);
        for (Integer i : myList) {
            System.out.print(i + " ");
        }

    }
}
