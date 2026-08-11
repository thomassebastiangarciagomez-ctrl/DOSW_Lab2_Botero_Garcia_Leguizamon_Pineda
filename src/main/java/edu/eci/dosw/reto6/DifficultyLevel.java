package edu.eci.dosw.reto6;

public enum DifficultyLevel {
    BASIC("Básico"),
    INTERMEDIATE("Intermedio"),
    ADVANCED("Avanzado");

    private final String displayName;

    DifficultyLevel(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}