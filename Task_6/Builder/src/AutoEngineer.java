public class AutoEngineer {
    private CarBuilder builder;

    public AutoEngineer(CarBuilder builder) {
        super();
        this.builder = builder;
    }

    public Car assemblyCar() {
        return builder.fix().modify().build();
    }
}
