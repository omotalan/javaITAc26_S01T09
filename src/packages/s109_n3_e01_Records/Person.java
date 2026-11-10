package s109_n3_e01_Records;

public record Person(String name, int age) {

    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }

    public String greet() {
        return "Hello, my name is " + name + " and I am " + age + " years old.";
    }

    public static Person createAnonymous(int age) {
        return new Person("Anonymous", age);
    }
}


