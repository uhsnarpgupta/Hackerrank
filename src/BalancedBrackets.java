import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    private static final Scanner scan = new Scanner(System.in);
    private static int[] x;

    public static void main(String[] args) throws IOException {
        byte var1 = -51, var2 = -28;
        //System.out.println( var1 & var2);
        int n = scan.nextInt();
        //int i = (int) Math.random();
        //System.out.println(x[0]);
        //System.out.println(i);
        while (n-- > 0) {
            isBalanced(scan.nextLine());
        }
        /*List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());*/
    }

    private static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == '{') {
                stack.push('{');
            } else if (s.charAt(i) == '[') {
                stack.push('[');
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '(') return false;
            } else if (s.charAt(i) == '}') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '{') return false;
            } else if (s.charAt(i) == ']') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
