package edu.eci.dosw.reto3;

public class Carro extends Vehiculo{

    public Carro(String categoria){
        this.categoria = categoria;
        this.tipo = "Land";
        this.precio = 145000;
        this.velocidadMaxima = 120;
        this.equipoEspecial = "Luces antiniebla";
    }
}
