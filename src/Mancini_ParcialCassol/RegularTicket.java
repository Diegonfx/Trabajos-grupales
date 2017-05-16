package Mancini_ParcialCassol;

/**
 * @author Diego Mancini
 */
public class RegularTicket extends Ticket {

    @Override
    String getName() {
        return "RegularTicket";
    }

    @Override
    int getPrice() {
        return 35;
    }

    @Override
    int getFastPassUses() {
        return 0;
    }

    @Override
    boolean isFastPass() {
        return false;
    }

    @Override
    void removeUse() {
    }
}
