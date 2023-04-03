public class Main {
    public static void main(String[] args) {
        CarBuilder builder1 = new SportsCarBuilder();
        AutoEngineer engineer1 = new AutoEngineer(builder1);
        Car car1 = engineer1.assemblyCar();
        System.out.println();
        CarBuilder builder2 = new TrucksBuilder();
        AutoEngineer engineer2 = new AutoEngineer(builder2);
        Car car2 = engineer2.assemblyCar();
    }
}