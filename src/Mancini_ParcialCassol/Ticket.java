package Mancini_ParcialCassol;

/**
 * @author Diego Mancini
 * It's an abstract class which will be known by the client, and depending on its variables
 * will have certain atributes.
 */
public abstract class Ticket {

    abstract String getName();
    abstract int getPrice();
    abstract int getFastPassUses();
    abstract boolean isFastPass();
    abstract void removeUse();

}
