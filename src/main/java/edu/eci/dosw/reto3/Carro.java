package edu.eci.dosw.reto3;

public class Carro extends Vehiculo{

    public static final int PRECIO = 145000;
    public static final String TIPO = "Land";
    public static final int VELOCIDADMAXIMA = 120;
    public static final String EQUIPOESPECIAL = "Luces antiniebla";

    public Carro(String categoria){
        this.categoria = categoria;
        this.tipo = Carro.TIPO;
        this.precio = Carro.PRECIO;
        this.velocidadMaxima = Carro.VELOCIDADMAXIMA;
        this.equipoEspecial = Carro.EQUIPOESPECIAL;
    }
}
