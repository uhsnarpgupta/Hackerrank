public class MirrorTree {
    public static void main(String[] args) {

    }

    private static void mirror(Node node) {

    }

}

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)
   {
        data = item;
        left = right = null;
    }
} */

/*
Input Format:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains two
lines of input. The first line contains number of edges. The second line contains relation between nodes.

Output Format:
For each testcase, in a new line, print inorder traversal of mirror tree.

Your Task:
You don't have to take any input. Just complete the function mirror that takes node as paramter.

Constraints:
1 <=T<= 75
1 <= Number of nodes<= 100
1 <= Data of a node<= 1000

Example:
Input:
2
2
1 2 R 1 3 L
4
10 20 L 10 30 R 20 40 L 20 60 R

Output:
2 1 3
30 10 60 20 40

Explanation:
Testcase1: The tree is
       1         (mirror)     1
     /  \         =>        /   \
   3     2                2      3
The inorder of mirror is 2 1 3
Testcase2: The tree is
                          10                                 10
                        /    \           (mirror)          /    \
                     20      30            =>            30      20
                   /    \                                       /  \
                 40     60                                    60   40
The inroder traversal of mirror is 30 10 60 20 40
 */