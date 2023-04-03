
// С ленивой инициализацией,
// но шанс возникновения исключительных ситуаций в конструкторе

public class Singleton2 {
    public Singleton2() {
    }

    private static class SingletonHolder {
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
