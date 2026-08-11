package edu.eci.dosw.reto7;

public abstract class Command {
    protected User user;
    protected String log;
    public abstract void execute();
    public abstract void undo();
    public abstract String getLog();
}
