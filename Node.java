public class Node {

    int data; // frequency
    Node leftChild;
    Node rightChild;
    Node parent;

    public Node(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
    }

    public int getKey() {
        return this.data;
    }

    public void display() {
        System.out.println("[" + data + "]");
    }

    public boolean isLeaf() {
        return (leftChild == null) && (rightChild == null);
    }
}
