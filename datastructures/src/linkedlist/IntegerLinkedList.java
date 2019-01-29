package linkedlist;

public class IntegerLinkedList {
    private IntegerNode head;
    private int size;

    public void addToFront(Integer employee) {
        IntegerNode node = new IntegerNode(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    public boolean sortedInsert(Integer newNode) {
        if (head == null || head.getInteger() >= newNode) {
            addToFront(newNode);
            return true;
        }

        IntegerNode current = head.getNext();
        IntegerNode previous = head;

        while (current != null && current.getInteger() < newNode) {
            previous = current;
            current = current.getNext();
        }

        IntegerNode node = new IntegerNode(newNode);
        node.setNext(current);
        previous.setNext(node);

        /*if (current == null) {
            head = node;
        } else if (current.getInteger() > newNode) {
            if (current == head) {
                head = node;
            }
            node.setNext(current);
        } else {
            while (current != null) {
                IntegerNode next = current.getNext();
                if (next == null) {
                    current.setNext(node);
                    break;
                }
                if(next !=null && next.getInteger()>newNode){
                    node.setNext(next);
                    current.setNext(node);
                    break;
                }
                current = next;
            }
        }*/
        size++;
        return true;
    }

    public static IntegerNode reverse(IntegerNode node, int k) {
        IntegerNode curr = node,
                prev = null,
                next = null;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
            count++;
        }

        if (next != null)
            node.setNext(reverse(next, k));
        return prev;
    }

    IntegerNode reverse(IntegerNode head) {
        IntegerNode temp = head;
        IntegerNode prev = null;

        while (temp != null) {
            head = head.getNext();
            temp.setNext(prev);
            prev = temp;
            temp = head;
        }
        return prev;
    }

    public void printList() {
        IntegerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
