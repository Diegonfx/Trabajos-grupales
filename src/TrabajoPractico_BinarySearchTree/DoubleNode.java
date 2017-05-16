package TrabajoPractico_BinarySearchTree;

import java.io.Serializable;

public class DoubleNode<Q> implements Serializable{

    Q elem;
    DoubleNode<Q> right, left;

    public DoubleNode() {
        this(null , null , null);
    }
    public DoubleNode(Q o){
        elem = o;
    }
    public DoubleNode(Q o, DoubleNode<Q> left, DoubleNode<Q> right){
        elem = o;
        this.right = right;
        this.left = left;
    }

    public static <T> int size(DoubleNode<T> root) {
        if (root == null) {
            return 0;
        } else {
            return 1+size(root.left) + size(root.right);
        }
    }
    public static <T> int height(DoubleNode<T> root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(height(root.left) , height(root.right));
        }
    }

    public Q getElem() {
        return elem;
    }
    public void setElem(Q elem) {
        this.elem = elem;
    }
    public DoubleNode<Q> getRight() {
        return right;
    }
    public void setRight(DoubleNode<Q> right) {
        this.right = right;
    }
    public DoubleNode<Q> getLeft() {
        return left;
    }
    public void setLeft(DoubleNode<Q> left) {
        this.left = left;
    }

    public <Q> void inOrden(){
        if (left!=null) {
            left.inOrden();
        }
        System.out.println(elem);
        if (right!=null) {
            right.inOrden();
        }
    }
    public <Q> void preOrden (){
        System.out.print(elem);
        if (left != null) {
            left.preOrden();
        }
        if (right != null) {
            right.preOrden();
        }
    }
    public <Q> void postOrden (){
        if (left!= null) {
            left.postOrden();
        }
        if (right!= null) {
            right.postOrden();
        }
        System.out.print(elem);
    }

    /**
     * @return a reference to a node that is the root of a duplicate of the binary tree, whose root is in the actual node
     */
    public DoubleNode<Q> duplicate() {
        DoubleNode<Q> root = new DoubleNode<Q>(elem , null , null) ;
        if (left != null) {                  // Si hay un subarbol izquierdo
            root.left = left.duplicate();    // Duplicar; asociar
        }
        if (right != null) {                 // Si hay un subarbol derecho
            root.right = right.duplicate();  // Duplicar; asociar
        }
        return root;                         // Devolver arbol resultante
    }
}
