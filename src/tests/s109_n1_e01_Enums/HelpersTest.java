package s109_n1_e01_Enums;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HelpersTest {

    @Test
    void parseLevelFromString_shouldReturnLowForValidLowercaseInput() {
        assertEquals(Level.LOW, Helpers.parseLevelFromString("low"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"LOW", "Low", "lOw", "  low  "})
    void parseLevelFromString_shouldReturnLowForCaseInsensitiveAndTrimmedInput(String input) {
        assertEquals(Level.LOW, Helpers.parseLevelFromString(input));
    }

    @Test
    void parseLevelFromString_shouldReturnMediumForValidInput() {
        assertEquals(Level.MEDIUM, Helpers.parseLevelFromString("medium"));
    }

    @Test
    void parseLevelFromString_shouldReturnHighForValidInput() {
        assertEquals(Level.HIGH, Helpers.parseLevelFromString("high"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   ", "\t\n", "Irrelevant", "nonexistent"})
    void parseLevelFromString_shouldDefaultToLowForInvalidInput(String input) {
        assertEquals(Level.LOW, Helpers.parseLevelFromString(input));
    }
}
