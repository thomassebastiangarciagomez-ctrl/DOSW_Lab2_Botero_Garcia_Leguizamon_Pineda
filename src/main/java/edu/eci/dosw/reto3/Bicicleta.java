package edu.eci.dosw.reto3;

public class Bicicleta extends Vehiculo{

    public Bicicleta(String categoria){
        this.categoria = categoria;
        this.tipo = "Land";
        this.precio = 45000;
        this.velocidadMaxima = 50;
        this.equipoEspecial = "Frenos Hidraulicos";
    }
}
