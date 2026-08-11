package edu.eci.dosw.reto3;

public class MotoAcuatica extends Vehiculo{
    
    public MotoAcuatica(String categoria){
        this.categoria = categoria;
        this.tipo = "Water";
        this.precio = 75000;
        this.velocidadMaxima = 50;
        this.equipoEspecial = "Paracaidas";
    }
}
