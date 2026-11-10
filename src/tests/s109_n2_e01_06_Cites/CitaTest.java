package s109_n2_e01_06_Cites;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaTest {

    private static final LocalDateTime REFERENCE_NOW = LocalDateTime.of(2026, 11, 9, 10, 0, 0);

    @Test
    void shouldCreateValidAppointmentAndFormatSummary() {
        LocalDateTime scheduled = LocalDateTime.of(2026, 11, 13, 11, 0);
        Cita appointment = new Cita("Client Demo", scheduled);

        assertEquals("Client Demo", appointment.getTitle());
        assertEquals(scheduled, appointment.getScheduledAt());
        assertEquals("Cita: Client Demo, 13/11/2026 at 11:00", appointment.toString());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   ", "\t\n"})
    void shouldThrowExceptionWhenTitleIsNullOrBlank(String invalidTitle) {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Cita(invalidTitle, REFERENCE_NOW.plusHours(1))
        );
        assertEquals("Appointment title cannot be empty.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenScheduledTimeIsNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Cita("Team Architecture Review", null)
        );
        assertEquals("Scheduled date and time cannot be null.", exception.getMessage());
    }

    @Test
    void isUpcoming_shouldReturnTrueWhenScheduledOneSecondAfterReference() {
        Cita futureAppointment = new Cita("Team Architecture Review", REFERENCE_NOW.plusSeconds(1));
        assertTrue(futureAppointment.isUpcoming(REFERENCE_NOW));
    }

    @Test
    void isUpcoming_shouldReturnFalseWhenScheduledOneSecondBeforeReference() {
        Cita pastAppointment = new Cita("Yesterday Standup", REFERENCE_NOW.minusSeconds(1));
        assertFalse(pastAppointment.isUpcoming(REFERENCE_NOW));
    }

    @Test
    void isUpcoming_shouldReturnFalseWhenScheduledAtExactReferenceTime() {
        Cita rightNowAppointment = new Cita("Immediate Sync", REFERENCE_NOW);
        assertFalse(rightNowAppointment.isUpcoming(REFERENCE_NOW));
    }
}

