package arbolRB;

import Arbol234.Node;

/**
 * Created by Tomas on 29/5/2017.
 */
public class TreeRB<T> {

    private static final int BLACK = 1;
    private static final int RED = 0;
    private RBNode root;
    private RBNode current;

    public TreeRB(){
        root = new RBNode<>();
        current = root;
    }

    public void insert(T element) {
        RBNode nodeToAdd = new RBNode();
        insert(nodeToAdd);
    }

    private void insert(RBNode nodeToAdd) {
        if (isEmpty()) {
            root = nodeToAdd;
            nodeToAdd.setBlack();
        } else {
            RBNode father = search(nodeToAdd);
            if (father.getColor() == 1) {
                father.setChild(father , nodeToAdd);
                nodeToAdd.setParent(father);
            } else if (father.getColor() != 0 && father.uncleIsBlack() && nodeToAdd.isExteriorChild()) {
                father.setChild(father , nodeToAdd);
                nodeToAdd.setParent(father);
                simpleRotation(nodeToAdd);
            } else if (father.getColor() != 1 && father.uncleIsBlack() && !nodeToAdd.isExteriorChild()) {
                father.setChild(father , nodeToAdd);
                nodeToAdd.setParent(father);
                doubleRotation(nodeToAdd);
            } else {
                father.setChild(father , nodeToAdd);
                case4(nodeToAdd);
            }
            root.setBlack();
        }
    }

    private RBNode search(RBNode nodeToCompare, RBNode nodeToAdd) {
        if (nodeToAdd.getElem().compareTo(nodeToCompare.getElem()) == 0) {
            return nodeToCompare;
        } else if (nodeToAdd.getElem().compareTo(nodeToCompare.getElem()) < 0) {
            if (nodeToCompare.getLeft() == null) {
                return nodeToCompare;
            } else {
                return search(nodeToCompare.getLeft() , nodeToAdd);
            }
        } else if (nodeToAdd.getElem() == null) {
            return nodeToAdd.getParent();
        } else {
            if (nodeToCompare.getRight() == null) {
                return nodeToCompare;
            } else {
                return search(nodeToCompare.getRight() , nodeToAdd);
            }
        }
    }

    private void simpleRotation(RBNode nodeToAdd) {
        RBNode father = nodeToAdd.getParent();
        RBNode grandpa = father.getParent();
        RBNode greatGrandpa = grandpa.getParent();

        if (grandpa.getElem() == root.getElem()) {
            root = father;
            father.setChild(father , grandpa);
            if (grandpa.getRight().getElem() == father.getElem()) {
                grandpa.setToNull(grandpa.getLeft());
            } else {
                grandpa.setToNull(grandpa.getRight());
            }
            grandpa.setParent(father);
            father.setParent(null);
        }
    }

    private void doubleRotation(RBNode nodeToAdd) {

    }

    private void case4(RBNode nodeToAdd) {
        nodeToAdd.getParent().setBlack(); //FATHER
        nodeToAdd.getParent().getUncle().setBlack(); //FATHER'S BROTHER
        nodeToAdd.getParent().getParent().setBlack();//GRANDPA
        insert(nodeToAdd.getParent().getParent());
    }

    private boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }


}
