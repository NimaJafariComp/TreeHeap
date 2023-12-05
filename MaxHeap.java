

public class MaxHeap {
    private Node root;
    private int currentSize;

    public MaxHeap() {
        root = null;
        currentSize = 0;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean insert(int key) {
        Node newNode = new Node(key);
        
        if (root == null) {
            root = newNode;
        } else {
            Node parent = findParentForInsertion();
            if (parent.leftChild == null) {
                parent.leftChild = newNode;
            } else {
                parent.rightChild = newNode;
            }
            newNode.parent = parent;

            trickleUp(newNode);

        }
        currentSize++;
        return true;
    }

    public boolean remove() {
        if (root == null) {
            
            return false; // Heap is empty
        }
    
        // Swap the last node with the root
        Node lastNode = getLastNode();
        root.data = lastNode.data;

        if (lastNode == root) {
            root = null;
            System.out.println("root is deleted");
            return true;
        }
    
        // Remove the last node
        if (lastNode.parent != null) {
            if (lastNode.parent.leftChild == lastNode) {
                lastNode.parent.leftChild = null;
            } else {
                lastNode.parent.rightChild = null;
            }
        }
    
        trickleDown(root); // Restore the heap property
    
        currentSize--;
        return true;
    }
    
    private void trickleDown(Node node) {
        while (true) {
            Node leftChild = node.leftChild;
            Node rightChild = node.rightChild;
            Node largerChild;
    
            if (leftChild == null && rightChild == null) {
                // If no child nodes exist, we're done
                return;
            } else if (rightChild == null || leftChild.data > rightChild.data) {
                largerChild = leftChild;
            } else {
                largerChild = rightChild;
            }
    
            if (node.data < largerChild.data) {
                // Swap the node's data with the larger child's data
                int temp = node.data;
                node.data = largerChild.data;
                largerChild.data = temp;
                node = largerChild;
            } else {
                // The node is in the correct position, so we're done
                return;
            }
        }
    }
    

    private void trickleUp(Node node) {
        while (node.parent != null && node.data > node.parent.data) {
            int temp = node.data;
            node.data = node.parent.data;
            node.parent.data = temp;
            node = node.parent;
        }
    }

    private Node findParentForInsertion() {
        int nodeCount = currentSize + 1; // Start counting nodes at 1 for the root
        String binaryPath = Integer.toBinaryString(nodeCount).substring(1); // Remove the initial '1'
        Node current = root;
        for (char c : binaryPath.toCharArray()) {
            if (c == '0') {
                if (current.leftChild == null) {
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    break;
                }
                current = current.rightChild;
            }
        }
        return current;
    }

    private Node getLastNode() {
        int nodeCount = currentSize;
        String binaryPath = Integer.toBinaryString(nodeCount).substring(1);
        Node current = root;
        for (char c : binaryPath.toCharArray()) {
            if (c == '0') {
                if (current.leftChild == null) {
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    break;
                }
                current = current.rightChild;
            }
        }
        return current;
    }

    public void displayHeap() {
        display(root);
    }

    private void display(Node node) {
        if (node != null) {

           //System.out.print(node.data + " ");
           //display(node.leftChild);
           //display(node.rightChild);
            String s = traversePreOrder(node);
            System.out.println(s);

        }
    }
    

    private String traversePreOrder(Node root) {
        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();
        sb.append(root.data);

        String pointerRight = "---";
        String pointerLeft = "|--";

        traverseNodes(sb, "", pointerLeft, root.leftChild, root.rightChild != null);
        traverseNodes(sb, "", pointerRight, root.rightChild, false);

        return sb.toString();
    }

    private void traverseNodes(StringBuilder sb, String padding, String pointer,
            Node node, boolean hasRightSibling) {

        if (node == null)
            return;

        sb.append("\n");
        sb.append(padding);
        sb.append(pointer);
        sb.append(node.data);

        StringBuilder pb = new StringBuilder(padding);
        if (hasRightSibling)
            pb.append("|  ");
        else
            pb.append("   ");

        String p = pb.toString();
        String pntr = "|--";
        traverseNodes(sb, p, pntr, node.leftChild, node.rightChild != null);
        traverseNodes(sb, p, pntr, node.rightChild, false);
    }
}