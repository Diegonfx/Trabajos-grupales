package arbolRB;

/**
 * Created by Tomas on 29/5/2017.
 */
public class TreeRB<T extends Comparable<T>> {

    private static final int BLACK = 1;
    private static final int RED = 0;

    class RedBlackNode<Q> {
        private Q elem;
        private RedBlackNode<Q> right, left;
        private RedBlackNode<Q> parent;
        private int color; // Black 1 ||| Red 0
        private boolean isNullLeaf;


        public RedBlackNode() {
            this.elem = null;
            this.right = null;
            this.left = null;
            this.parent = null;
            this.color = 0;
        }

        public RedBlackNode(RedBlackNode node , Q element , int color) {
            this.elem = element;
            this.color = color;
            this.left = null;
            this.right = null;
            this.parent = node;

        }

    }

    private RedBlackNode<T> createNullLeafNode(RedBlackNode<T> node) {
        RedBlackNode nullLeaf = new RedBlackNode<>();
        nullLeaf.color = BLACK;
        nullLeaf.isNullLeaf = true;
        nullLeaf.parent = node;
        return nullLeaf;
    }

    private void rotate(RedBlackNode<T> node , boolean changeColor, String direction) {
        RedBlackNode<T> aux;
        RedBlackNode<T> father = node.parent;
        node.parent = father.parent;
        if(father.parent != null) {
            if(father.parent.right == father) {
                father.parent.right = node;
            } else {
                father.parent.left = node;
            }
        }
        if (direction.equals("Left") || direction.equals("left")) {
            aux = node.left;
            node.left = father;
            father.parent = node;
            father.right = aux;
            if(aux != null) {
                aux.parent = father;
            }
            if(changeColor) {
                node.color = BLACK;
                father.color = RED;
            }
        } else if (direction.equals("Right") || direction.equals("right")) {
            aux = node.right;
            node.right = father;
            father.parent = node;
            father.left = aux;
            if(aux != null) {
                aux.parent = father;
            }
            if(changeColor) {
                node.color = BLACK;
                father.color = RED;
            }
        } else {
            System.out.println("Wrong input");
            return;
        }
    }

    private RedBlackNode<T> findSiblingNode(RedBlackNode<T> root) {
        RedBlackNode<T> father = root.parent;
        RedBlackNode<T> grandpa = father.parent;
        if(isLeftChild(root)) {
            return father.right;
        } else {
            return father.left;
        }
    }

    private boolean isLeftChild(RedBlackNode<T> root) {
        RedBlackNode<T> father = root.parent;
        if(father.left == root) {
            return true;
        } else {
            return false;
        }
    }

    private void insert(RedBlackNode<T> parent, RedBlackNode<T> root, T data) {
        boolean isLeft;
        if(root.elem.compareTo(data) < 0) {
            RedBlackNode<T> left = insert(root, root.left, data);
            if(left == root.parent) {
                return left;
            }
            root.left = left;
            isLeft = true;
        } else {
            RedBlackNode<T> right = insert(root, root.right, data);
            if(right == root.parent) {
                return right;
            }
            root.right = right;
            isLeft = false;
        }

        if(isLeft) {
            if(root.color == RED && root.left.color == RED) {
                RedBlackNode<T> sibling = findSiblingNode(root);
                if( !(sibling.elem == null)  || sibling.color == BLACK) {
                    if(isLeftChild(root)) {
                        rotate(root, true , "Right");
                    } else {
                        rotate(root.left, false , "Right");
                        root = root.parent;
                        rotate(root, true , "Left");
                    }

                } else {
                    root.color = BLACK;
                    sibling.color = BLACK;
                    if(root.parent.parent != null) {
                        root.parent.color = RED;
                    }
                }
            }
        } else {
            if(root.color == RED && root.right.color == RED) {
                RedBlackNode<T> sibling = findSiblingNode(root);
                if( !(sibling.elem == null) || sibling.color == BLACK) {
                    if(!isLeftChild(root)) {
                        rotate(root, true , "Left");
                    } else {
                        rotate(root.right, false , "Left");
                        root = root.parent;
                        rotate(root, true , "Right");
                    }
                } else {
                    root.color = BLACK;
                    sibling.color = BLACK;
                    if(root.parent.parent != null) {
                        root.parent.color = RED;
                    }
                }
            }
        }
    }

    public void case2(RedBlackNode<T> root , String direction) {
            RedBlackNode<T> sibling = findSiblingNode(root);
            if (!(sibling.elem == null) || sibling.color == BLACK) {
                if (direction.equals("Right") || direction.equals("right")) {
                    if (isLeftChild(root)) {
                        rotate(root, true, "Right");
                    }
                } else if (direction.equals("Left") || direction.equals("left")) {
                    if(!isLeftChild(root)) {
                        rotate(root, true, "Left");
                    }
                }
            }
    }

    public void case3(RedBlackNode<T> root) {

    }

}
