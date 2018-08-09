import java.util.Arrays;
import java.util.Scanner;

public class StringTokens {
    static Scanner scan = new Scanner(System.in);
    public static void main(String [] args){
        String line = scan.nextLine();
        line = line.trim();

        if(line.length()==0){
            System.out.println(line.length());
        }
        else {
            String[] strArray = line.split("[^a-zA-Z]+");
            System.out.println(strArray.length);
            Arrays.stream(strArray).forEach(System.out::println);
        }
        scan.close();
    }
}
