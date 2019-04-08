package trees;

public class Tree {

    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    //DFS : inorder, preorder, postorder
    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    public void traversePreOrder() {
        if (root != null) {
            root.traversePreOrder();
        }
    }

    public void traversePostOrder() {
        if (root != null) {
            root.traversePostOrder();
        }
    }

    // BFS : levelOrder
    public void traverseLevelOrder() {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printGivenLevel(root, i);
    }

    public int diameter(TreeNode root) {
        if (root == null)
            return 0;
        int lHeight = height(root.getLeftChild());
        int rHeight = height(root.getRightChild());
        int lDiameter = diameter(root.getLeftChild());
        int rDiameter = diameter(root.getRightChild());
        /* Return max of following three
          1) Diameter of left subtree
         2) Diameter of right subtree
         3) Height of left subtree + height of right subtree + 1 */
        return Math.max(lHeight + rHeight + 1,
                Math.max(lDiameter, rDiameter));
    }


    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    public int height(TreeNode root) {
        if (root == null)
            return -1;
        /* If tree is not empty then height = 1 + max of left
           height and right heights */
        return (1 + Math.max(height(root.getLeftChild()), height(root.getRightChild())));
    }

    /* Print nodes at the given level */
    void printGivenLevel(TreeNode root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.getData() + " ");
        else if (level > 1) {
            printGivenLevel(root.getLeftChild(), level - 1);
            printGivenLevel(root.getRightChild(), level - 1);
        }
    }

    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        }
        return null;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode subtreeRoot, int value) {
        if (subtreeRoot == null) {
            return subtreeRoot;
        }

        if (value < subtreeRoot.getData()) {
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
        } else if (value > subtreeRoot.getData()) {
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
        } else {
            // case 1 and 2: node to delete has 0 or 1 child(ren)
            if (subtreeRoot.getLeftChild() == null) {
                return subtreeRoot.getRightChild();
            } else if (subtreeRoot.getRightChild() == null) {
                return subtreeRoot.getLeftChild();
            }
            // case 3: node to delete has 2 children

            // replace the value in the subtreeRoot node with the smallest value from the right subtree
            subtreeRoot.setData(subtreeRoot.getRightChild().min());

            // delete the node that has the smallest value in the right subtree
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
        }

        return subtreeRoot;
    }

    public int min() {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return root.min();
        }
    }

    public int max() {
        if (root == null) {
            return Integer.MAX_VALUE;
        } else {
            return root.max();
        }
    }

    void mirror(TreeNode node) {
        if (node == null)
            return;
        else {
            /* do the subtrees */
            mirror(node.getLeftChild());
            mirror(node.getRightChild());

            /* swap the pointers in this node */
            TreeNode temp = node.getLeftChild();
            node.setLeftChild(node.getRightChild());
            node.setRightChild(temp);
        }
    }


    public TreeNode getRoot() {
        return root;
    }
}
