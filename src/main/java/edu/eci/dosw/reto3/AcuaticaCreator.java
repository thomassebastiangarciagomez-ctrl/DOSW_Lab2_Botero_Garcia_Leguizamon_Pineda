package edu.eci.dosw.reto3;

public class AcuaticaCreator extends VehiculoFactory{
    public AcuaticaCreator(){}

    @Override
    public Vehiculo ventaVehiculo(String tipo, String categoria){
        return this.crearVehiculo(tipo, categoria);
    }

    @Override
    protected Vehiculo crearVehiculo(String tipo, String categoria){
        Vehiculo vehiculo;
        switch (tipo) {
            case "velero":
                vehiculo = new Velero(categoria);
                break;
            case "motoAcuatica":
                vehiculo = new MotoAcuatica(categoria);
                break;
            case "lancha":
                vehiculo = new Lancha(categoria);
            default:
                vehiculo = new Velero(categoria);
                break;
        }
        return vehiculo;
    }
    
}
