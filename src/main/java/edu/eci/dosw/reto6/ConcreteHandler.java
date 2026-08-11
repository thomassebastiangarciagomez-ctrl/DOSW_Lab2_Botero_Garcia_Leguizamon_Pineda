package edu.eci.dosw.reto6;

import java.util.*;

public class ConcreteHandler implements Handler {
    private final DifficultyLevel level;
    private final List<Operator> operators;
    private Handler next;

    public ConcreteHandler(DifficultyLevel level, List<Operator> operators) {
        this.level = level;
        this.operators = new ArrayList<>(operators);
    }

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public DifficultyLevel handle(Ticket ticket, List<DifficultyLevel> attemptedLevels) {
        boolean hasCapableOperator = operators.stream()
                .anyMatch(op -> op.canHandle(ticket));

        if (hasCapableOperator) {
            return level;
        }

        attemptedLevels.add(level);

        if (next != null) {
            return next.handle(ticket, attemptedLevels);
        }

        return null;
    }
}
