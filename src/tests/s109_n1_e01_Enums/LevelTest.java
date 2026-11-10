package s109_n1_e01_Enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelTest {

    @Test
    void getColor_shouldReturnAssociatedColor() {
        assertEquals("Green", Level.LOW.getColor());
        assertEquals("Yellow", Level.MEDIUM.getColor());
        assertEquals("Red", Level.HIGH.getColor());
    }

    @Test
    void isUrgentTask_shouldReturnTrueForHighPriority() {
        assertTrue(Level.HIGH.isUrgentTask());
    }

    @Test
    void isUrgentTask_shouldReturnFalseForLowAndMediumPriority() {
        assertFalse(Level.LOW.isUrgentTask());
        assertFalse(Level.MEDIUM.isUrgentTask());
    }

    @Test
    void toString_shouldReturnColorAndSla() {
        assertEquals("color: Green. SLA: 168", Level.LOW.toString());
        assertEquals("color: Yellow. SLA: 48", Level.MEDIUM.toString());
        assertEquals("color: Red. SLA: 2", Level.HIGH.toString());
    }

    @Test
    void responseHours_shouldDetermineUrgency() {
        assertTrue(Level.HIGH.getResponseHours() <= 4);
        assertFalse(Level.MEDIUM.getResponseHours() <= 4);
        assertFalse(Level.LOW.getResponseHours() <= 4);
    }
}
