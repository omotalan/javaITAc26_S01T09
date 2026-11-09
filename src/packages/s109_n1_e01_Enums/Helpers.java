package s109_n1_e01_Enums;

public class Helpers {

    public static Level parseLevelFromString(String input) {
        try {
            return Level.valueOf(input.trim().toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            // Fallback a propòsit; el programa no s'interrompeix
            System.err.println("Error: " + input + " is not a valid level. Defaulting to 'LOW'.");
            return Level.LOW;
        }
    }
}
