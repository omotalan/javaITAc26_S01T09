package s109_n2_e01_06_Cites;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeHelpersTest {

    private DateTimeHelpers dth;

    @BeforeEach
    void setUp() {
        dth = new DateTimeHelpers();
    }

    @Test
    void isBeforeToday_shouldThrowExceptionWhenDateIsNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> dth.isBeforeToday(null)
        );
        assertEquals("Date to check cannot be null.", exception.getMessage());
    }

    @Test
    void isBeforeToday_shouldReturnFalseForTodayBoundary() {
        LocalDate today = LocalDate.now();
        assertFalse(dth.isBeforeToday(today));
    }

    @Test
    void isBeforeToday_shouldReturnTrueForPastDateAndFalseForFutureDate() {
        LocalDate pastDate = LocalDate.now().minusDays(5);
        LocalDate futureDate = LocalDate.now().plusDays(5);

        assertTrue(dth.isBeforeToday(pastDate));
        assertFalse(dth.isBeforeToday(futureDate));
    }
}

