public class SportsCarBuilder implements CarBuilder {

    private String body;
    private String interior;

    public SportsCarBuilder() {
        super();
    }

    @Override
    public CarBuilder fix() {
        body = "Sporty body";
        System.out.println("fix sports car");
        return this;
    }

    @Override
    public CarBuilder modify() {
        interior = "Sporty interior";
        System.out.println("modify sports car");
        return this;
    }

    @Override
    public Car build() {
        System.out.println("build sports car");
        return new Car(body, interior);
    }
}
