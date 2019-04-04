package linkedlist.circular;

public class CircularLinkedList<E> {
    //For better O.O design this should be private allows for better black box design
    private int size;

    //this will point to dummy node;
    private Node<E> head;

    private Node<E> tail;

    /* constructer for class.. here we will make a dummy node for circly linked list implementation with reduced error
    catching as our list will never be empty */
    public CircularLinkedList() {
        //creation of the dummy node
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // getter for the size... needed because size is private.
    public int getSize() {
        return size;
    }

    /* for the sake of simplistiy this class will only contain the append function or addLast other add functions can
    be implemented however this is the basses of them all really.*/
    public void insertAtHead(E value) {
        Node<E> newNode = new Node<E>(value, null);
        newNode.next = head;
        if (value == null) {
            // we do not want to add null elements to the list.
            throw new NullPointerException("Cannot add null element to the list");
        }
        if (head == null) {
            head = newNode;
            newNode.next = head;
            tail = head;
        } else {
            tail.next = newNode;
            head = newNode;
        }
        size++;
    }

    public void insertAtTail(E value) {
        Node<E> newNode = new Node<E>(value, null);
        newNode.next = head;
        if (value == null) {
            throw new NullPointerException("Cannot add null element to the list");
        }
        if (head == null) {
            head = newNode;
            newNode.next = head;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void insertAtPos(E value, int pos) {
        Node<E> newNode = new Node<E>(value, null);
        Node<E> ptr = head;

        pos = pos - 1;

        for (int i = 1; i < size - 1; i++) {
            if (i == pos) {
                Node<E> temp = ptr.next;
                ptr.next = newNode;
                newNode.next = temp;
                break;
            }
            ptr = ptr.next;
        }
        size++;
    }

    public void deleteAtPos(int pos) {
        if (size == 1 && pos == 1) {
            head = null;
            tail = null;
            size = 0;
            return;
        }
        if (pos == 1) {
            head = head.next;
            tail.next = head;
            size--;
            return;
        }
        if (pos == size) {
            Node s = head;
            Node t = head;
            while (s != tail) {
                t = s;
                s = s.next;
            }
            tail = t;
            tail.next = head;
            size--;
            return;
        }
        Node ptr = head;
        pos = pos - 1;
        for (int i = 1; i < size - 1; i++) {
            if (i == pos) {
                Node tmp = ptr.next;
                tmp = tmp.next;
                ptr.next = tmp;
                break;
            }
            ptr = ptr.next;
        }
        size--;
    }

    public E remove(int pos) {
        if (pos > size || pos < 0) {
            //catching errors
            throw new IndexOutOfBoundsException("position cannot be greater than size or negative");
        }
        Node<E> iterator = head.next;

        //we need to keep track of the element before the element we want to remove we can see why below.
        Node<E> before = head;
        for (int i = 1; i <= pos; i++) {
            iterator = iterator.next;
            before = before.next;
        }
        E saved = iterator.value;

        /* assigning the next referance to the the element following the element we want to remove...
        the last element will be assigned to the head. */
        before.next = iterator.next;

        // scrubbing
        iterator.next = null;
        iterator.value = null;
        return saved;
    }

    /**
     * Prints contents of the list
     */
    public void display() { // Prints contents of the list
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    /* Function to display contents */
    public void displayList() {
        System.out.print("\nCircular Singly Linked List = ");
        Node ptr = head;
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }
        if (head.next == head) {
            System.out.print(head.getValue() + "->" + ptr.getValue() + "\n");
            return;
        }
        System.out.print(head.getValue() + "->");
        ptr = head.next;
        while (ptr.next != head) {
            System.out.print(ptr.next.getValue() + "->");
            ptr = ptr.next;
        }
        System.out.print(ptr.getValue() + "->");
        ptr = ptr.next;
        System.out.print(ptr.getValue() + "\n");
    }
}
