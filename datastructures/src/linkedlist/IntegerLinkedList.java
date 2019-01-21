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
