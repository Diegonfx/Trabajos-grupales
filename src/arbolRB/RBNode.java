package arbolRB;

/**
 * Created by DiegoMancini on 1/6/17.
 */
public class RBNode<Q extends Comparable<Q>>{

    private Q elem;
    private RBNode<Q> right, left;
    private RBNode<Q> parent;
    private int color; // Black 1 ||| Red 0

    public RBNode() {
        this(null, null, null);
        color = 1;
    }

    public RBNode(Q elem) {
        this(elem, null, null);
        color = 1;
    }

    public RBNode(Q elem, RBNode<Q> right, RBNode<Q> left) {
        this.elem = elem;
        this.right = right;
        this.left = left;
        color = 1;
    }

    public boolean isLeaf() {
        if(this.left == null && this.right == null) {
            return true;
        } else {
            return false;
        }
    }

    public void setChild(RBNode father , RBNode child) {
        if (child.elem.compareTo(father.elem) > 0) {
            father.right = child;
        } else {
            father.left = child;
        }
    }

    public boolean getSideRelationship(RBNode node) {
        if (node.getParent().elem.compareTo(node.elem) > 0) {
            return true; //node is right child
        } else {
            return false; //node is left child
        }
    }

    public boolean isExteriorChild() {
        if ( ((this.getSideRelationship(this.getParent())) && (this.getParent().getSideRelationship(this.getParent().getParent())) ) || (!this.getSideRelationship(this.getParent()) && this.getParent().getSideRelationship(this.getParent().getParent())) ) {
            return true;
        } else {
            return false;
        }
    }


    public RBNode getParent() {
        if (parent == null) {
            return this;
        }
        return parent;
    }

    public RBNode getUncle() {
        if (this.getSideRelationship(this.getParent())) {
            return this.getParent().getRight();
        } else {
            return this.getParent().getLeft();
        }
    }

    public boolean uncleIsBlack() {
        RBNode aux;

        if (this.getParent().getSideRelationship(this.getParent().getParent())) {
            aux = this.getParent().getParent().getRight();
        } else {
            aux = this.getParent().getParent().getLeft();
        }

        if (aux == null || aux.color == 1) {
            return true;
        } else {
            return false;
        }

    }

    public int getColor() {
        return color;
    }

    public Q getElem() {
        return elem;
    }

    public RBNode<Q> getRight() {
        return right;
    }

    public RBNode<Q> getLeft() {
        return left;
    }

    public void setToNull(RBNode node) {
        if (node == left) {
            left = null;
        } else {
            right = null;
        }
    }

    public void setRed() {
        color = 0;
    }

    public void setBlack() {
        color = 1;
    }

    public void setParent(RBNode<Q> parent) {
        this.parent = parent;
    }

}
