package Arbol234;

public abstract class Node {
    private Node father;
    public int type;
    int x;
    int y;
    public abstract Node search(Comparable c);
    public abstract boolean isLeaf();
    public abstract Node insert(Object object);
    public abstract void setChild(Comparable o,Node child);
    public abstract void print();
    public Node getFather() {
        return father;
    }
    public abstract Object[] getData();
    public void setFather(Node father) {
        this.father = father;
    }

}
