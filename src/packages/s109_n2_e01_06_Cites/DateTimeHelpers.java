package s109_n2_e01_06_Cites;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeHelpers {

    public DateTimeHelpers() {
    }

    // Exercici 1
    public void printCurrentDateTime() {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();

        System.out.println("--- 1. Current Date & Time ---");
        System.out.println("LocalDate:     " + currentDate);
        System.out.println("LocalTime:     " + currentTime);
        System.out.println("LocalDateTime: " + currentDateTime + "\n");
    }

    // Exercici 2
    public void calculateDateDiff(LocalDate startDate, LocalDate endDate) {
        Period period = Period.between(startDate, endDate);

        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 30);
        Duration duration = Duration.between(startTime, endTime);

        System.out.println("--- 2. Differences (Period) ---");
        System.out.printf("Period between %s and %s: %d years, %d months, %d days%n",
                startDate, endDate, period.getYears(), period.getMonths(), period.getDays());
    }

    public void calculateTimeDiff(LocalTime startTime, LocalTime endTime) {
        Duration duration = Duration.between(startTime, endTime);

        System.out.println("--- 2. Differences (Duration) ---");
        System.out.printf("Duration between %s and %s: %d hours (%d minutes)%n%n",
                startTime, endTime, duration.toHours(), duration.toMinutes());
    }

    // Exercici 3
    public void manipulateDateTime(LocalDateTime baseDateTime, LocalDateTime diffDays, LocalDateTime diffMonths, LocalDateTime diffHours) {

        System.out.println("--- 3. Adding & Subtracting Time ---");
        System.out.println("Base:          " + baseDateTime);
        System.out.printf("%s days:      " + diffDays, diffDays.getDayOfMonth());
        System.out.printf("%s months:     " + diffMonths, diffMonths.getMonth());
        System.out.printf("%s hours and %s minutes: " + diffHours, diffHours.getHour(), diffHours.getMinute());
    }

    // Exercici 4
    public void formatDates(LocalDateTime sampleDate, DateTimeFormatter isoFormat, DateTimeFormatter euroFormat, DateTimeFormatter longEngFormat) {
        System.out.println("--- 4. Formatting Dates ---");
        System.out.println("ISO Standard:  " + sampleDate.format(isoFormat));
        System.out.println("European:      " + sampleDate.format(euroFormat));
        System.out.println("Verbose:       " + sampleDate.format(longEngFormat) + "\n");
    }

    // Exercici 5
    public boolean isBeforeToday(LocalDate dateToCheck) {
        if (dateToCheck == null) {
            throw new IllegalArgumentException("Date to check cannot be null.");
        }
        return dateToCheck.isBefore(LocalDate.now());
    }
}
