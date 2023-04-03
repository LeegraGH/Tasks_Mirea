import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

//Сортировка по последней букве фамилии,
//фильтрация по признаку «возраст больше, чем вес»,
//сортировка по дате рождения,
//произведение всех возрастов.

public class Main {
    public static void main(String[] args) {
        ArrayList<Human> people = new ArrayList<>();
        people.add(new Human(20,"Oleg","Petrenko", LocalDate.of(2002,8,5),78));
        people.add(new Human(14,"Ivan","Krutov", LocalDate.of(2009,1,14),58));
        people.add(new Human(65,"Masha","Trolova", LocalDate.of(1956,12,11),48));

        System.out.println("Начальный список");
        Stream<Human> stream = people.stream();
        stream.forEach(System.out::println);

        // Сортировка по последней букве фамилии
        System.out.println("\nСортировка по последней букве фамилии");
        Stream<Human> streamOne = people.stream();
        streamOne.sorted(Comparator.comparing(Human::lastLetterOfLastName)).forEach(System.out::println);

        // Фильтрация по признаку «возраст больше, чем вес»
        System.out.println("\nФильтрация по признаку «возраст больше, чем вес»");
        Stream<Human> streamTwo = people.stream();
        streamTwo.filter(human -> human.getAge() > human.getWeight()).forEach(System.out::println);

        // Сортировка по дате рождения
        System.out.println("\nСортировка по дате рождения");
        Stream<Human> streamThree = people.stream();
        streamThree.sorted(Comparator.comparing(Human::getBirthDate)).forEach(System.out::println);

        // Произведение всех возрастов
        System.out.println("\nПроизведение всех возрастов");
        Stream<Human> streamFour = people.stream();
        int multiplyAges=streamFour.map(Human::getAge).reduce(1,(a,b)->a*b);
        System.out.println(multiplyAges);
    }
}