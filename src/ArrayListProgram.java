import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArrayListProgram {
    static Scanner scan = new Scanner(System.in);
    public static void main(String [] args){
        int n = scan.nextInt();
        ArrayList<Integer> sizeArray = new ArrayList<Integer>();
        ArrayList<Object> resultArray = new ArrayList<Object>();
        Map<Integer, ArrayList> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int k = scan.nextInt();
            sizeArray.add(k);
            ArrayList<Integer> array = new ArrayList<Integer>();
            for(int j = 0; j < k; j++){
                array.add(scan.nextInt());
            }
            map.put(i+1, array);
        }
        int p = scan.nextInt();
        for(int o = 0; o < p; o++){
            int l = 0;
            ArrayList<Integer> querryArray = new ArrayList<Integer>();
            while(l < 2) {
                querryArray.add(scan.nextInt());
                l++;
            }
            if(sizeArray.get(querryArray.get(0)-1)>=querryArray.get(1) && map.get(querryArray.get(0)).get(querryArray.get(1)-1)!=null){
                resultArray.add(map.get(querryArray.get(0)).get(querryArray.get(1)-1));
            }
            else{
                resultArray.add("ERROR!");
            }
        }
        resultArray.forEach(System.out::println);
    }
    /*
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        // Save numbers in 2-D ArrayList
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
            for (int row = 0; row < n; row++) {
            int d = scan.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int col = 0; col < d; col++) {
                list.add(scan.nextInt());
            }
            lists.add(list);
        }

        //Answer the queries
        int q = scan.nextInt();
            for (int i = 0; i < q; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            ArrayList<Integer> list = lists.get(x-1);
            if (y <= list.size()) {
                System.out.println(list.get(y-1));
            } else {
                System.out.println("ERROR!");
            }
    }*/
}
