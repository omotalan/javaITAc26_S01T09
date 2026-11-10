package s109_n1_e01_Enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void execute_shouldNotThrowForAllPriorities() {
        assertDoesNotThrow(() -> new Task("Low task", Level.LOW).execute());
        assertDoesNotThrow(() -> new Task("Medium task", Level.MEDIUM).execute());
        assertDoesNotThrow(() -> new Task("High task", Level.HIGH).execute());
    }

    @Test
    void execute_withHighPriority_shouldPrintUrgentAlert() {
        assertDoesNotThrow(() -> new Task("Emergency task", Level.HIGH).execute());
    }

    @Test
    void execute_withLowPriority_shouldPrintStandardQueue() {
        assertDoesNotThrow(() -> new Task("Routine task", Level.LOW).execute());
    }
}
