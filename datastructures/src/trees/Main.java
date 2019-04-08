package trees;

public class Main {
    public static void main(String[] args) {
        Tree intTree = new Tree();
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);
        intTree.insert(17);

        intTree.traversePreOrder();

        System.out.println(intTree.get(27));
        System.out.println(intTree.get(17));
        System.out.println(intTree.get(8888));

        System.out.println(intTree.min());
        System.out.println(intTree.max());

        System.out.println("-------");
        intTree.delete(15);
        intTree.traverseInOrder();
        System.out.println();

        intTree.traverseLevelOrder();

        System.out.println();
        System.out.println(intTree.diameter(intTree.getRoot()));

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(1);
        binaryTree.root.left = null;
        binaryTree.root.right = new Node(2);
        binaryTree.root.right.right = new Node(5);
        binaryTree.root.right.left = null;
        binaryTree.root.right.right.left = new Node(3);
        binaryTree.root.right.right.right = new Node(6);
        binaryTree.root.right.right.left.right = new Node(4);

        binaryTree.traverseLevelOrder();

    }
}
