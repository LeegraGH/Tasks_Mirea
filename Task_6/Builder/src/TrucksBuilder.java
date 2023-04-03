public class TrucksBuilder implements CarBuilder {

    private String body;
    private String interior;

    @Override
    public CarBuilder fix() {
        body = "Truck body";
        System.out.println("fix truck");
        return this;
    }

    @Override
    public CarBuilder modify() {
        interior = "Truck interior";
        System.out.println("modify truck");
        return this;
    }

    @Override
    public Car build() {
        System.out.println("build truck");
        return new Car(body, interior);
    }
}
