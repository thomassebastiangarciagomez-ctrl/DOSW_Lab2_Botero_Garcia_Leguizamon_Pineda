package edu.eci.dosw.reto3;

public abstract class Vehiculo {
    public String tipo;
    public String categoria;
    public int precio;
    public int velocidadMaxima;
    public String equipoEspecial;

    //Abstract methods

    public abstract String getTipo();
    public abstract int getPrecio();
    public abstract String getEquipoEspecial();


    /**
     * 
     * @return
     */
    public int getVelocidadMaxima(){
        return 0;
    }
}
