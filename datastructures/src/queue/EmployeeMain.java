package queue;

public class EmployeeMain {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);

        Employee jane = new Employee("Jane", 42);
        Employee jones = new Employee("Jones", 31);
        Employee mary = new Employee("Mary", 37);
        Employee mike = new Employee("Mike", 28);
        Employee hary = new Employee("Hary", 28);
        Employee jamie = new Employee("Jamie", 32);

        queue.add(jane);
        queue.add(jones);
        queue.add(mary);
        queue.add(mike);
        queue.add(hary);
        queue.add(jamie);

        queue.printQueue();
        System.out.println("Peek Value: " + queue.peek());

        queue.remove();
        queue.printQueue();
    }
}
