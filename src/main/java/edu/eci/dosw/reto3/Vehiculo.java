package edu.eci.dosw.reto3;

public abstract class Vehiculo {
    protected String tipo;
    protected String categoria;
    protected int precio;
    protected int velocidadMaxima;
    protected String equipoEspecial;

    public String getTipo(){
        return this.tipo;
    }
    public int getPrecio(){
        return this.precio;
    }
    public String getEquipoEspecial(){
        return this.equipoEspecial;
    }

    public int getVelocidadMaxima(){
        return this.velocidadMaxima;
    }

    public String getCategoria(){
        return this.categoria;
    }
}
