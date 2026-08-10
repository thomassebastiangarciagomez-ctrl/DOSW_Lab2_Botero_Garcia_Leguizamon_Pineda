package edu.eci.dosw.reto3;

public class TerrestreCreator extends VehiculoFactory{

    /**
     * 
     */
    @Override
    protected Vehiculo crearVehiculo(String tipo, String categoria){
        return new Carro("");
    }
    
}
