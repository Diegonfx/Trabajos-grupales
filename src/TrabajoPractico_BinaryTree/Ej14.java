package TrabajoPractico_BinaryTree;

/**
 * Created by Tomas on 6/4/2017.
 */
public class Ej14 {

    public int summation(BinaryTree<Integer> a){
        if (a.isEmpty())
            return 0;
        return a.getRootElement() + summation(a.getLeft()) + summation(a.getRight());
    }

    public int summationOf3(BinaryTree<Integer> a){
        if (a.isEmpty())
            return 0;
        if ((a.getRootElement() % 3) != 0)
            return 0;
        return a.getRootElement() + summationOf3(a.getLeft()) + summationOf3(a.getRight());
    }

    public boolean equalTrees(BinaryTree a, BinaryTree b) {
        boolean result = false;
        if (a.isEmpty() && b.isEmpty()) {
            result = true;
        } if (a.isEmpty() || b.isEmpty()) {
            result = false;
        }
        if ( (a.getRoot().equals(b.getRoot())) && equalTrees(a.getLeft() , b.getLeft()) && equalTrees(a.getRight() , b.getRight()) ) {
            result = true;
        } return result;
    }

    public boolean lookAlike(BinaryTree a , BinaryTree b) {
return true;
    }
}
