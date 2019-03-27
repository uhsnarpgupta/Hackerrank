public class Overridin {
    public static void main(String[] args) {
        A obj = new A();
        System.out.println("Integer called: " +obj.calc(1,2));
        System.out.println("Method called: " +obj.calc(1L,2));
        System.out.println("Method called: " +obj.calc(1L,2D));
        System.out.println("Method called: " +obj.calc(1L,2f));
        System.out.println("Method called: " +obj.calc(1D,2f));


    }
}

class A{

    short calc(short a, short b){
        System.out.println("Short called");
        return (short) (a+b);
    }

    int calc(int a, int b){
        System.out.println("Integer called");
        return a+b;
    }

    long calc(long a, long b){
        System.out.println("Long called");
        return a+b;
    }

    float calc(float a, float b){
        System.out.println("Float called");
        return a+b;
    }

    double calc(double a, double b){
        System.out.println("Double called");
        return a+b;
    }
}