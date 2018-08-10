public class SingletonPattern {
    private SingletonPattern() {}
    public String str;
    private static SingletonPattern instance = null;
    public static SingletonPattern getSingleInstance() {
        if (instance == null) {
            instance = new SingletonPattern();
        }
        return instance;
    }
}
