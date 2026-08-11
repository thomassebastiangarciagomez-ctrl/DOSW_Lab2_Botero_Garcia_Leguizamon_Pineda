package edu.eci.dosw.reto3;

public class AvionCargaLigera extends Vehiculo{
    
    public AvionCargaLigera(String categoria){
        this.categoria = categoria;
        this.tipo = "Air";
        this.precio = 450;
        this.velocidadMaxima = 560;
        this.equipoEspecial = "Trend de aterrizaje maritimo";
    }
}
