import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class Immute {
    private final int a;

    private final List<Integer> lt;

    public Immute(int a) {
        this.a = a;
        lt = new ArrayList<>();
        lt.add(a);
    }

    public int getA() {
        return a;
    }

    public List<Integer> getLt() {
        return ((List) ((ArrayList) lt).clone());
    }
}

class B {

    public static void main(String[] args) {
        Immute i = new Immute(10);
        i.getA();

        List<Integer> li = i.getLt();
        li.add(5);

        List<Integer> lii = i.getLt();

        //Immute class = Immute.class;
        //i.setA(5);

        Class classI = i.getClass();
        System.out.println(classI.getName());
        // of the class by using getMethods
        Method[] methods = classI.getMethods();

        // Printing method names
        for (Method method : methods)
            System.out.println(method.getName());
        //Class.get("a", int)


    }
}
