// Фабричный метод — это порождающий паттерн проектирования,
// который решает проблему создания различных продуктов, без указания конкретных классов продуктов.
// Фабричный метод задаёт метод, который следует использовать вместо вызова оператора new для создания объектов-продуктов.
// Определяет общий интерфейс для создания объектов в суперклассе, позволяя подклассам изменять тип создаваемых объектов.
public class Main {
    public static void main(String[] args) {
        CheeseDairy moscowCheese = new MoscowCheeseDairy();
        moscowCheese.orderCheese(CheeseType.GOUDA);

        CheeseDairy krasnodarCheese = new KrasnodarCheeseDairy();
        krasnodarCheese.orderCheese(CheeseType.CHEDDAR);
    }
}