package bitmanipulation;

public class MagicNumber {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(magicNumberCalculater(n));
    }

    private static int magicNumberCalculater(int k) {
        String binaryNum = Integer.toBinaryString(k);
        int binaryVal = Integer.parseInt(binaryNum);
        int l = 1, sum = 0;
        for (int i = binaryVal; i > 0; i = i / 10) {
            if (i % 10 == 1)
                sum += 1 * Math.pow(5, l);
            l++;
        }
        return sum;
    }
}

/*
5, 25, 30(5 + 25), 125, 130(125 + 5), 150(125 + 25), 155(5 + 150),...
 */