package Mancini_ParcialAlicia;

/**
 * Implemetation of a Double Node.
 * @author Tomas Iturralde
 * @author Diego Mancini
 */
public class DoubleNodeSearchTree<Q> {
    Q elem;
    DoubleNodeSearchTree<Q> right, left;

    public DoubleNodeSearchTree() {
        this(null , null , null);
    }
    public DoubleNodeSearchTree(Q o){
        elem = o;
    }
    public DoubleNodeSearchTree(Q o, DoubleNodeSearchTree<Q> left, DoubleNodeSearchTree<Q> right){
        elem = o;
        this.right = right;
        this.left = left;
    }

    public static <T> int size(DoubleNodeSearchTree<T> root) {
        if (root == null) {
            return 0;
        } else {
            return 1+size(root.left) + size(root.right);
        }
    }
    public static <T> int height(DoubleNodeSearchTree<T> root) {
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
    public DoubleNodeSearchTree<Q> getRight() {
        return right;
    }
    public void setRight(DoubleNodeSearchTree<Q> right) {
        this.right = right;
    }
    public DoubleNodeSearchTree<Q> getLeft() {
        return left;
    }
    public void setLeft(DoubleNodeSearchTree<Q> left) {
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
    public DoubleNodeSearchTree<Q> duplicate() {
        DoubleNodeSearchTree<Q> root = new DoubleNodeSearchTree<Q>(elem , null , null) ;
        if (left != null) {                  // Si hay un subarbol izquierdo
            root.left = left.duplicate();    // Duplicar; asociar
        }
        if (right != null) {                 // Si hay un subarbol derecho
            root.right = right.duplicate();  // Duplicar; asociar
        }
        return root;                         // Devolver arbol resultante
    }
}
