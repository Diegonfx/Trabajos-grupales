package TrabajoPractico_Morse.BinaryTreeImp;

/**
 * Created by Tomas on 26/3/2017.
 */
public class TreeApi {
    public <T> int size (BinaryTree<T> a){
        if(a.isEmpty())
            return 0;
        else
            return 1 + size(a.getLeft())+size(a.getRight());
    }

    public <T> int completeNodes(BinaryTree<T> a){
        if(a.isEmpty())
            return 0;
        if (a.getLeft().isEmpty())
            return completeNodes(a.getRight());
        if (a.getRight().isEmpty())
            return completeNodes(a.getLeft());
        return 1+completeNodes(a.getRight())+completeNodes(a.getLeft());
    }

    public <T> void inorden(BinaryTree<T>  a){
        if(!a.isEmpty()){
            inorden(a.getLeft());
            System.out.println(a.getRoot());
            inorden(a.getRight());
        }
    }

    public <T> int ocurrencias(BinaryTree<T> a, Object o){
        if(a.isEmpty())
            return 0;
        if(a.getRoot().equals(o))
            return 1 + ocurrencias(a.getLeft(),o)+ocurrencias(a.getRight(),o);
        else
            return ocurrencias(a.getLeft(),o)+ocurrencias(a.getRight(),o);
    }
}

