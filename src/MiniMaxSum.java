import java.math.BigInteger;
import java.util.*;

public class MiniMaxSum {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String [] agrs){
        int [] arr = new int[5];
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        BigInteger sum = BigInteger.ZERO;
        for(int i = 0; i < 5; i++){
            arr[i] = scanner.nextInt();
            BigInteger num = BigInteger.valueOf(arr[i]);

            sum += num;
        }
        System.out.println("Sum: "+sum);

        for(int k = 0; k < arr.length; k++){
            max = Math.max(max, sum - arr[k]);
            min = Math.min(min, sum - arr[k]);
            System.out.println("Min: "+min+" Max: "+max+" Difference: "+(sum-arr[k]));

        }
            list.forEach(System.out::print);

        //Collections.addAll(list, Arrays.stream(arr).boxed().toArray(Integer[]::new));

        /*lists = subListArray(list);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(ArrayList<Integer> lt : lists){
            if(lt.size()==4) {
                int sum = 0;
                for (Integer t : lt) {
                    sum += t;
                }
                max = Math.max(max, sum);
                min = Math.min(min, sum);
            }
        }*/
        System.out.println(min+" "+max);

    }

    private static ArrayList<ArrayList<Integer>> subListArray(List<Integer> list) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            for(int j = i; j <= list.size(); j++){
                ArrayList<Integer> subList = new ArrayList<>();
                for(int k = i; k < j; k++){
                    subList.add(list.get(k));
                }
                lists.add(subList);
            }
        }
        return lists;
    }
}
