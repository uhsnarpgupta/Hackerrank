package trees;

public class HuffmanDecoding {
}


class HuffmanNode {
    HuffmanNode left;
    HuffmanNode right;
    Character data;
    int value;

    public HuffmanNode() {
    }

    public HuffmanNode(Character data, int value) {
        this.data = data;
        this.value = value;
    }
}

class Test {
    public static void main(String[] args) {
        HuffmanNode root = new HuffmanNode(null, 5);
        root.left = new HuffmanNode(null, 2);
        root.right = new HuffmanNode('A', 3);
        root.left.left = new HuffmanNode('B', 1);
        root.left.right = new HuffmanNode('C', 1);

        String input = "1001011";
        int[] intArr = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            intArr[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        int i = 0;
        HuffmanNode node = root;
        HuffmanNode updatedNode = node;

        do {
            int in = intArr[i];
            updatedNode = getNode(node, in);
            if (node == updatedNode) {
                System.out.print(updatedNode.data);
                node = root;
                i--;
            } else {
                node = updatedNode;
            }
            i++;

        } while (i < intArr.length);
        System.out.print(node.data);
    }

    private static HuffmanNode getNode(HuffmanNode node, int p) {
        if (p == 0 && node.left != null) {
            node = node.left;
        } else if (p == 1 && node.right != null) {
            node = node.right;
        }
        return node;
    }

}