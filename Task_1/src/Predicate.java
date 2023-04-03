import java.util.ArrayList;

@FunctionalInterface
public interface Predicate<T> {
    Boolean containsStudent(ArrayList<T> students);
}

