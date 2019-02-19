import java.util.Scanner;

public class SeatingArrangement {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int total = s.nextInt();
        for (int i = 0; i < total; i++) {
            int seat = s.nextInt();
            System.out.println(oppositeSeat(seat));
        }
    }

    private static StringBuilder oppositeSeat(int seatNo) {
        StringBuilder sb = new StringBuilder();
        int i = seatNo / 12;
        int j = seatNo % 12;
        int oppSeatNo;
        if (j == 0) {
            oppSeatNo = ((i - 1) * 12) + 1;
        } else {
            oppSeatNo = (i * 12) + (13 - j);
        }
        String seatType = "";
        if (j == 0 || j == 1 || j == 6 || j == 7) {
            seatType = "WS";
        } else if (j == 2 || j == 5 || j == 8 || j == 11) {
            seatType = "MS";
        } else {
            seatType = "AS";
        }
        return sb.append(oppSeatNo).append(" ").append(seatType);
    }
}
/*
https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/seating-arrangement-1/
 */
