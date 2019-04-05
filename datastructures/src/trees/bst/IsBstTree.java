package trees.bst;

public class IsBstTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        if (tree.isBinarySearchTree())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}
