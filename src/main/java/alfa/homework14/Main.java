package alfa.homework14;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        List<Movie> movies = new ArrayList<>() {{
            add(new Movie("Интерстеллар", 8.7));
            add(new Movie("Шрек", 8.1));
            add(new Movie("Начало", 8.8));
            add(new Movie("Веном", 6.6));
        }};
        System.out.println(movies);
        movies.sort(new MovieRatingComparator());
        System.out.println(movies);

        // Вывожу только поля, методы и конструкторы конкретного класса, без наследованных
        Animal animal = new Animal();
        ClassScanner.scan(animal);
    }
}
