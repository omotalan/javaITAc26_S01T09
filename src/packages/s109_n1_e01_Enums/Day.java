package s109_n1_e01_Enums;

public enum Day {
    DILLUNS,
    DIMARTS,
    DIMECRES,
    DIJOUS,
    DIVENDRES,
    DISSABTE,
    DIUMENGE;

    public String categoriaDia(Day dia) {
        return (dia.equals(DISSABTE) || dia.equals(DIUMENGE)) ? "Cap de setmana" : "Laborable";
    }
}
