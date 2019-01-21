package stack.linkedlistimpl;

public class EmployeeMain {
    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push(new Employee("Jane", 22));
        stack.push(new Employee("John", 24));
        stack.push(new Employee("Mary", 29));
        stack.push(new Employee("Mike", 32));
        stack.push(new Employee("Bill", 30));

        stack.printStack();
        System.out.println("Peek Value: " + stack.peek());
        System.out.println("Pop Value: " + stack.pop());

        stack.printStack();
    }
}
