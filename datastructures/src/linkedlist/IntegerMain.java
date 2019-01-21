package linkedlist;

public class IntegerMain {
    public static void main(String[] args) {
        IntegerNode one = new IntegerNode(1);
        IntegerNode two = new IntegerNode(2);
        IntegerNode four = new IntegerNode(4);
        IntegerNode five = new IntegerNode(5);

        IntegerLinkedList list = new IntegerLinkedList();
        list.sortedInsert(4);
        list.sortedInsert(2);
        list.sortedInsert(1);
        list.sortedInsert(5);

        list.printList();
    }
}
