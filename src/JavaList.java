import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scan.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scan.nextInt());
        }
        int k = scan.nextInt();
        for (int p = 0; p < k; p++) {
            switch (scan.next()) {
                case "Insert":
                    int pos = scan.nextInt();
                    int num = scan.nextInt();
                    list.add(pos, num);
                    break;
                case "Delete":
                    int posi = scan.nextInt();
                    list.remove(posi);
                    break;
                default:
                    break;
            }
        }
        list.stream().forEach(num -> System.out.print(num + " "));
    }
}
