package edu.eci.dosw.reto6;

public class Reto6 {
    private Sistema sistema;

    public Reto6(){
        sistema = new Sistema();
    }

    /**
     * this method return the system that we are working
     * 
     * @return Variable that represents the system
     */
    public Sistema getSistema(){
        return sistema;
    }

    /**
     * This method works on create any ticket and add to the List of tickets in
     * general System
     * 
     * @param nivel
     * @param prioridad
     * @param description
     */
    public void crearTicket(String nivel, String prioridad, String description){
        Ticket ticket = new Ticket(NivelDificultad.valueOf(nivel.toUpperCase()), Prioridad.valueOf(prioridad.toUpperCase()), description);
        sistema.agregarTicket(ticket);
    }

    /**
     * This method works on create and return any tecnique on the general
     * system
     * 
     * @param tipo
     * @param nombre
     * @param nivel
     * @return That variable represents an any tecnique
     */
    public Tecnico crearTecnico(String tipo, String nombre){
        switch (tipo) {
            case "Basico": return new TecnicoBasico(nombre, NivelDificultad.valueOf(tipo.toUpperCase()));
            case "Medio": return new TecnicoMedio(nombre, NivelDificultad.valueOf(tipo.toUpperCase()));
            default: return new TecnicoAvanzado(nombre, NivelDificultad.valueOf(tipo.toUpperCase()));
        }
    }

    public static void main(String[] args){
        Reto6 reto6 = new Reto6();

        Tecnico tecnico1 = reto6.crearTecnico("Basico", "Thomas");
        Tecnico tecnico2 = reto6.crearTecnico("Intermedio", "Juan");
        Tecnico tecnico3 = reto6.crearTecnico("Avanzado", "Daniel");

        tecnico1.setSiguiente(tecnico2);
        tecnico2.setSiguiente(tecnico3);
        tecnico3.setSiguiente(tecnico3);
        reto6.getSistema().setPrimerTecnico(tecnico1);

        reto6.crearTicket("Basico", "Alta", "Tratamiento de datos personales");
        reto6.crearTicket("Basico", "Media", "Error en instalacion");
        reto6.crearTicket("Intermedio", "Baja", "Cerrar programa");
        reto6.crearTicket("Avanzado", "Alta", "Informacion empresarial delicada");

        reto6.getSistema().procesar();
        reto6.getSistema().mostrarEstadisticas();
    }
}
