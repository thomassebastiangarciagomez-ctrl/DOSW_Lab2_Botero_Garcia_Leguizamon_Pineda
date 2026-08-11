package edu.eci.dosw.reto6;

import java.util.*;

public class TicketOutcome {
    private final DifficultyLevel resolvedBy;
    private final List<DifficultyLevel> attemptedLevels;

    public TicketOutcome(DifficultyLevel resolvedBy, List<DifficultyLevel> attemptedLevels) {
        this.resolvedBy = resolvedBy;
        this.attemptedLevels = new ArrayList<>(attemptedLevels);
    }

    public DifficultyLevel getResolvedBy() {
        return resolvedBy;
    }

    public List<DifficultyLevel> getAttemptedLevels() {
        return new ArrayList<>(attemptedLevels);
    }
}