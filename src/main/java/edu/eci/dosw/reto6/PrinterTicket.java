package edu.eci.dosw.reto6;

import java.util.*;
import java.util.stream.*;

public class PrinterTicket {

    private PrinterTicket() {
    }

    public static void print(List<TicketResult> results, SupportStatistics statistics) {
        IntStream.range(0, results.size())
            .forEach(i -> {
                TicketResult result = results.get(i);
                System.out.println("Ticket " + (i + 1) + ": " + describeOutcome(result.getOutcome()));
            });

        System.out.println();
        System.out.println("Estadísticas:");

        Map<DifficultyLevel, Long> counts = statistics.getCountsByLevel();
        String levelsLine = Arrays.stream(DifficultyLevel.values())
            .map(level -> level.getDisplayName() + ": " + counts.getOrDefault(level, 0L))
            .collect(Collectors.joining(" · "));
        System.out.println(levelsLine);

        System.out.println("Pendientes: " + statistics.getPendingCount());
        System.out.printf("Promedio prioridad: %.1f%n", statistics.getAveragePriority());
    }

    private static String describeOutcome(TicketOutcome outcome) {
        if (outcome.getResolvedBy() == null) {
            return "pendiente de escalamiento.";
        }

        if (outcome.getAttemptedLevels().isEmpty()) {
            return "Técnico " + outcome.getResolvedBy().getDisplayName() + " resolvió.";
        }

        String failedPart = outcome.getAttemptedLevels().stream()
            .map(level -> level.getDisplayName() + " no pudo")
            .collect(Collectors.joining("; "));

        return failedPart + "; " + outcome.getResolvedBy().getDisplayName() + " resolvió.";
    }
}