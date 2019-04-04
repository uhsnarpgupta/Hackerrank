package bitmanipulation;

public class SwapBits {
    public static void main(String[] args) {
        int inp = 23;
        System.out.println(swapBits(inp));
    }

    static int swapBits(int x) {
        // Get all even bits of x
        int even_bits = x & 0xAAAAAAAA;

        // Get all odd bits of x
        int odd_bits = x & 0x55555555;

        // Right shift even bits
        even_bits >>= 1;

        // Left shift even bits
        odd_bits <<= 1;

        // Combine even and odd bits
        return (even_bits | odd_bits);
    }
}
