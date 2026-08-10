package edu.eci.dosw.reto3;

public class Moto extends Vehiculo{

    public Moto(String categoria){
        this.categoria = categoria;
        this.tipo = "Land";
        this.precio = 75000;
        this.velocidadMaxima = 100;
        this.equipoEspecial = "Frenos ABS";
    }
}
