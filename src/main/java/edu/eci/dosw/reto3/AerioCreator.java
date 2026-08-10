package edu.eci.dosw.reto3;

public class AerioCreator extends VehiculoFactory{

    public AerioCreator(){}
    
    @Override
    public Vehiculo ventaVehiculo(String tipo, String categoria){
        return this.crearVehiculo(tipo, categoria);
    }

    @Override
    protected Vehiculo crearVehiculo(String tipo, String categoria){
        Vehiculo vehiculo;
        switch (tipo) {
            case "avion":
                vehiculo = new Avion(categoria);
                break;
            case "avionCargaLigera":
                vehiculo = new AvionCargaLigera(categoria);
                break;
            case "helicoptero":
                vehiculo = new Helicoptero(categoria);
            default:
                vehiculo = new Avion(categoria);
                break;
        }
        return vehiculo;
    }
}
