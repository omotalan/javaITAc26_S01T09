package s109_n2_e01_06_Cites;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {

    private static final LocalDateTime REFERENCE_NOW = LocalDateTime.of(2026, 11, 9, 10, 0, 0);
    private Agenda agenda;

    @BeforeEach
    void setUp() {
        agenda = new Agenda();
    }

    @Test
    void getFutureAppointments_shouldReturnEmptyListWhenAgendaIsEmpty() {
        List<Cita> upcoming = agenda.getFutureAppointments(REFERENCE_NOW);

        assertNotNull(upcoming);
        assertTrue(upcoming.isEmpty());
    }

    @Test
    void getFutureAppointments_shouldFilterOutPastAndPresentAndSortChronologically() {
        // Leveraged from Main, added intentionally out of chronological order
        Cita clientDemo = new Cita("Client Demo", REFERENCE_NOW.plusDays(4).withHour(11).withMinute(0));
        Cita pastDentist = new Cita("Past Dentist Visit", REFERENCE_NOW.minusDays(2));
        Cita archReview = new Cita("Team Architecture Review", REFERENCE_NOW.plusHours(3));
        Cita exactNowSync = new Cita("Exact Now Sync", REFERENCE_NOW);
        Cita yesterdayStandup = new Cita("Yesterday Standup", REFERENCE_NOW.minusHours(20));

        agenda.scheduleAppointment(clientDemo);
        agenda.scheduleAppointment(pastDentist);
        agenda.scheduleAppointment(archReview);
        agenda.scheduleAppointment(exactNowSync);
        agenda.scheduleAppointment(yesterdayStandup);

        List<Cita> upcoming = agenda.getFutureAppointments(REFERENCE_NOW);

        assertEquals(2, upcoming.size());
        // Must be sorted earliest to latest: archReview (+3h) before clientDemo (+4d)
        assertEquals("Team Architecture Review", upcoming.get(0).getTitle());
        assertEquals("Client Demo", upcoming.get(1).getTitle());
    }

    @Test
    void getFutureAppointments_shouldReturnEmptyListWhenAllAppointmentsAreInThePast() {
        agenda.scheduleAppointment(new Cita("Past Dentist Visit", REFERENCE_NOW.minusDays(2)));
        agenda.scheduleAppointment(new Cita("Yesterday Standup", REFERENCE_NOW.minusHours(20)));

        List<Cita> upcoming = agenda.getFutureAppointments(REFERENCE_NOW);

        assertTrue(upcoming.isEmpty());
    }
}

