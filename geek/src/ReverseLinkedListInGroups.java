public class ReverseLinkedListInGroups {
    public static void main(String[] args) {
        LinkNode head = new LinkNode(6);
        LinkNode current = new LinkNode(5);
        head.next = current;
        current.next = new LinkNode(5);
        current = current.next;
        current.next = new LinkNode(4);
        current = current.next;
        current.next = new LinkNode(3);
        current = current.next;
        current.next = new LinkNode(2);
        current = current.next;
        current.next = new LinkNode(1);
        current = current.next;
        current.next = null;
        reverse(head, 2);
    }

    public static LinkNode reverse(LinkNode head, int k) {
        LinkNode current = head;
        LinkNode prev = null;
        LinkNode next = null;

        int i = k;
        while (i-- > 0 && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        if (next != null) {
            head.next = reverse(next, k);
        }
        return prev;
    }
}

/*
Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the
linked list.

Input:
First line of input contains number of testcases T. For each testcase, first line contains length of linked
list and next line contains the linked list elements.

Output:
For each testcase, there will be a single line of output which contains the linked list with every k group elements
reversed.

Example:
Input:
1
8
1 2 2 4 5 6 7 8
4

Output:
4 2 2 1 8 7 6 5

Explanation:
Testcase 2: Since, k = 4. So, we have to reverse everty group of two elements.
 Modified linked list is as 4, 2, 2, 1, 8, 7, 6, 5.
 */