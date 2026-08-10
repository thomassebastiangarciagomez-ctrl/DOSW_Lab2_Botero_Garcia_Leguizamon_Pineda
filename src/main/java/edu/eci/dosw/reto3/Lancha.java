package edu.eci.dosw.reto3;

public class Lancha extends Vehiculo{
    
    public Lancha(String categoria){
        this.categoria = categoria;
        this.tipo = "Water";
        this.precio = 145000;
        this.velocidadMaxima = 80;
        this.equipoEspecial = "Ancla automatica";
    }
}
