package Mancini_ParcialAlicia;

/**
 * Created by DiegoMancini on 25/4/17.
 */
public class Tester {

    public static void main(String[] args) {
        Account number2 = new Account('A' , 2);
        Account number5 = new Account('B' , 5);
        Account number3 = new Account('A' , 3);
        Account number1 = new Account('B' , 1);
        Account number7 = new Account('B' , 7);
        Account number4 = new Account('A' , 4);
        Account number10 = new Account('A' , 10);

        BinaryTree<Account> tree6 = new BinaryTree<>(number2);
        BinaryTree<Account> tree5 = new BinaryTree<>(number5);
        BinaryTree<Account> tree4 = new BinaryTree<>(number4);
        BinaryTree<Account> tree3 = new BinaryTree<>(number1);
        BinaryTree<Account> tree2 = new BinaryTree<>(number3,tree5,tree6);
        BinaryTree<Account> tree1 = new BinaryTree<>(number7,tree3,tree4);
        BinaryTree<Account> root = new BinaryTree<>(number10,tree1,tree2);

        Bank bankAlicia = new Bank(root);
        System.out.println("\nInitial bank state: ");
        bankAlicia.preOrdenInitialTree(root);
        bankAlicia.transferAccounts(root);
        System.out.println("\nSucursal A tree state: ");
        bankAlicia.preOrdenSucursalA(bankAlicia.getSucursal_A_Tree());
        System.out.println("\nSucursal B tree state: ");
        bankAlicia.preOrdenSucursalB(bankAlicia.getSucursal_B_Tree());
    }
}
