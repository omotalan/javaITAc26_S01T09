package s109_n2_e01_06_Cites;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        DateTimeHelpers dtHelpers = new DateTimeHelpers();

        // Ex. 1
        dtHelpers.printCurrentDateTime();

        // Ex. 2
        LocalDate startDate = LocalDate.of(2025, 1, 15);
        LocalDate endDate = LocalDate.of(2026, 11, 9);
        dtHelpers.calculateDateDiff(startDate, endDate);

        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 30);
        dtHelpers.calculateTimeDiff(startTime, endTime);

        // Ex. 3
        LocalDateTime baseDateTime = LocalDateTime.of(2026, 11, 9, 10, 0);
        LocalDateTime plusDays = baseDateTime.plusDays(10);
        LocalDateTime minusMonths = baseDateTime.minusMonths(2);
        LocalDateTime plusHours = baseDateTime.plusHours(5).minusMinutes(30);
        dtHelpers.manipulateDateTime(baseDateTime, plusDays, minusMonths, plusHours);

        // Ex. 4
        LocalDateTime sampleDate = LocalDateTime.of(2026, 11, 9, 14, 45);
        DateTimeFormatter isoFormat = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter europeanFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter verboseEnglishFormat = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy 'at' hh:mm a", Locale.ENGLISH);
        dtHelpers.formatDates(sampleDate, isoFormat, europeanFormat, verboseEnglishFormat);

        // Ex. 5
        System.out.println("--- 5. Date Comparison ---");
        LocalDate pastDate = LocalDate.now().minusDays(5);
        LocalDate futureDate = LocalDate.now().plusDays(5);
        System.out.println("Is " + pastDate + " before today? " + dtHelpers.isBeforeToday(pastDate));
        System.out.println("Is " + futureDate + " before today? " + dtHelpers.isBeforeToday(futureDate) + "\n");

        // Ex. 6: Agenda Amb LocalDateTime
        System.out.println("--- 6. Agenda: Upcoming Appointments ---");
        LocalDateTime now = LocalDateTime.now();
        Agenda myAgenda = new Agenda();

        myAgenda.scheduleAppointment(new Cita("Past Dentist Visit", now.minusDays(2)));
        myAgenda.scheduleAppointment(new Cita("Team Architecture Review", now.plusHours(3)));
        myAgenda.scheduleAppointment(new Cita("Client Demo", now.plusDays(4).withHour(11).withMinute(0)));
        myAgenda.scheduleAppointment(new Cita("Yesterday Standup", now.minusHours(20)));

        List<Cita> upcoming = myAgenda.getFutureAppointments(now);
        upcoming.forEach(app -> System.out.println(app.toString()));
    }
}
