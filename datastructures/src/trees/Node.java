package trees;

public class Node {
    public Node left;
    public Node right;
    int data;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}
