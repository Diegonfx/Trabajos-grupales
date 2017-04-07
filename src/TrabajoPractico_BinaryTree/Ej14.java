package TrabajoPractico_BinaryTree;

/**
 * Created by Tomas on 6/4/2017.
 */
public class Ej14 {

    public int summation(BinaryTree<Integer> a){
        if (a.isEmpty())
            return 0;
        return a.getRoot() + summation(a.getLeft()) + summation(a.getRight());
    }

    public int summationOf3(BinaryTree<Integer> a){
        if (a.isEmpty())
            return 0;
        if ((a.getRoot() % 3) != 0)
            return 0;
        return a.getRoot() + summationOf3(a.getLeft()) + summationOf3(a.getRight());
    }
}
