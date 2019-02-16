import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*int n = scanner.nextInt();

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        int temp = Integer.MIN_VALUE;

        while (n-- > 0) {
            int k = scanner.nextInt();
            switch (k) {
                case 1:
                    int item = scanner.nextInt();
                    stack.push(item);
                    if (maxStack.isEmpty() || maxStack.peek() <= temp) {
                        maxStack.push(item);
                    }
                    break;
                case 2:
                    temp = stack.pop();
                    if (temp == maxStack.peek()) {
                        maxStack.pop();
                    }
                    break;
                case 3:
                    maxStack.peek();
                    //System.out.println(Collections.max(stack));
                    //System.out.println(stack.stream().max(Comparator.naturalOrder()).get());
                    //System.out.println(stack.stream().reduce(Long::max));
                    break;
            }
        }
        maxStack.forEach(System.out::println);*/
        otherWay();
    }

    private static void otherWay() {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> onlyMaxs = new Stack<Integer>();

        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        int temp = 0;
        while (sc.hasNext()) {
            String type[] = sc.nextLine().split(" ");
            switch (type[0]) {
                case "1":
                    temp = Integer.parseInt(type[1]);
                    stack.push(temp);
                    if (onlyMaxs.isEmpty() || onlyMaxs.peek() <= temp)
                        onlyMaxs.push(temp);
                    break;
                case "2":
                    temp = stack.pop();
                    if (temp == onlyMaxs.peek())
                        onlyMaxs.pop();
                    break;
                case "3":
                    System.out.println(onlyMaxs.peek());
            }
            N--;
        }

        while (N-- > 0)
            System.out.println(onlyMaxs.peek());

    }
}
