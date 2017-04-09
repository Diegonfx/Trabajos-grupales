package TrabajoPractico_BinaryTree;

import java.util.ArrayList;
import java.util.Random;

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
        return sameElements(a,b) && sameStructure(a,b);
    }

    public boolean similarTrees(BinaryTree a , BinaryTree b) {
        return sameElements(a,b) && !sameStructure(a,b);
    }

    public boolean isomorphicTrees(BinaryTree a, BinaryTree b){
        return !sameElements(a,b) && sameStructure(a,b);
    }

    public boolean treeIsComplete(BinaryTree a){

    }

    public boolean treeIsFull(BinaryTree a){
        if (!a.isEmpty()) {
            if(a.getRight().isEmpty() && a.getLeft().isEmpty())
                return true;
            if ((!a.getRight().isEmpty() && !a.getLeft().isEmpty()))
                return treeIsFull(a.getLeft())&& treeIsFull(a.getLeft());
        }
        return false;
    }

    public boolean treeIsStable(BinaryTree<Integer> a){
        if (a.isEmpty())
            return true;
        if (a.getLeft().isEmpty() && a.getRight().isEmpty())
            return true;
        if (a.getRootElement() < a.getLeft().getRootElement() || a.getRootElement() < a.getRight().getRootElement())
            return false;
        return treeIsStable(a.getLeft()) && treeIsStable(a.getRight());
    }

    public void showFrontier(BinaryTree a){
        if (!isALeaf(a))
            System.out.println("Empty");
        System.out.println("Hoja con el elemento: " + a.getRootElement());

    }

    private boolean isALeaf(BinaryTree a){
        if (a.isEmpty())
            return true;
        if (a.getLeft().isEmpty() && a.getRight().isEmpty())
            return true;
        return isALeaf(a.getLeft()) && isALeaf(a.getRight());
    }

    public <T> ArrayList<T> frontier(BinaryTree<T> a){
        ArrayList frontier = new ArrayList();
        if (isALeaf(a))
            frontier.add(a.getRootElement());
        return frontier;
    }

    /**
     * Private method that checks if two trees have the same values at the same positions.
     * @param a first tree.
     * @param b second tree.
     * @return true if both trees have the same values, false if otherwise.
     */
    private boolean sameElements(BinaryTree a, BinaryTree b){
        if (a.isEmpty() && b.isEmpty())
            return true;
        if (a.getRootElement() != b.getRootElement())
            return false;
        return (sameElements(a.getLeft(), b.getLeft()) && sameElements(a.getRight(), b.getRight()));
    }

    /**
     * Private method that checks if two trees have the same structure.
     * @param a first tree.
     * @param b second tree.
     * @return true if both trees have the same structure, false if otherwise.
     */
    private boolean sameStructure(BinaryTree a, BinaryTree b){
        if (a.isEmpty() && b.isEmpty())
            return true;
        if (a.isEmpty() || b.isEmpty())
            return false;
        return (sameStructure(a.getLeft(), b.getLeft()) && sameStructure(a.getRight(), b.getRight()));
    }
}
