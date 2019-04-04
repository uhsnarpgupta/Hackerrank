package linkedlist.circular;

public class Node<E> {
    Node<E> next;
    E value;

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }

    public String getValue() {
        return value.toString();
    }
}
