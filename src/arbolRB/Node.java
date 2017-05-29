package arbolRB;

/**
 * Created by Tomas on 29/5/2017.
 */
public class Node<Q> {
    private Q elem;
    private Node<Q> right, left;
    //Colour: String o Interfaz?

    public Node(Q o){
        elem = o;
    }

    public Q getElem() {
        return elem;
    }
    public Node<Q> getRight() {
        return right;
    }
    public Node<Q> getLeft() {
        return left;
    }

}
