package edu.eci.dosw.reto6;

import java.util.*;

public class TicketProcessor {
    private final Handler chain;

    public TicketProcessor(Handler chain) {
        this.chain = chain;
    }

    public List<TicketResult> process(List<Ticket> tickets) {
        List<TicketResult> results = new ArrayList<>();
        tickets.forEach(ticket -> {
            List<DifficultyLevel> attempted = new ArrayList<>();
            DifficultyLevel resolvedBy = chain.handle(ticket, attempted);
            results.add(new TicketResult(ticket, new TicketOutcome(resolvedBy, attempted)));
        });
        return results;
    }
}