package Mancini_ParcialAlicia;

/**
 * Implementation of a Binary Search Tree.
 * @author Tomas Iturralde
 * @author Diego Mancini
 */
public class BinarySearchTree<T> {
    private DoubleNodeSearchTree<T> root;

    public BinarySearchTree(){
        root = null;
    }

    public T getRootElement(){
        return root.elem;
    }

    public void inOrden(){
        if (root.getLeft()!=null) {
            getLeft().inOrden();
        }
        System.out.println(getRootElement());
        if (root.getRight()!=null) {
            getRight().inOrden();
        }
    }

    public boolean isEmpty(){
        return root == null;
    }

    public BinarySearchTree<T> getLeft(){
        BinarySearchTree<T> t = new BinarySearchTree<>();
        t.root = root.left;
        return t;
    }

    public BinarySearchTree<T> getRight(){
        BinarySearchTree<T> t = new BinarySearchTree<>();
        t.root = root.right;
        return t;

    }

    public boolean exists(Comparable x){
        return exists(root, x);
    }

    public T getMin(){
        return getMin(root).elem;
    }

    public T getMax(){
        return getMax(root).elem;
    }

    public T search(Comparable x){
        return search(root, x).elem;
    }

    public void insert(Comparable x){
        root = insert(root, x);
    }

    public void delete(Comparable x){
        root = delete(root, x);
    }

    @SuppressWarnings("unchecked")
    private boolean exists(DoubleNodeSearchTree<T> t, Comparable x) {
        if (t == null)
            return false;
        if (x.compareTo(t.elem) == 0)
            return true;
        else if (x.compareTo( t.elem)< 0)
            return exists(t.left, x);
        else
            return exists(t.right, x);
    }

    private DoubleNodeSearchTree<T> getMin(DoubleNodeSearchTree<T> t){
        if (t.left == null)
            return t;
        else
            return getMin(t.left);
    }

    private DoubleNodeSearchTree<T> getMax(DoubleNodeSearchTree<T> t){
        if (t.right == null)
            return t;
        else
            return getMax(t.right);
    }

    @SuppressWarnings("unchecked")
    private DoubleNodeSearchTree<T> search(DoubleNodeSearchTree<T> t, Comparable x){
        if (x.compareTo(t.elem) == 0)
            return t;
        else if (x.compareTo(t.elem) < 0)
            return search(t.left, x);
        else
            return search(t.right, x);
    }

    @SuppressWarnings("unchecked")
    private DoubleNodeSearchTree<T> insert (DoubleNodeSearchTree<T> t, Comparable x) {
        if (t == null){
            t = new DoubleNodeSearchTree<>();
            t.elem = (T)x;
        }
        else if (x.compareTo(t.elem) < 0)
            t.left = insert(t.left, x);
        else
            t.right = insert(t.right, x);
        return t;
    }

    @SuppressWarnings("unchecked")
    private DoubleNodeSearchTree<T> delete (DoubleNodeSearchTree<T> t, Comparable x) {
        if (x.compareTo(t.elem) < 0)
            t.left = delete(t.left, x);
        else if (x.compareTo(t.elem) > 0)
            t.right = delete(t.right, x);
        else if (t.left != null && t.right != null ) {
            t.elem = getMin(t.right).elem;
            t.right = deleteMin(t.right);
        }
        else if (t.left != null)
            t = t.left;
        else
            t =t.right;
        return t;
    }

    private DoubleNodeSearchTree<T> deleteMin(DoubleNodeSearchTree<T> t){
        if (t.left != null)
            t.left = deleteMin(t.left);
        else
            t = t.right;
        return t;
    }

    public DoubleNodeSearchTree<T> getRoot() {
        return root;
    }
}
