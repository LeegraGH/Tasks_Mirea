// Без ленивой инициализации (объект создается при инициализации класса),
// с многопоточностью, возможное появление исключительных ситуаций в конструкторе
// лучше не использовать
public class Singleton1 {
    private static final Singleton1 INSTANCE = new Singleton1();

    public Singleton1() {
    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
