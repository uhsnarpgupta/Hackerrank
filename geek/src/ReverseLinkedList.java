public class ReverseLinkedList {
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

        reverse(head);
    }

    private static LinkNode reverse(LinkNode head) {
        LinkNode current = head;
        LinkNode prev = null;

        while (current != null) {
            head = current.next;
            current.next = prev;
            prev = current;
            current = head;
        }
        return prev;
    }

}

class LinkNode {
    int value;
    LinkNode next;

    LinkNode(int value) {
        this.value = value;
    }
}
