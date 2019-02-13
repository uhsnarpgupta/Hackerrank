import java.util.Scanner;

public class SubstringComparison {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        smallest = s.substring(0,k);
        largest = smallest;
        for(int i = 1; i< s.length()-k+1; i++){
            String currentString = s.substring(i, i + k);
            if(smallest.compareTo(currentString)>0){
                smallest = currentString;

            }
            if (largest.compareTo(currentString)<0){
                largest = currentString;
            }
        }

        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
        System.out.println(getSmallestAndLargest(s, k));
    }

}
