package PrimerParcial.ParcialAlicia.Iturralde_parcialAlicia;

import TrabajoPractico_BinaryTree.BinaryTree;

/**
 * Tester para Ejercicio 4 del parcial
 * @author Tomas Iturralde
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        Client client1 = new Client('A', 1276);
        Client client2 = new Client('B', 2415);
        Client client3 = new Client('B', 9355);
        Client client4 = new Client('A', 8426);
        Client client5 = new Client('B', 6128);
        Client client6 = new Client('A', 9428);
        Client client7 = new Client('A', 3416);
        BinaryTree<Client> clientBinaryTree1 = new BinaryTree<>(client1);
        BinaryTree<Client> clientBinaryTree2 = new BinaryTree<>(client2);
        BinaryTree<Client> clientBinaryTree3 = new BinaryTree<>(client3, clientBinaryTree1, clientBinaryTree2);
        BinaryTree<Client> clientBinaryTree4 = new BinaryTree<>(client4);
        BinaryTree<Client> clientBinaryTree5 = new BinaryTree<>(client5);
        BinaryTree<Client> clientBinaryTree6 = new BinaryTree<>(client6, clientBinaryTree4, clientBinaryTree5);
        BinaryTree<Client> previousSystem = new BinaryTree<>(client7,clientBinaryTree3,clientBinaryTree6);

        Traspaso traspaso = new Traspaso();
        traspaso.changeSystem(previousSystem);
        traspaso.printAInOrden(traspaso.getSucursalA());
        System.out.println("------");
        traspaso.printBInOrden(traspaso.getSucursalB());
    }
}
