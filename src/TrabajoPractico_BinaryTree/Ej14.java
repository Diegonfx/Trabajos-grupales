package TrabajoPractico_BinaryTree;

import java.util.ArrayList;

/**
 * Created by Tomas on 6/4/2017.
 */
public class Ej14 {
    Ej13 ej13_Methods = new Ej13();

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
        if (a.isEmpty()) return true;
        return (ej13_Methods.height(a.getLeft()) == ej13_Methods.height(a.getRight()) && treeIsComplete(a.getLeft()) && treeIsComplete(a.getRight()));
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

    public boolean occursBinaryTree(BinaryTree a , BinaryTree b) {
        boolean result = false;
        if (equalTrees(a, b)) {
            result = true;
        }
        if (!a.getLeft().isEmpty() && !b.getRight().isEmpty()) {
            if ((occursBinaryTree(a.getLeft(), b) || occursBinaryTree(a.getRight(), b))) {
                result = true;
            } else {
                result = false;
            }
        } return result;
    }

    public void showFrontier(BinaryTree a){
        if(!a.isEmpty()){
            if(a.getLeft().isEmpty() && a.getRight().isEmpty()){
                System.out.println("Elemento de la frontera: " + a.getRootElement());
            }
            showFrontier(a.getLeft());
            showFrontier(a.getRight());
        }
    }

    private boolean isALeaf(BinaryTree a) {
        return a.getLeft().isEmpty() && a.getRight().isEmpty();
    }

    private void frontier(BinaryTree a, ArrayList frontier){
        if(!a.isEmpty()){
            if(a.getLeft().isEmpty() && a.getRight().isEmpty()){
                frontier.add(a.getRootElement());
            }
            frontier(a.getLeft(), frontier);
            frontier(a.getRight(), frontier);
        }
    }

    public ArrayList frontier(BinaryTree a){
        ArrayList frontier = new ArrayList();
        frontier(a,frontier);
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
