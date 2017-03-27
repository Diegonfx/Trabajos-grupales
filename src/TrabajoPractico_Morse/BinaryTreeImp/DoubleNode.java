package TrabajoPractico_Morse.BinaryTreeImp;

/**
 * Created by Tomas on 26/3/2017.
 */
public class DoubleNode <T>{
    T elem;
    DoubleNode <T> right, left;

    public DoubleNode(T o){
        elem = o;
    }

    public DoubleNode(T o, DoubleNode<T> left, DoubleNode<T> right){
        elem = o;
        this.right = right;
        this.left = left;
    }
}
