package edu.eci.dosw.reto6;

public class Ticket {
    private final String description;
    private final DifficultyLevel level;
    private final Priority priority;

    public Ticket(String description, DifficultyLevel level, Priority priority) {
        this.description = description;
        this.level = level;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public DifficultyLevel getLevel() {
        return level;
    }

    public Priority getPriority() {
        return priority;
    }
}