package s109_n2_e01_06_Cites;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cita {
    private final String title;
    private final LocalDateTime scheduledAt;

    public Cita(String title, LocalDateTime scheduledAt) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Appointment title cannot be empty.");
        }
        if (scheduledAt == null) {
            throw new IllegalArgumentException("Scheduled date and time cannot be null.");
        }
        this.title = title;
        this.scheduledAt = scheduledAt;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }

    public boolean isUpcoming(LocalDateTime refDateTime) {
        return this.scheduledAt.isAfter(refDateTime);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy 'at' HH:mm");
        return "Cita: " + title + ", " + scheduledAt.format(formatter);
    }
}
