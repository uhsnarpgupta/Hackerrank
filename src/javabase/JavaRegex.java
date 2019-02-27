package javabase;

import java.util.Scanner;

public class JavaRegex {
    public static void main(String []args) {
        Scanner in = new Scanner(System.in);

        //1st way
        //Pattern p = Pattern.compile(".s");//. represents single character
        //Matcher m = p.matcher("as");
        //boolean b = m.matches();

        //2nd way
        //boolean b2=Pattern.compile(".s").matcher("as").matches();

        //3rd way
        //boolean b3 = Pattern.matches(".s", "as");

        while(in.hasNext()) {
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }
}

/*
     [01]?\\d{1,2}   matches numbers 0-199.
     2[0-4]\\d       matches numbers 200-249
     25[0-5]         matches numbers 250-255
*/
class MyRegex {
    String num = "([01]?\\d{1,2}|2[0-4]\\d|25[0-5])";
    String pattern = num + "." +  num + "." +  num + "." + num;
}
