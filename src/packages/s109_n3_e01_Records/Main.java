package s109_n3_e01_Records;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Alice", 25),
                new Person("Bob", 15),
                new Person("Charlie", 40),
                Person.createAnonymous(19)
        );

        // Filter people older than 18
        List<Person> adults = people.stream()
                .filter(p -> p.age() >= 18)
                .toList();

        adults.forEach(x -> System.out.println(x.greet()));
    }
}
