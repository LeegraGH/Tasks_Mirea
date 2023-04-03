public class Main {
    public static void main(String[] args) {
        String[] skills = {"Java", "Spring", "Maven" };

        JavaDeveloper dev = new JavaDeveloper("Jhon", skills);

        Iterator iterator = dev.getIterator();
        System.out.println("Developer: " + dev.getName());
        System.out.println("Skills: ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }
}