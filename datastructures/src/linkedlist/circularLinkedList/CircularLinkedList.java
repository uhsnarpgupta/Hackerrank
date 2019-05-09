package linkedlist.circularLinkedList;

import java.util.Arrays;

public class CircularLinkedList {
    private Node start;
    private Node end;
    private int size;

    public CircularLinkedList() {
        this.start = null;
        this.end = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.start == null;
    }

    public int getSize() {
        return this.size;
    }

    public void insertAtStart(int val) {
        Node newNode = new Node(val, null);
        newNode.setLink(start);

        if (start == null) {
            start = newNode;
            newNode.setLink(start);
            end = start;
        } else {
            end.setLink(newNode);
            start = newNode;
        }
        size++;
    }

    public void insertAtEnd(int val) {
        Node newNode = new Node(val,null);
        newNode.setLink(start);
        if (start == null) {
            start = newNode;
            newNode.setLink(start);
            end = start;
        } else {
            end.setLink(newNode);
            end = newNode;
        }

        size++;
    }
}
