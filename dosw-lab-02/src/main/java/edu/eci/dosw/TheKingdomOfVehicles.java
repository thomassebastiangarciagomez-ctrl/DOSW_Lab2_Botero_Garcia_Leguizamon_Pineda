package edu.eci.dosw.reto3;

import java.util.ArrayList;
import java.util.List;

public class TheKingdomOfVehicles {

    // Clase base
    public static abstract class Vehiculo {
        private String familia;
        private String categoria;
        private String modelo;
        private double precio;
        private List<String> equipamiento;

        public Vehiculo(String familia, String categoria, String modelo, double precio) {
            this.familia = familia;
            this.categoria = categoria;
            this.modelo = modelo;
            this.precio = calcularPrecio(precio, categoria);
            this.equipamiento = new ArrayList<>();
        }

        private double calcularPrecio(double base, String categoria) {
            switch (categoria.toLowerCase()) {
                case "economy": return base * 0.9;
                case "luxury":  return base * 1.5;
                case "used":    return base * 0.7;
                default:        return base;
            }
        }

        public String getFamilia() { return familia; }
        public String getCategoria() { return categoria; }
        public String getModelo() { return modelo; }
        public double getPrecio() { return precio; }

        public void mostrarInfo() {
            System.out.println("Familia: " + familia +
                               ", Categoría: " + categoria +
                               ", Modelo: " + modelo +
                               ", Precio: " + precio);
        }
    }

    // Familias
    public static abstract class LandVehicle extends Vehiculo {
        public LandVehicle(String categoria, String modelo, double precio) {
            super("Land", categoria, modelo, precio);
        }
    }
    public static abstract class WaterVehicle extends Vehiculo {
        public WaterVehicle(String categoria, String modelo, double precio) {
            super("Water", categoria, modelo, precio);
        }
    }
    public static abstract class AirVehicle extends Vehiculo {
        public AirVehicle(String categoria, String modelo, double precio) {
            super("Air", categoria, modelo, precio);
        }
    }

    // Modelos concretos
    // Land
    public static class Carro extends LandVehicle {
        public Carro(String categoria) { super(categoria, "Car", 15000); }
    }
    public static class Bicicleta extends LandVehicle {
        public Bicicleta(String categoria) { super(categoria, "Bicycle", 500); }
    }
    public static class Motocicleta extends LandVehicle {
        public Motocicleta(String categoria) { super(categoria, "Motorcycle", 8000); }
    }

    // Water
    public static class Lancha extends WaterVehicle {
        public Lancha(String categoria) { super(categoria, "Motorboat", 20000); }
    }
    public static class Velero extends WaterVehicle {
        public Velero(String categoria) { super(categoria, "Sailboat", 25000); }
    }
    public static class MotoAcuatica extends WaterVehicle {
        public MotoAcuatica(String categoria) { super(categoria, "Jet Ski", 12000); }
    }

    // Air
    public static class Avion extends AirVehicle {
        public Avion(String categoria) { super(categoria, "Airplane", 100000); }
    }
    public static class AvionLigero extends AirVehicle {
        public AvionLigero(String categoria) { super(categoria, "Light Aircraft", 50000); }
    }
    public static class Helicoptero extends AirVehicle {
        public Helicoptero(String categoria) { super(categoria, "Helicopter", 75000); }
    }

    // Factory
    public static class VehiculoFactory {
        public static Vehiculo crearVehiculo(String familia, String categoria, String modelo) {
            switch (familia.toLowerCase()) {
                case "land":
                    switch (modelo.toLowerCase()) {
                        case "car": return new Carro(categoria);
                        case "bicycle": return new Bicicleta(categoria);
                        case "motorcycle": return new Motocicleta(categoria);
                    }
                    break;
                case "water":
                    switch (modelo.toLowerCase()) {
                        case "motorboat": return new Lancha(categoria);
                        case "sailboat": return new Velero(categoria);
                        case "jetski": return new MotoAcuatica(categoria);
                    }
                    break;
                case "air":
                    switch (modelo.toLowerCase()) {
                        case "airplane": return new Avion(categoria);
                        case "lightaircraft": return new AvionLigero(categoria);
                        case "helicopter": return new Helicoptero(categoria);
                    }
                    break;
            }
            throw new IllegalArgumentException("Vehículo no reconocido");
        }
    }

    // Método principal
    public static void main(String[] args) {
        List<Vehiculo> seleccionados = new ArrayList<>();

        // Selección de vehículos
        seleccionados.add(VehiculoFactory.crearVehiculo("land", "economy", "car"));
        seleccionados.add(VehiculoFactory.crearVehiculo("land", "luxury", "motorcycle"));
        seleccionados.add(VehiculoFactory.crearVehiculo("water", "used", "sailboat"));
        seleccionados.add(VehiculoFactory.crearVehiculo("air", "luxury", "helicopter"));

        // Mostrar resumen
        System.out.println("=== Resumen de compra ===");
        seleccionados.forEach(Vehiculo::mostrarInfo);

        // Calcular total con Streams
        double total = seleccionados.stream()
                                    .mapToDouble(Vehiculo::getPrecio)
                                    .sum();

        System.out.println("Precio total de la compra: " + total);
    }
}
