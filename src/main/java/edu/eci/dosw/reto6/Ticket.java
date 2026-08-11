package edu.eci.dosw.reto6;
import java.util.*;

public class Ticket {
    
    private NivelDificultad nivel;
    private Prioridad prioridad;
    private String descripcion;
    private boolean resuelto;
    private String tecnicoResolucion;
    private ArrayList<String> historialTecnicos;

    public Ticket(NivelDificultad nivel, Prioridad prioridad, String descripcion){
        this.nivel = nivel;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
        this.resuelto = false;
        this.tecnicoResolucion = "Nobody yet";
        historialTecnicos = new ArrayList<>();
    }

    /**
     * This method works on mark the ticket like resolve for any Tecnique
     * on the system
     * 
     * @param nombre
     */
    public void marcarResuelto(String nombre){
        tecnicoResolucion = nombre;
        historialTecnicos.add(nombre);
        resuelto = true;
    }

    /**
     * Add a tecnique to the register
     * 
     * @param nombre
     */
    public void agregarTecnico(String nombre){
        historialTecnicos.add(nombre);
    }

    /**
     * This method return the level of the ticket
     * 
     * @return
     */
    public NivelDificultad getNivel(){
        return nivel;
    }

    /**
     * This method return the priority
     * 
     * @return
     */
    public Prioridad getPrioridad(){
        return prioridad;
    }

    /**
     * This method return the description of the ticket
     * 
     * @return
     */
    public String getDescription(){
        return descripcion;
    }

    /**
     * This method return if is solve or not
     * 
     * @return
     */
    public boolean isResolve(){
        return resuelto;
    }

    /**
     * This method return the solver of the problem
     * 
     * @return
     */
    public String getSolver(){
        return tecnicoResolucion;
    }

    /**
     * This method return the historial of the ticket
     * 
     * @return
     */
    public ArrayList<String> getHistorial(){
        return historialTecnicos;
    }
}
