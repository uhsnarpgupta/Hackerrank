package creational.singleton;

public class InnerStaticSingleton {
    private InnerStaticSingleton() {
    }

    public InnerStaticSingleton getInstance() {
        return Impl.INSTANCE;
    }

    private static class Impl {
        private static final InnerStaticSingleton INSTANCE = new InnerStaticSingleton();
    }
}
