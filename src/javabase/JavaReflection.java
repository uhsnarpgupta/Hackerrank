package javabase;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class JavaReflection {
    public static void main(String[] args) {
        Class student = Student.class;
        Method[] methods = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for (Method method : methods) {
            methodList.add(method.getName());
        }
        Collections.sort(methodList);
        for (String name : methodList) {
            System.out.println(name);
        }

        String a = "asd";

        System.out.println(student.getCanonicalName());
        System.out.println(student.getSimpleName());
        System.out.println(student.getName());
        System.out.println(student.getClassLoader());
        System.out.println(student.desiredAssertionStatus());
    }
}
