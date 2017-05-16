package Mancini_ParcialCassol;

/**
 * @author Diego Mancini
 */
public class FastPassTicket extends Ticket {

    private int uses = 8;

    @Override
    String getName() {
        return "FastPass";
    }

    @Override
    int getPrice() {
        return 60;
    }

    public int getFastPassUses() {
        return uses;
    }

    public void removeUse() {
        --uses;
    }

    @Override
    boolean isFastPass() {
        return true;
    }
}
