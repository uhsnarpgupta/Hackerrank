package trees.challenge;

import trees.BinaryTree;
import trees.Node;

public class FindAncestors {
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();

        /* Construct the following binary tree
                  1
                /   \
               2     3
              /  \
             4    5
            /
           7
        */
        tree.root = new Node(1);

        tree.root.left = new Node(2);

        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);

        tree.root.left.right = new Node(5);

        tree.root.left.left.left = new Node(7);
        tree.printAncestors(tree.root, 7);
    }
}
