package edu.eci.dosw.reto6;

public class TicketResult {
    private final Ticket ticket;
    private final TicketOutcome outcome;

    public TicketResult(Ticket ticket, TicketOutcome outcome) {
        this.ticket = ticket;
        this.outcome = outcome;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public TicketOutcome getOutcome() {
        return outcome;
    }
}
