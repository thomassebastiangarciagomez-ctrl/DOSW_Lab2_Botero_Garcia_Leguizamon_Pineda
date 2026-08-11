package edu.eci.dosw.reto6;

import java.util.*;
import java.util.stream.*;

public class SupportStatistics {

    private final List<TicketResult> results;

    public SupportStatistics(List<TicketResult> results) {
        this.results = results;
    }

    public Map<DifficultyLevel, Long> getCountsByLevel() {
        return results.stream()
            .map(r -> r.getOutcome().getResolvedBy())
            .filter(level -> level != null)
            .collect(Collectors.groupingBy(level -> level, Collectors.counting()));
    }

    public long getPendingCount() {
        return results.stream()
            .filter(r -> r.getOutcome().getResolvedBy() == null)
            .count();
    }

    public double getAveragePriority() {
        return results.stream()
            .mapToInt(r -> r.getTicket().getPriority().ordinal() + 1)
            .average()
            .orElse(0.0);
    }
}