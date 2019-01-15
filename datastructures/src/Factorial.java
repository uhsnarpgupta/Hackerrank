package datastructures;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(recursiveFactorial(5));

    }

    private static int factorial(int number) {
        int factorial = 1;
        for (int i = number; i > 0; i--) {
            factorial *= i;
        }
        return factorial;
    }

    private static int recursiveFactorial(int number) {
        if (number == 0) {
            return 1;
        } else {
            return number * recursiveFactorial(number - 1);
        }
    }
}
