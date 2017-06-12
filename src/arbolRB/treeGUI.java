package arbolRB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by Tomas on 8/6/2017.
 */
public class treeGUI extends JFrame {

//    private JPanel contentPane;
//    public TreeRB tree;
//    public DrawTree drawer;
//
//
//    public treeGUI(TreeRB tree) {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(100, 100, 500, 500);
//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        contentPane.setLayout(new BorderLayout(0, 0));
//        drawer = new DrawTree(tree);
//
//        contentPane.add(drawer);
//        setContentPane(contentPane);
//        this.tree = tree;
//        setVisible(true);
//    }
//
//}
//
//class DrawTree extends JPanel{
//
//    public TreeRB tree;
//
//    public DrawTree(TreeRB tree){
//        this.tree = tree;
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        g.setFont(new Font("Tahoma", Font.BOLD, 20));
//        DrawTree(g, 0, getWidth(), 0, getHeight() / tree.height(tree.root), tree.root);
//    }
//
//    public void DrawNode(Graphics g, TreeRB.RedBlackNode n, int w, int h, int q){
//        g.setFont(new Font("Tahoma", Font.BOLD, 20));
//
//        if(n!=null){
//            String data = String.valueOf(n.elem);
//
//            g.drawString(data, (this.getWidth()/q)+w, h);
//
//            if(n.left !=null)
//                DrawNode(g, n.left, -w, h*2, q);
//            if(n.right !=null)
//                DrawNode(g, n.right, w*2, h*2, q);
//        }
//    }
//
//
//    public void DrawTree(Graphics g, int StartWidth, int EndWidth, int StartHeight, int Level, TreeRB.RedBlackNode node) {
//        String data = String.valueOf(node.elem);
//        g.setFont(new Font("Tahoma", Font.BOLD, 20));
//        if (node.color == 1)
//            g.setColor(Color.BLACK);
//        else
//            g.setColor(Color.RED);
//        FontMetrics fm = g.getFontMetrics();
//        int dataWidth = fm.stringWidth(data);
//        g.drawOval((StartWidth - 15 + EndWidth - 15) / 2 - dataWidth / 2, StartHeight - 30 + Level / 2, 130, 50);
//
//        g.drawString(data, (StartWidth + EndWidth) / 2 - dataWidth / 2, StartHeight + Level / 2);
//        node.x = (StartWidth+20  + EndWidth +20) / 2 - dataWidth / 2;
//        node.y = StartHeight + Level / 2;
//
//        if (node.left != null) {
//            DrawTree(g, StartWidth, (StartWidth + EndWidth) / 2, StartHeight + Level, Level, node.left);
//            g.drawLine(node.x,node.y+15, node.left.x, node.left.y-25);
//        }
//        if (node.right != null) {
//            DrawTree(g, (StartWidth + EndWidth) / 2, EndWidth, StartHeight + Level, Level, node.right);
//            g.drawLine(node.x, node.y+15,node.right.x, node.right.y-25);
//        }
//    }
}
