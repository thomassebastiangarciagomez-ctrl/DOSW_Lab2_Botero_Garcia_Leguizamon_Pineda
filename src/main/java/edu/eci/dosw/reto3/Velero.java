package edu.eci.dosw.reto3;

public class Velero extends Vehiculo{
    
    public Velero(String categoria){
        this.categoria = categoria;
        this.tipo = "Water";
        this.precio = 17000;
        this.velocidadMaxima = 120;
        this.equipoEspecial = "Arpon";
    }
}
