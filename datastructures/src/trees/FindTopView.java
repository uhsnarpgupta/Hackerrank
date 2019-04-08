package trees;

public class FindTopView {
    public static void main(String[] args) {
        /* Create following Binary Tree
            1
        / \
        2 3
        \
            4
            \
            5
            \
                6*/
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        System.out.println("Following are nodes in top view of Binary Tree");
        tree.topView(tree.root);
    }
}
