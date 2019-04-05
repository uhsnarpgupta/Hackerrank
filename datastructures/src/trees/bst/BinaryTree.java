package trees.bst;

public class BinaryTree {
    Node root;

    /*The function Compute the "height" of a tree. Height is the
      number f nodes along the longest path from the root node
      down to the farthest leaf node.*/
    static int height(Node node) {
        /* base case tree is empty */
        if (node == null)
            return 0;

        /* If tree is not empty then height = 1 + max of left
           height and right heights */
        return (1 + Math.max(height(node.left), height(node.right)));
    }

    /* returns true if given search tree is binary
     search tree (efficient version) */
    public boolean isBinarySearchTree() {
        if (root == null) return Boolean.TRUE;
        return isBstValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBstValid(Node root, Integer minValue, Integer maxValue) {
        if (root == null) return Boolean.TRUE;
        if (root.data >= minValue && root.data < maxValue
                && isBstValid(root.left, minValue, root.data)
                && isBstValid(root.right, root.data, maxValue)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    /* Method to calculate the diameter and return it to main */
    int diameter(Node root) {
        /* base case if tree is empty */
        if (root == null)
            return 0;

        /* get the height of left and right sub trees */
        int lheight = height(root.left);
        int rheight = height(root.right);

        /* get the diameter of left and right subtrees */
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        /* Return max of following three
          1) Diameter of left subtree
         2) Diameter of right subtree
         3) Height of left subtree + height of right subtree + 1 */
        return Math.max(lheight + rheight + 1,
                Math.max(ldiameter, rdiameter));

    }

    /* A wrapper over diameter(Node root) */
    int diameter() {
        return diameter(root);
    }
}
