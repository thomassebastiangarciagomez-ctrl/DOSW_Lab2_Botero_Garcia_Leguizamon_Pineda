package edu.eci.dosw.reto6;

import java.util.List;

public interface Handler {
    void setNext(Handler next);
    DifficultyLevel handle(Ticket ticket, List<DifficultyLevel> attemptedLevels);
}
