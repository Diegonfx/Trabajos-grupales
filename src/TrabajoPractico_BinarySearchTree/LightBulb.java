package TrabajoPractico_BinarySearchTree;

/**
 * Implementation of a Light Bulb.
 * @author Tomas Iturralde
 * @author Diego Mancini
 */
public class LightBulb implements Comparable<LightBulb>{
    private String bulbCode;
    private int watts;
    private String bulbType;
    private LightBulb nextLightBulb;

    public LightBulb(String aBulbCode, int watts, String aBulbType) {
        if (aBulbCode.length() > 5 || aBulbType.length() > 10)
            throw new RuntimeException("Max length surpassed, please try again.");
        bulbCode = aBulbCode;
        this.watts = watts;
        bulbType = aBulbType;
        nextLightBulb = null;
    }

    public LightBulb(String aBulbCode, int watts, String aBulbType, LightBulb nextLightBulb) {
        if (aBulbCode.length() > 5 || aBulbType.length() > 10)
            throw new RuntimeException("Max length surpassed, please try again.");
        bulbCode = aBulbCode;
        this.watts = watts;
        bulbType = aBulbType;
        this.nextLightBulb = nextLightBulb;
    }

    public String getBulbCode() {
        return bulbCode;
    }
    public int getWatts() {
        return watts;
    }
    public String getBulbType() {
        return bulbType;
    }
    public LightBulb getNextLightBulb() {
        return nextLightBulb;
    }
    public void setNextLightBulb(LightBulb nextLightBulb) {
        this.nextLightBulb = nextLightBulb;
    }

    @Override
    public int compareTo(LightBulb o) {
        if (Integer.parseInt(bulbCode) > Integer.parseInt(o.bulbCode))
            return 1;
        else if (Integer.parseInt(bulbCode) < Integer.parseInt(o.bulbCode))
            return -1;
        return 0;
    }
}
