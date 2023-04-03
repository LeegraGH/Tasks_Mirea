import java.util.ArrayList;


//Имплементировать интерфейс Predicate, определяющий,
//содержит ли массив студентов студента с максимальным количеством баллов
//(максимальное значение – 100)

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> students=new ArrayList<>();

        students.add(54);
        students.add(23);
        students.add(100);
        students.add(18);
        students.add(76);

        Predicate<Integer> check = allStudents -> {
            for (Integer student : allStudents) {
                if (student == 100) return true;
            }
            return false;
        };

        System.out.println(check.containsStudent(students));
    }
}