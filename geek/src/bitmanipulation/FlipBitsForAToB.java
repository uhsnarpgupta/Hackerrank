package bitmanipulation;

public class FlipBitsForAToB {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        System.out.println(countBitsToBeFlipped(a, b));
    }

    private static int countBitsToBeFlipped(int a, int b) {
        String binaryA = Integer.toBinaryString(a);
        String binaryB = Integer.toBinaryString(b);
        String binaryC = Integer.toBinaryString(a ^ b);
        int count = 0;
        for (int i = 0; i < binaryC.length(); i++) {
            if (binaryC.charAt(i) == '1') count++;
        }
        return count;
    }
}
