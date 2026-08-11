package edu.eci.dosw.reto6;

public class TecnicoBasico extends Tecnico{
    
    public TecnicoBasico(String nombre, NivelDificultad nivel){
        this.nombre = nombre;
        this.nivelMaximo = nivel;
    }

    /**
     * 
     * 
     */
    @Override
    public void procesar(Ticket ticket){
        if(ticket.getNivel().equals(this.nivelMaximo)) aprobar(ticket);
        else {
            ticket.agregarTecnico(nombre);
            siguiente.procesar(ticket);
        }
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
