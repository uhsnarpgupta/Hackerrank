package creational.singleton;

import java.io.*;

public class BasicSingleton implements Serializable {
    private static final BasicSingleton INSTANCE = new BasicSingleton();
    private int value = 0;

    private BasicSingleton() {
    }

    public static BasicSingleton getInstance() {
        return INSTANCE;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // fixes problem in case of serialization giving two different object instances
    protected Object readResolve() {
        return INSTANCE;
    }
}

class Demo {
    static void saveToFile(BasicSingleton singleton, String filename) throws Exception {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(singleton);
        }
    }

    static BasicSingleton readFromFile(String filename) throws Exception {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (BasicSingleton) in.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        /*
        Issues in using Singleton pattern
        1. reflection can chnage private constructor to public, so single object not guaranteed
        2. serialization
         */
        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(111);

        String fileName = "C:\\Users\\pragupta14\\IdeaProjects\\Hackerrank\\designPatterns\\creational.singleton.bin";
        saveToFile(singleton, fileName);

        singleton.setValue(222);

        BasicSingleton singleton2 = readFromFile(fileName);
        System.out.println(singleton == singleton2);

        System.out.println(singleton.getValue());
        System.out.println(singleton2.getValue());
    }
}