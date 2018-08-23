import java.math.BigInteger;
import java.util.*;

public class MiniMaxSum extends ArrayList{
    static Scanner scanner = new Scanner(System.in);

    public static void main(String [] agrs){
        int [] arr = new int[5];
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();

        BigInteger [] bArray = new BigInteger[5];

        BigInteger min = BigInteger.ZERO;
        BigInteger max = BigInteger.ZERO;
        BigInteger sum = BigInteger.ZERO;
        for(int i = 0; i < 5; i++){
            bArray[i] = BigInteger.valueOf(scanner.nextInt());
            /*BigInteger num = BigInteger.valueOf(arr[i]);
            sum = num.add(sum);*/
        }

        Arrays.sort(bArray);
        for(int l = 0; l < bArray.length - 1; l++){
            min = min.add(bArray[l]);
        }

        Arrays.sort(bArray, Collections.reverseOrder());
        for(int l = 0; l < bArray.length - 1; l++){
            max = max.add(bArray[l]);
        }

/*
        for(int k = 0; k < arr.length; k++){
            max = Math.max(max, sum.subtract(BigInteger.valueOf(arr[k])));
            min = Math.min(min, sum - arr[k]);
            System.out.println("Min: "+min+" Max: "+max+" Difference: "+(sum-arr[k]));

        }
            list.forEach(System.out::print);*/

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
