package stack;

import java.util.Stack;

public class StackCheck {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        Integer removedElement = stack.pop();
        Integer topElement = stack.peek();
        boolean isStackEmpty = stack.empty();
    }
}
