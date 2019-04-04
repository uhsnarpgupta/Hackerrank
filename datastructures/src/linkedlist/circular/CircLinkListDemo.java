package linkedlist.circular;

public class CircLinkListDemo {
    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.insertAtHead(1);
        list.insertAtHead(5);
        list.insertAtHead(2);
        list.insertAtHead(4);
        list.insertAtHead(9);

        int size = list.getSize();

        System.out.println(size);

        list.deleteAtPos(2);

        list.displayList();
    }
}
