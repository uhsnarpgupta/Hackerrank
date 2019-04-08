package trees.bst;

import java.util.Scanner;

import static trees.bst.BinarySearchTree.*;

public class BinarySearchTreeInsertion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();

        preOrder(root);

        checkBST(root);
    }
}
