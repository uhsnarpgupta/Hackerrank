import com.sun.tools.javac.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Palindrome {

    static Scanner scanner = new Scanner(System.in);

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String [] args) throws IOException {
        String s = scanner.next();

        /* Reverse string and compare to original */
        //String reversed = new StringBuilder(s).reverse().toString();
        //System.out.println(s.equals(reversed) ? "Yes" : "No");


        String str = scanner.nextLine();
        String reverse = "";

        for(int i = str.length() - 1; i >= 0; i--){
            reverse = reverse + str.charAt(i);
        }

        System.out.println(str.equals(reverse) ? "Yes" : "No");
        scanner.close();
    }
}
