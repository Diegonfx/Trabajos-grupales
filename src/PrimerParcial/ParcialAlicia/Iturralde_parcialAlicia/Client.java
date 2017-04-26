package PrimerParcial.ParcialAlicia.Iturralde_parcialAlicia;

/**
 * Implementation of a client from the bank.
 * @author Tomas Iturralde
 */
public class Client implements Comparable<Client>{
    char sucursal;
    int clientCode;

    public Client(char sucursals, int clientCode) {
        if (sucursals != 'A' && sucursals != 'B')
            throw new RuntimeException("Sucursal no disponible, intente con otra.");
        sucursal = sucursals;
        this.clientCode = clientCode;
    }

    public char getSucursal() {
        return sucursal;
    }
    public int getClientCode() {
        return clientCode;
    }

    @Override
    public int compareTo(Client o) {
        if (clientCode < o.clientCode)
            return -1;
        if (clientCode > o.clientCode)
            return 1;
        return 0;
    }
}
