package edu.eci.dosw.reto3;

import java.util.ArrayList;
import java.util.List;

public class Reto3 {
    public static void run(){
        List<Vehiculo> vehiculos = new ArrayList<>();
        TerrestreCreator tc = new TerrestreCreator();
        vehiculos.add(tc.crearVehiculo("carro", "economy"));
        AerioCreator ac = new AerioCreator();
        vehiculos.add(ac.crearVehiculo("helicoptero","used"));
        AcuaticaCreator acc = new AcuaticaCreator();
        vehiculos.add(acc.crearVehiculo("velero", "luxury"));

        vehiculos.stream().forEach(v -> System.out.println("==Descripcion vehiculo:\n"+
            "Tipo: "+v.getTipo()+"\n"+
            "Categoria: "+v.getCategoria()+"\n"+
            "Velocidad Maxima: "+v.getVelocidadMaxima()+"\n"+
            "Equipo especial: "+v.getEquipoEspecial()+"\n"+
            "Precio: "+v.getPrecio()+"\n\n"
        ));
        System.out.println("Precio total: "+vehiculos.stream().mapToInt(v -> v.getPrecio()).sum());

    }
    
}
