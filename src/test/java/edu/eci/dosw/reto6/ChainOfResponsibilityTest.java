package edu.eci.dosw.reto6;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

public class ChainOfResponsibilityTest {

    @Test
    public void basicTicketShouldBeResolvedByBasicHandler() {
        Handler basic = new ConcreteHandler(DifficultyLevel.BASIC,
                List.of(new Operator(DifficultyLevel.BASIC, Priority.HIGH)));
        Ticket ticket = new Ticket("Reinicio de contraseña", DifficultyLevel.BASIC, Priority.LOW);

        TicketProcessor processor = new TicketProcessor(basic);
        List<TicketResult> results = processor.process(List.of(ticket));

        assertEquals(DifficultyLevel.BASIC, results.get(0).getOutcome().getResolvedBy());
    }

    @Test
    public void intermediateTicketShouldEscalateFromBasic() {
        Handler basic = new ConcreteHandler(DifficultyLevel.BASIC,
                List.of(new Operator(DifficultyLevel.BASIC, Priority.HIGH)));
        Handler intermediate = new ConcreteHandler(DifficultyLevel.INTERMEDIATE,
                List.of(new Operator(DifficultyLevel.INTERMEDIATE, Priority.HIGH)));
        basic.setNext(intermediate);

        Ticket ticket = new Ticket("Configuración de red", DifficultyLevel.INTERMEDIATE, Priority.MEDIUM);

        TicketProcessor processor = new TicketProcessor(basic);
        List<TicketResult> results = processor.process(List.of(ticket));

        TicketResult result = results.get(0);
        assertEquals(DifficultyLevel.INTERMEDIATE, result.getOutcome().getResolvedBy());
        assertEquals(1, result.getOutcome().getAttemptedLevels().size());
        assertEquals(DifficultyLevel.BASIC, result.getOutcome().getAttemptedLevels().get(0));
    }

    @Test
    public void ticketShouldStayPendingWhenNoOperatorCanHandleIt() {
        Handler advanced = new ConcreteHandler(DifficultyLevel.ADVANCED, List.of());
        Ticket ticket = new Ticket("Falla crítica", DifficultyLevel.ADVANCED, Priority.HIGH);

        TicketProcessor processor = new TicketProcessor(advanced);
        List<TicketResult> results = processor.process(List.of(ticket));

        assertNull(results.get(0).getOutcome().getResolvedBy());
    }

    @Test
    public void ticketShouldEscalateWhenPriorityExceedsOperatorLimit() {
        Handler basic = new ConcreteHandler(DifficultyLevel.BASIC,
                List.of(new Operator(DifficultyLevel.BASIC, Priority.LOW)));

        Ticket ticket = new Ticket("Ticket urgente", DifficultyLevel.BASIC, Priority.HIGH);

        TicketProcessor processor = new TicketProcessor(basic);
        List<TicketResult> results = processor.process(List.of(ticket));

        assertNull(results.get(0).getOutcome().getResolvedBy());
    }

    @Test
    public void statisticsShouldCalculateAveragePriorityAcrossAllTickets() {
        Handler basic = new ConcreteHandler(DifficultyLevel.BASIC,
                List.of(new Operator(DifficultyLevel.BASIC, Priority.HIGH)));
        List<Ticket> tickets = List.of(
            new Ticket("Ticket A", DifficultyLevel.BASIC, Priority.LOW),
            new Ticket("Ticket B", DifficultyLevel.BASIC, Priority.HIGH)
        );

        TicketProcessor processor = new TicketProcessor(basic);
        List<TicketResult> results = processor.process(tickets);
        SupportStatistics statistics = new SupportStatistics(results);

        assertEquals(2.0, statistics.getAveragePriority(), 0.001);
    }
}