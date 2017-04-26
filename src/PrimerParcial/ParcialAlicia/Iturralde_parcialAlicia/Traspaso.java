package PrimerParcial.ParcialAlicia.Iturralde_parcialAlicia;

import TrabajoPractico_BinarySearchTree.BinarySearchTree;
import TrabajoPractico_BinaryTree.BinaryTree;

/**
 * Implementacion del traspaso del viejo sistema al nuevo.
 * @author Tomas Iturralde.
 */
public class Traspaso {
    private BinarySearchTree<Client> sucursalA;
    private BinarySearchTree<Client> sucursalB;

    public Traspaso(){
        sucursalA = new BinarySearchTree<>();
        sucursalB = new BinarySearchTree<>();
    }

    public BinarySearchTree<Client> getSucursalA() {
        return sucursalA;
    }
    public BinarySearchTree<Client> getSucursalB() {
        return sucursalB;
    }

    public void changeSystem(BinaryTree<Client> previousSystem){
        if (previousSystem.isEmpty())
            return;
        else if (previousSystem.getRootElement().getSucursal() == 'A')
            sucursalA.insert(previousSystem.getRootElement());
        else if (previousSystem.getRootElement().getSucursal() == 'B')
            sucursalB.insert(previousSystem.getRootElement());
        if (!previousSystem.getLeft().isEmpty() && !previousSystem.getRight().isEmpty()) {
            changeSystem(previousSystem.getLeft());
            changeSystem(previousSystem.getRight());
        }

    }

    public void printAInOrden(BinarySearchTree<Client> sucursalA){
        if(!sucursalA.isEmpty()){
            printAInOrden(sucursalA.getLeft());
            System.out.println(sucursalA.getRootElement().clientCode);
            printAInOrden(sucursalA.getRight());

        }
    }

    public void printBInOrden(BinarySearchTree<Client> sucursalB){
        if(!sucursalB.isEmpty()){
            printBInOrden(sucursalB.getLeft());
            System.out.println(sucursalB.getRootElement().clientCode);
            printBInOrden(sucursalB.getRight());
        }
    }
}
