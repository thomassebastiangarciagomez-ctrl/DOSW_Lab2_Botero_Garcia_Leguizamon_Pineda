package edu.eci.dosw.reto3;

public abstract class VehiculoFactory {
    
    //Abstract method
    protected abstract Vehiculo crearVehiculo(String tipo, String categoria);

    /**
     * 
     * @param tipo
     * @param categoria
     */
    public abstract Vehiculo ventaVehiculo(String tipo, String categoria);
}
