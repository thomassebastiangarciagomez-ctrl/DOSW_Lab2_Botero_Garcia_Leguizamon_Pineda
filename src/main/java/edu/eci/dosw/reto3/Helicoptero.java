package edu.eci.dosw.reto3;

public class Helicoptero extends Vehiculo{
    
    public Helicoptero(String categoria){
        this.categoria = categoria;
        this.tipo = "Air";
        this.precio = 700;
        this.velocidadMaxima = 200;
        this.equipoEspecial = "Manejo asistido con IA";
    }
}
