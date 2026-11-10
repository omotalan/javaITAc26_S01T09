package s109_n2_e01_06_Cites;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Agenda {
    private final List<Cita> cites;

    public Agenda() {
        this.cites = new ArrayList<>();
    }

    public void scheduleAppointment(Cita cita) {
        this.cites.add(cita);
    }

    // Retorna només cites futures
    public List<Cita> getFutureAppointments(LocalDateTime refDateTime) {
        return cites.stream()
                .filter(cita -> cita.isUpcoming(refDateTime))
                .sorted(Comparator.comparing(Cita::getScheduledAt))
                .collect(Collectors.toList());
    }
}
