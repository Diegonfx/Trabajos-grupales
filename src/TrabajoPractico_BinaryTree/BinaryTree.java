package TrabajoPractico_BinaryTree;

/**
 * Created by Tomas on 26/3/2017.
 */
public class BinaryTree <T>{
    private DoubleNode<T> root;

    public BinaryTree(){
        root = null;
    }
    public BinaryTree(T o){
        root = new DoubleNode <T>(o , null , null);
    }
    public BinaryTree(T o, BinaryTree<T> tleft, BinaryTree<T> tright){
        root = new DoubleNode<T>(o,tleft.root, tright.root);
    }

    public T getRootElement(){
        return root.elem;
    }
    public boolean isEmpty(){
        return root == null;
    }
    public void makeEmpty() { root = null;}
    public int size() {
        return DoubleNode.size(root);
    }
    public int height() {
        return DoubleNode.height(root);
    }
    public DoubleNode<T> getRoot() {
        return root;
    }
    public BinaryTree<T> getLeft(){
        BinaryTree<T> t = new BinaryTree<T>();
        t.root = root.left;
        return t;
    }
    public BinaryTree<T> getRight(){
        BinaryTree<T> t = new BinaryTree<T>();
        t.root = root.right;
        return t;

    }

    /**
     * Creates a new binary tree from the given parameters. It won't allow 'a' and 'b' to coincide.
     * @param rootElement root of new tree
     * @param a first tree
     * @param b second tree
     */
    public void merge(T rootElement, BinaryTree<T> a , BinaryTree<T> b) {
        if (a.root == b.root && a.root != null) {
            throw new IllegalArgumentException();
        }
        //Assign new root node
        root = new DoubleNode<T>(rootElement , a.root , b.root) ;
        //Make sure each node is in a single tree
        if (this != a) {
            a.root = null;
        }
        if (this != b) {
            b.root = null;
        }
    }

    public <T> void inOrden(){
        if (root != null) {
            root.inOrden();
        }
    }
    public <T> void preOrden (){
        if (root != null) {
            root.preOrden();
        }
    }
    public <T> void postOrden (){
        if (root != null) {
            root.postOrden();
        }
    }
    public <T> void byLevels() {

    }

}

