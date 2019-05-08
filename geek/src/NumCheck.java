public class NumCheck {
    /*public static void main(String args[])
    {
        short s = 0;
        int x = 07;
        int y = 08;
        int z = 112345;

        s += z;
        System.out.println("" + x + y + s);
    }*/
    static int num;
    static String mystr;

    // First Static block
    static {
        System.out.println("Static Block 1");
    }

    // Second static block
    static {
        System.out.println("Static Block 2");
        num = 98;
        mystr = "Block2";
    }

    {
        System.out.println("Static Block 0");
        mystr = "Block1";
    }

    {
        System.out.println("Static Block 0-1");
    }

    // constructor
    NumCheck() {
        num = 100;
        mystr = "Constructor";
    }

    public static void main(String args[]) {
        NumCheck a = new NumCheck();
        System.out.println("Value of num = " + a.num);
        System.out.println("Value of mystr = " + a.mystr);
    }
}
