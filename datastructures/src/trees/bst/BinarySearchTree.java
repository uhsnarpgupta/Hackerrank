package trees.bst;

public class BinarySearchTree {

    public static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        } else if (data < root.data) {
            if (root.left == null) {
                Node left = new Node(data);
                root.left = left;
            } else {
                insert(root.left, data);
            }
        } else {
            if (root.right == null) {
                Node right = new Node(data);
                root.right = right;
            } else {
                insert(root.right, data);
            }
        }
        return root;
    }

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private static boolean checkBST(Node root, int minValue, int maxValue) {
        if (root == null)
            return true;

        if (root.data < minValue || root.data > maxValue)
            return false;

        return (checkBST(root.left, minValue, root.data - 1)
                && checkBST(root.right, root.data + 1, maxValue));
    }

    public static boolean checkBST(Node root) {
        boolean isBst = checkBST(root, 0, 10000);
        System.out.println(isBst ? "Yes" : "No");
        return isBst;
    }
}

/*
        4
       / \
      2   7
     / \
    1   3

         4
       /   \
      2     7
     / \   /
    1   3 6

 */
