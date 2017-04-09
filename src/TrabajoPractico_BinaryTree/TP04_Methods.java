package TrabajoPractico_BinaryTree;

import TrabajoPractico4_Queue.DynamicQueue;

/**
 * Created by DiegoMancini on 8/4/17.
 */
public class TP04_Methods {

    public <T> void inOrden(BinaryTree<T>  a){
        if(!a.isEmpty()){
            inOrden(a.getLeft());
            System.out.println(a.getRoot());
            inOrden(a.getRight());
        }
    }

    public <T> void preOrden (BinaryTree<T> a){
        if (!a.isEmpty()) {
            System.out.print(a.getRoot());
            preOrden(a.getLeft());
            preOrden(a.getRight());
        }
    }

    public <T> void postOrden (BinaryTree<T> a){
        if (!a.isEmpty()) {
            postOrden(a.getLeft());
            postOrden(a.getRight());
            System.out.print(a.getRoot());
        }
    }

    public <T> void levels(BinaryTree<T> a){

    }
}
