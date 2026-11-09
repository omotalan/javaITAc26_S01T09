package s109_n1_e01_Enums;

import static s109_n1_e01_Enums.Helpers.parseLevelFromString;

public class Main {

    public static void main(String[] args) {

        // Cas invàlid
        System.out.println("----- CAS INVÀLID -----");
        Level unparseableLevel = parseLevelFromString("Irrelevant");
        Task buttons = new Task("Switch button colors to blue", unparseableLevel);
        buttons.execute();

        // Cas vàlid
        System.out.println("\n----- CAS VÀLID -----");
        Level parsedLevel = parseLevelFromString("  high ");
        Task refactor = new Task("Refactor currency DTOs", parsedLevel);
        refactor.execute();
    }
}
