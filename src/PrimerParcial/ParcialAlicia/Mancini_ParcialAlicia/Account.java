package PrimerParcial.ParcialAlicia.Mancini_ParcialAlicia;

/**
 * Created by DiegoMancini on 25/4/17.
 */
public class Account implements Comparable<Account>{

    private char sucursal;
    private int num;

    public Account(char sucursal, int num) {
        this.sucursal = sucursal;
        this.num = num;
    }

    public char getSucursal() {
        return sucursal;
    }

    public int getNum() {
        return num;
    }

    @Override
    public int compareTo(Account o) {
        if (getNum() > o.getNum())
            return 1;
        else if (getNum() < o.getNum())
            return -1;
        return 0;
    }
}
