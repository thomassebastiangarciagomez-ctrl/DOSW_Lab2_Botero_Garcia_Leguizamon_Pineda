package edu.eci.dosw.reto3;

public class Bicicleta extends Vehiculo{
    
    
    public static final int PRECIO = 45000;
    public static final String TIPO = "Land";
    public static final int VELOCIDADMAXIMA = 50;
    public static final String EQUIPOESPECIAL = "Frenos Hidraulicos";

    public Bicicleta(String categoria){
        this.categoria = categoria;
        this.tipo = Carro.TIPO;
        this.precio = Carro.PRECIO;
        this.velocidadMaxima = Carro.VELOCIDADMAXIMA;
        this.equipoEspecial = Carro.EQUIPOESPECIAL;
    }
}
