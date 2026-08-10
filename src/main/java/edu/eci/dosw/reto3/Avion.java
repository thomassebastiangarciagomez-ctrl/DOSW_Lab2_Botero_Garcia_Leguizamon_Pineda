package edu.eci.dosw.reto3;

public class Avion extends Vehiculo{
    
    public Avion(String categoria){
        this.categoria = categoria;
        this.tipo = "Air";
        this.precio = 845000;
        this.velocidadMaxima = 890;
        this.equipoEspecial = "Manejo asistido con IA";
    }
}
