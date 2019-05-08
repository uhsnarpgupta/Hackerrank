package trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTree {
    public Node root;

    /*The function Compute the "height" of a tree. Height is the
      number f nodes along the longest path from the root node
      down to the farthest leaf node.*/
    static int height(Node node) {
        /* base case tree is empty */
        if (node == null)
            return -1;

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

    /* If target is present in tree, then prints the ancestors
       and returns true, otherwise returns false. */
    public boolean printAncestors(Node node, int target) {
        /* base cases */
        if (node == null)
            return false;

        if (node.data == target)
            return true;

        /* If target is present in either left or right subtree
           of this node, then print this node */
        if (printAncestors(node.left, target)
                || printAncestors(node.right, target)) {
            System.out.print(node.data + " ");
            return true;
        }

        /* Else return false */
        return false;
    }

    // BFS : levelOrder
    public void traverseLevelOrder() {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printGivenLevel(root, i);
    }


    // working approach
    public static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            Node tree = queue.remove();
            System.out.print(tree.data + " ");

            if (tree.left != null) {
                queue.add(tree.left);
            }
            if (tree.right != null) {
                queue.add(tree.right);
            }
        }
    }

    /* Print nodes at the given level */
    void printGivenLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    // function should print the topView of
    // the binary tree
    public void topView(Node root) {
        class QueueObj {
            Node node;
            int hd;

            QueueObj(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObj> q = new LinkedList<QueueObj>();
        Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>();

        if (root == null) {
            return;
        } else {
            q.add(new QueueObj(root, 0));
        }

        System.out.println("The top view of the tree is : ");

        // count function returns 1 if the container
        // contains an element whose key is equivalent
        // to hd, or returns zero otherwise.
        while (!q.isEmpty()) {
            QueueObj tmpNode = q.poll();
            if (!topViewMap.containsKey(tmpNode.hd)) {
                topViewMap.put(tmpNode.hd, tmpNode.node);
            }

            if (tmpNode.node.left != null) {
                q.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1));
            }
            if (tmpNode.node.right != null) {
                q.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1));
            }

        }
        for (Map.Entry<Integer, Node> entry : topViewMap.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
    }

    /* Returns true if binary tree with root as root is height-balanced */
    private boolean isBalanced(Node node) {
        int lh; /* for height of left subtree */

        int rh; /* for height of right subtree */

        /* If tree is empty then return true */
        if (node == null)
            return true;

        /* Get the height of left and right sub trees */
        lh = height(node.left);
        rh = height(node.right);

        if (Math.abs(lh - rh) <= 1
                && isBalanced(node.left)
                && isBalanced(node.right))
            return true;

        /* If we reach here then tree is not height-balanced */
        return false;
    }
}
