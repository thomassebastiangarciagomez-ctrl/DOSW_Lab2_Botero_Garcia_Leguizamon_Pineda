package edu.eci.dosw.reto6;

public class Operator {
    private final DifficultyLevel maxLevel;
    private final Priority maxPriority;

    public Operator(DifficultyLevel maxLevel, Priority maxPriority) {
        this.maxLevel = maxLevel;
        this.maxPriority = maxPriority;
    }

    public DifficultyLevel getMaxLevel() {
        return maxLevel;
    }

    public Priority getMaxPriority() {
        return maxPriority;
    }

    public boolean canHandle(Ticket ticket) {
        boolean levelOk = ticket.getLevel().ordinal() <= maxLevel.ordinal();
        boolean priorityOk = ticket.getPriority().ordinal() <= maxPriority.ordinal();
        return levelOk && priorityOk;
    }
}