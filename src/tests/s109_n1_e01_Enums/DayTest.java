package s109_n1_e01_Enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayTest {

    @Test
    void categoriaDia_shouldReturnWeekendForSaturdayAndSunday() {
        Day day = Day.DILLUNS;

        assertEquals("Cap de setmana", day.categoriaDia(Day.DISSABTE));
        assertEquals("Cap de setmana", day.categoriaDia(Day.DIUMENGE));
    }

    @Test
    void categoriaDia_shouldReturnLaborableForWeekdays() {
        Day day = Day.DILLUNS;

        assertEquals("Laborable", day.categoriaDia(Day.DILLUNS));
        assertEquals("Laborable", day.categoriaDia(Day.DIMARTS));
        assertEquals("Laborable", day.categoriaDia(Day.DIMECRES));
        assertEquals("Laborable", day.categoriaDia(Day.DIJOUS));
        assertEquals("Laborable", day.categoriaDia(Day.DIVENDRES));
    }

    @Test
    void shouldHaveAllSevenDays() {
        assertEquals(7, Day.values().length);
    }
}
