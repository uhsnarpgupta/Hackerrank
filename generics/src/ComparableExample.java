import java.util.Date;

public class ComparableExample {
    public static void main(String[] args) {
        //prior to java 5
        Comparable c = new Date();
        System.out.println(c.compareTo("Monday"));

        //Comparable<Date> c2 = new Date();
        //System.out.println(c2.compareTo("Monday"));
    }
}
