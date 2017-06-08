package arbolRB;

/**
 * Created by Tomas on 29/5/2017.
 */
public class TreeRB<T extends Comparable<T>> {

    private static final int BLACK = 1;
    private static final int RED = 0;
    RedBlackNode<T> root;

    class RedBlackNode<Q> {
        Q elem;
        RedBlackNode<Q> right, left;
        private RedBlackNode<Q> parent;
         int color; // Black 1 ||| Red 0
        private boolean isNullLeaf;
        private int numRight;
        private int numLeft;
        int x;
        int y;


        public RedBlackNode() {
            this(null, null, 0);
        }

        public RedBlackNode(Q elem) {
            this(null, elem, 0);
        }

        public RedBlackNode(RedBlackNode<Q> node, Q element, int color) {
            this.elem = element;
            this.color = color;
            this.left = null;
            this.right = null;
            this.parent = node;
            numLeft = 0;
            numRight = 0;
        }

        public <Q> void inOrden() {
            if (left != null) {
                left.inOrden();
            }
            System.out.println(elem + " color: " + color);
            if (right != null) {
                right.inOrden();
            }
        }

        public <Q> void preOrden() {
            System.out.println(elem + " color: " + color);
            if (left != null) {
                left.preOrden();
            }
            if (right != null) {
                right.preOrden();
            }
        }

    }

    public TreeRB() {
        root = null;
    }

    private RedBlackNode<T> createNullLeafNode(RedBlackNode<T> node) {
        RedBlackNode<T> nullLeaf = new RedBlackNode<>();
        nullLeaf.color = BLACK;
        nullLeaf.isNullLeaf = true;
        nullLeaf.parent = node;
        return nullLeaf;
    }

    public <T> int height(RedBlackNode<T> a){
        if (a == null) {
            return 0;
        }
        return 1 + Math.max(height(a.left), height(a.right));
    }

    public void insert(T x) {
        insert(new RedBlackNode<>(x));
    }

    private void rightRotate(RedBlackNode<T> element) {
        if (isNull(element.right) && isNull(element.left.right)){
            element.numRight = 0;
            element.numLeft = 0;
            element.left.numRight = 1;
        }

        else if (isNull(element.right) && !isNull(element.left.right)){
            element.numRight = 0;
            element.numLeft = 1 + element.left.right.numRight +
                    element.left.right.numLeft;
            element.left.numRight = 2 + element.left.right.numRight +
                    element.left.right.numLeft;
        }

        else if (!isNull(element.right) && isNull(element.left.right)){
            element.numLeft = 0;
            element.left.numRight = 2 + element.right.numRight +element.right.numLeft;

        }

        else{
            element.numLeft = 1 + element.left.right.numRight +
                    element.left.right.numLeft;
            element.left.numRight = 3 + element.right.numRight +
                    element.right.numLeft +
                    element.left.right.numRight + element.left.right.numLeft;
        }

        RedBlackNode<T> x = element.left;
        element.left = x.right;

        if (!isNull(x.right))
            x.right.parent = element;
        x.parent = element.parent;

        if (isNull(element.parent))
            root = x;

        else if (element.parent.right == element)
            element.parent.right = x;

        else
            element.parent.left = x;
        x.right = element;

        element.parent = x;

    }

    private void leftRotate(RedBlackNode<T> element) {

        if (isNull(element.left) && isNull(element.right.left)){
            element.numLeft = 0;
            element.numRight = 0;
            element.right.numLeft = 1;
        }

        else if (isNull(element.left) && !isNull(element.right.left)){
            element.numLeft = 0;
            element.numRight = 1 + element.right.left.numLeft +
                    element.right.left.numRight;
            element.right.numLeft = 2 + element.right.left.numLeft +
                    element.right.left.numRight;
        }

        else if (!isNull(element.left) && isNull(element.right.left)){
            element.numRight = 0;
            element.right.numLeft = 2 + element.left.numLeft + element.left.numRight;

        }
        else{
            element.numRight = 1 + element.right.left.numLeft +
                    element.right.left.numRight;
            element.right.numLeft = 3 + element.left.numLeft + element.left.numRight +
                    element.right.left.numLeft + element.right.left.numRight;
        }

        RedBlackNode<T> y;
        y = element.right;
        element.right = y.left;

        if (!isNull(y.left))
            y.left.parent = element;
        y.parent = element.parent;

        if (isNull(element.parent))
            root = y;

        else if (element.parent.left == element)
            element.parent.left = y;

        else
            element.parent.right = y;

        y.left = element;
        element.parent = y;
    }

    private boolean isLeftChild(RedBlackNode<T> root) {
        RedBlackNode<T> parent = root.parent;
        return parent.left == root;
    }

    private boolean isRightChild(RedBlackNode<T> root) {
        RedBlackNode<T> parent = root.parent;
        return parent.right == root;
    }

    private boolean isNull(RedBlackNode node) {
        return node == null;
    }

    @SuppressWarnings("unchecked")
    private void insert(RedBlackNode<T> t) {
        RedBlackNode<T> y = null;
        RedBlackNode<T> x = root;

        while (!isNull(x)) {
            y = x;

            if (t.elem.compareTo(x.elem) < 0) {
                x.numLeft++;
                x = x.left;
            } else {
                x.numRight++;
                x = x.right;
            }
        }
        t.parent = y;

        if (isNull(y))
            root = t;
        else if (t.elem.compareTo(y.elem) < 0)
            y.left = t;
        else
            y.right = t;

        t.left = null;
        t.right = null;
        t.color = RED;
        checkForIrregularities(t);
    }

    public void checkForIrregularities(RedBlackNode<T> element) {
        RedBlackNode<T> y;
        if (!isNull(element.parent)) {
            while (!isNull(element.parent) && element.parent.color == RED) {

                if (element.parent == element.parent.parent.left) {
                    y = element.parent.parent.right;

                    if (!isNull(y) && y.color == RED) {
                        element.parent.color = BLACK;
                        y.color = BLACK;
                        element.parent.parent.color = RED;
                        element = element.parent.parent;
                    } else if (element == element.parent.right) {

                        element = element.parent;
                        leftRotate(element);
                    } else {
                        element.parent.color = BLACK;
                        element.parent.parent.color = RED;
                        rightRotate(element.parent.parent);
                    }
                } else {
                    y = element.parent.parent.left;

                    if (!isNull(y) && y.color == RED) {
                        element.parent.color = BLACK;
                        y.color = BLACK;
                        element.parent.parent.color = RED;
                        element = element.parent.parent;
                    } else if (element == element.parent.left) {
                        element = element.parent;
                        rightRotate(element);
                    } else {
                        element.parent.color = BLACK;
                        element.parent.parent.color = RED;
                        leftRotate(element.parent.parent);
                    }
                }
            }
        }
        else
            element.color = BLACK;
        root.color = BLACK;
    }
}