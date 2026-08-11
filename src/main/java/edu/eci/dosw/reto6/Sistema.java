package edu.eci.dosw.reto6;
import java.util.*;
import java.util.stream.Collectors;

public class Sistema {
    ArrayList<Ticket> solicitudes;
    Tecnico primerTecnico;

    public Sistema(){
        solicitudes = new ArrayList<>();
    }

    /**
     * This method add a ticket and sort the list of tickets
     * 
     * @param ticket
     */
    public void agregarTicket(Ticket ticket){
        solicitudes.add(ticket);

    }

    /**
     * This method set the first tecnique in line on the system
     * 
     * @param tecnico
     */
    public void setPrimerTecnico(Tecnico tecnico){
        primerTecnico = tecnico;
    }

    /**
     * All tickets will be organice by priority and will be
     * process in this order
     * 
     */
    public void procesar(){
        solicitudes.sort(Comparator.comparing(Ticket::getPrioridad).reversed());
        solicitudes.forEach(Ticket -> primerTecnico.procesar(Ticket));
    }

    /**
     * Show the final stadistics of the system
     * 
     */
    public void mostrarEstadisticas(){
        String message = solicitudes.stream()
            .collect(Collectors.groupingBy(Ticket::isResolve))
            .entrySet().stream()
            .map(s -> s.getValue().stream()
                .map(i -> "-Descripcion: " + i.getDescription() + "\n" 
                    + "-Nivel: " + i.getNivel() + "\n"
                    + "-Prioridad: " + i.getPrioridad() + "\n"
                    + "-Tecnico que dio solucion: " + i.getSolver() + "\n"
                    + "-Historial: " + String.join(" -> ", i.getHistorial()))
                .collect(Collectors.joining("\n\n"))
            + "Se resolvio la solicitud: " + s.getKey())
            .collect(Collectors.joining("\n\n"));
        
        System.out.println("Registro de todas las solicitudes\n" + message); 
    }
}
