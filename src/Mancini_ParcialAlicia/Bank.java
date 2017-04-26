package Mancini_ParcialAlicia;


/**
 * Created by DiegoMancini on 25/4/17.
 */
public class Bank {

    private BinaryTree<Account> initialTree;
    private BinarySearchTree<Account> sucursal_A_Tree;
    private BinarySearchTree<Account> sucursal_B_Tree;

    public Bank(BinaryTree<Account> initialTree) {
        this.initialTree = initialTree;
        sucursal_A_Tree = new BinarySearchTree<>();
        sucursal_B_Tree = new BinarySearchTree<>();
    }

    public void transferAccounts (BinaryTree<Account> a){
        if (!a.isEmpty()) {
            if(a.getRootElement().getSucursal() == 'A') {
                sucursal_A_Tree.insert(a.getRootElement());
            }
            if (a.getRootElement().getSucursal() == 'B') {
                sucursal_B_Tree.insert(a.getRootElement());
            }
            transferAccounts(a.getLeft());
            transferAccounts(a.getRight());
        }
    }


    public void preOrdenInitialTree (BinaryTree<Account> a){
        if (!a.isEmpty()) {
            System.out.print("Num of account: " + a.getRootElement().getNum() + "||| Sucursal: " +a.getRootElement().getSucursal() +"\n") ;
            preOrdenInitialTree(a.getLeft());
            preOrdenInitialTree(a.getRight());
        }
    }

    public void preOrdenSucursalA (BinarySearchTree<Account> a){
        if (!a.isEmpty()) {
            System.out.print("Num of account: " + a.getRootElement().getNum() + "||| Sucursal: " +a.getRootElement().getSucursal() +"\n");
            preOrdenSucursalA(a.getLeft());
            preOrdenSucursalA(a.getRight());
        }
    }

    public void preOrdenSucursalB (BinarySearchTree<Account> a){
        if (!a.isEmpty()) {
            System.out.print("Num of account: " + a.getRootElement().getNum() + "||| Sucursal: " +a.getRootElement().getSucursal() +"\n");
            preOrdenSucursalB(a.getLeft());
            preOrdenSucursalB(a.getRight());
        }
    }

    public BinaryTree<Account> getInitialTree() {
        return initialTree;
    }

    public BinarySearchTree<Account> getSucursal_A_Tree() {
        return sucursal_A_Tree;
    }

    public BinarySearchTree<Account> getSucursal_B_Tree() {
        return sucursal_B_Tree;
    }

}
