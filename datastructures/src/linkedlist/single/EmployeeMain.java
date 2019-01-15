package datastructures.linkedlist.single;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee jane = new Employee("Jane", 42);
        Employee jones = new Employee("Jones", 31);
        Employee mary = new Employee("Mary", 37);
        Employee mike = new Employee("Mike", 28);

        EmployeeLinkedList list = new EmployeeLinkedList();

        System.out.println(list.isEmpty());
        list.addToFront(jane);
        list.addToFront(jones);
        list.addToFront(mary);
        list.addToFront(mike);

        list.printList();

        System.out.println(list.getSize());

        list.removeFromFront();
        System.out.println(list.getSize());
        list.printList();
    }
}
