package edu.eci.dosw.reto6;

public abstract class Tecnico {
    
    protected String nombre;
    protected NivelDificultad nivelMaximo;
    protected Tecnico siguiente;

    //Abstract methods
    public abstract void procesar(Ticket ticket);
    public abstract void aprobar(Ticket ticket);

    /**
     * 
     * @param siguiente
     */
    public void setSiguiente(Tecnico siguiente){
        this.siguiente = siguiente;
    }

}
