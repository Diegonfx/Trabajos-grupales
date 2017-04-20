package TrabajoPractico_BinarySearchTree;

/**
 * Created by Tomas on 15/4/2017.
 */
public class Tester {
    public static void main(String[] args) {
        LightBulb lightBulb1 = new LightBulb("52345", 60, "bajo");
        LightBulb lightBulb2 = new LightBulb("41242", 60, "bajo", lightBulb1);
        LightBulb lightBulb3 = new LightBulb("26858",70,"medio",lightBulb2);
        LightBulb lightBulb4 = new LightBulb("27846",70,"medio",lightBulb3);
        LightBulb lightBulb5 = new LightBulb("36128",90,"alto", lightBulb4);

        BinaryTree<LightBulb> root = new BinaryTree<>();
        root.insert(lightBulb5);
        root.insert(lightBulb4);
        root.insert(lightBulb3);
        root.insert(lightBulb2);
        root.insert(lightBulb1);

    }
}
