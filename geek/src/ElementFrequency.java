import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ElementFrequency {

    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());
        while (testCaseCount-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Integer[] input = new Integer[n];
            String str = br.readLine();
            String[] inputArray = str.trim().split("\\s+");
            for (int i = 0; i < n; i++) {
                input[i] = Integer.parseInt(inputArray[i]);
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (Integer number : input) {
                if (map.containsKey(number)) {
                    map.put(number, map.get(number) + 1);
                } else {
                    map.put(number, 1);
                }
            }

            for (int i = 0; i < n; i++) {
                int freq = map.get(i + 1) != null ? map.get(i + 1) : 0;
                System.out.print(freq + " ");
            }
        }

    }*/

    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                int k = sc.nextInt()-1;
                arr[k]++;
            }
		    /*for(int i=0;i<n;i++){
		        System.out.print(arr[i]+" ");
		    }
		    System.out.println();*/
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++)
                sb.append(arr[i] + " ");
            System.out.println(sb);

        }
    }

    static int[] frequencyCounter(int[] inputArray) {
        return null;
    }
}
