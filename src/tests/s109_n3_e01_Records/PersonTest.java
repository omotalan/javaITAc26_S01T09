package s109_n3_e01_Records;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    @DisplayName("Should successfully create a valid Person record")
    void shouldCreateValidPerson() {
        Person person = new Person("Alice", 28);

        assertEquals("Alice", person.name());
        assertEquals(28, person.age());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when age is negative")
    void shouldThrowExceptionForNegativeAge() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("Bob", -1);
        });

        assertEquals("Age cannot be negative", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    @DisplayName("Should throw IllegalArgumentException for empty or blank names")
    void shouldThrowExceptionForInvalidNames(String invalidName) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Person(invalidName, 20);
        });
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when name is null")
    void shouldThrowExceptionForNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Person(null, 20);
        });
    }

    @Test
    @DisplayName("Should return correct greeting from custom method")
    void shouldReturnCorrectGreeting() {
        Person person = new Person("Charlie", 40);

        assertEquals("Hello, my name is Charlie and I am 40 years old.", person.greet());
    }

    @Test
    @DisplayName("Should create a valid anonymous person via static factory method")
    void shouldCreateAnonymousPerson() {
        Person anonymous = Person.createAnonymous(30);

        assertEquals("Anonymous", anonymous.name());
        assertEquals(30, anonymous.age());
    }

    @Test
    @DisplayName("Should verify equals and hashCode contracts work automatically")
    void shouldVerifyEqualsAndHashCode() {
        Person person1 = new Person("Alice", 25);
        Person person2 = new Person("Alice", 25);
        Person person3 = new Person("Bob", 30);

        assertEquals(person1, person2); // Auto-generated equals checks structural equality
        assertNotEquals(person1, person3);
        assertEquals(person1.hashCode(), person2.hashCode()); // Same fields = same hashCode
    }
}
