public class Main {
    public static void main(String[] args) {
        String name = "Razer";
        CompanyHardware company;
        switch (name) {
            case "Razer":
                company = new CompanyHardware(new Razer());
                break;
            case "Logitech":
                company = new CompanyHardware(new Logitech());
                break;
        }
    }
}


