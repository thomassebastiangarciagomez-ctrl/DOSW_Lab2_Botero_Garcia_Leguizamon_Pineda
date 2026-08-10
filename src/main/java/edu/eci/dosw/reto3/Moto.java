package edu.eci.dosw.reto3;

public class Moto extends Vehiculo{
    
    
    public static final int PRECIO = 75000;
    public static final String TIPO = "Land";
    public static final int VELOCIDADMAXIMA = 100;
    public static final String EQUIPOESPECIAL = "Frenos ABS";

    public Moto(String categoria){
        this.categoria = categoria;
        this.tipo = Carro.TIPO;
        this.precio = Carro.PRECIO;
        this.velocidadMaxima = Carro.VELOCIDADMAXIMA;
        this.equipoEspecial = Carro.EQUIPOESPECIAL;
    }
}
