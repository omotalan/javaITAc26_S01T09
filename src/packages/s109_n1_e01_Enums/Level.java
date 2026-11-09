package s109_n1_e01_Enums;

public enum Level {
    LOW("Green", 168),
    MEDIUM("Yellow", 48),
    HIGH("Red", 2);


    private final String color;
    private final int responseHours;

    Level(String color, int responseHours) {
        this.color = color;
        this.responseHours = responseHours;
    }

    public String getColor() {
        return color;
    }

    // Mètode amb lògica dins l’enum
    public boolean isUrgentTask() {
        return this.responseHours <= 4;
    }

    @Override
    public String toString() {
        return "color: " + color + ". SLA: " + responseHours;
    }
}
