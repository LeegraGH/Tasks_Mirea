public class Car {
    private String body;
    private String interior;

    public Car() {
        super();
    }

    public Car(String body, String interior) {
        this.body = body;
        this.interior = interior;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }


    public String getBody() {
        return body;
    }


    public String getInterior() {
        return interior;
    }
}
