package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorInterface {
    public static void main(String[] args) {
        ArrayList<Student> ar = new ArrayList<>();
        ar.add(new Student(111, "bbbb", "london"));
        ar.add(new Student(131, "aaaa", "nyc"));
        ar.add(new Student(121, "cccc", "jaipur"));

        System.out.println("Unsorted");
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));

        Collections.sort(ar, new Sortbyroll());

        System.out.println("\nSorted by rollno");
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));

        Collections.sort(ar, new Sortbyname());

        Collections.sort(ar, (o1, o2) -> o1.name.compareTo(o2.name));
        Collections.sort(ar, Comparator.comparing(Student::getName));


        System.out.println("\nSorted by name");
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));
    }
}

class Student {
    int rollno;
    String name, address;

    // Constructor
    public Student(int rollno, String name,
                   String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    // Used to print student details in main()
    public String toString() {
        return this.rollno + " " + this.name +
                " " + this.address;
    }
}

class Sortbyroll implements Comparator<Student> {
    // Used for sorting in ascending order of
    // roll number
    public int compare(Student a, Student b) {
        return a.rollno - b.rollno;
    }
}

class Sortbyname implements Comparator<Student> {
    // Used for sorting in ascending order of
    // roll name
    public int compare(Student a, Student b) {
        return a.name.compareTo(b.name);
    }
}
