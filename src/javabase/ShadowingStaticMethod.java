package javabase;

public class ShadowingStaticMethod {
    public static void main(String args[]) {
        A a = new B();
        a.fun();  // prints A.fun()
    }
}

class A {
    static void fun() {
        System.out.println("A.fun()");
    }
}

class B extends A {
    static void fun() {
        System.out.println("B.fun()");
    }
}
/*
If we make both A.fun() and B.fun() as non-static then the above program would print “B.fun()”.
 */
