package edu.eci.dosw.reto6;

public class TecnicoAvanzado extends Tecnico{

    public TecnicoAvanzado(String nombre, NivelDificultad nivel){
        this.nombre = nombre;
        this.nivelMaximo = nivel;
    }

    /**
     * 
     * 
     */
    @Override
    public void procesar(Ticket ticket){
        aprobar(ticket);
    }

    /**
     * 
     * 
     */
    @Override
    public void aprobar(Ticket ticket){
        ticket.marcarResuelto(nombre);
    }    
}
