import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class VarArgsAddition {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            int n6 = Integer.parseInt(br.readLine());
            Add ob = new Add();
            ob.add(n1, n2);
            ob.add(n1, n2, n3);
            ob.add(n1, n2, n3, n4, n5);
            ob.add(n1, n2, n3, n4, n5, n6);
            Method[] methods = Add.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Use a StringBuffer instead of a String since
// concatening Strings is not efficient.
class Add {
    void add(int... numbers) {
        StringBuffer sb = new StringBuffer();
        int sum = 0;
        for (int num : numbers) {
            sb.append(num + "+");
            sum += num;
        }
        sb.setCharAt(sb.length() - 1, '=');
        sb.append(sum);
        System.out.println(sb);
    }
}

/*
class Add {
    void add(int... args) {
        int sum = 0;
        for (int k = 0; k < args.length; k++) {
            sum += args[k];
            String string = (k == args.length - 1) ? "=" : "+";
            System.out.print(args[k] + string);
        }
        System.out.println(sum);
    }
}*/