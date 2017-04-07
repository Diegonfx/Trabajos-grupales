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
        root = new DoubleNode <T>(o);
    }

    public BinaryTree(T o, BinaryTree<T> tleft, BinaryTree<T> tright){
        root = new DoubleNode<T>(o,tleft.root, tright.root);
    }

    public boolean isEmpty(){
        return root == null;
    }

    public T getRoot(){
        return root.elem;
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

    private class DoubleNode <Q>{
        Q elem;
        DoubleNode <Q> right, left;

        public DoubleNode(Q o){
            elem = o;
        }

        public DoubleNode(Q o, DoubleNode<Q> left, DoubleNode<Q> right){
            elem = o;
            this.right = right;
            this.left = left;
        }
    }
}

