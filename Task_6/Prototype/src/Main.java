public class Main {
    public static void main(String[] args) {
        CloneObject obj = new CloneObject(1);
        CloneObject cloneObj = obj.copy();
        System.out.println("Type of object - " + obj.getTypeObj());
        System.out.println("Type of clone - " + cloneObj.getTypeObj());
    }
}