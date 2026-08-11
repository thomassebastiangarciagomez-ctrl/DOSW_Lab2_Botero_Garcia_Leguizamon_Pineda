package edu.eci.dosw.reto3;

public class TerrestreCreator extends VehiculoFactory{

    public TerrestreCreator(){

    }

    @Override
    public Vehiculo ventaVehiculo(String tipo, String categoria){
        return this.crearVehiculo(tipo, categoria);
    }

    @Override
    protected Vehiculo crearVehiculo(String tipo, String categoria){
        Vehiculo vehiculo;
        switch (tipo) {
            case "carro":
                vehiculo = new Carro(categoria);
                break;
            case "moto":
                vehiculo = new Moto(categoria);
                break;
            case "bicicleta":
                vehiculo = new Bicicleta(categoria);
            default:
                vehiculo = new Carro(categoria);
                break;
        }
        return vehiculo;
    }
    
}
