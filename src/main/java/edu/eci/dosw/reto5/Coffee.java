package edu.eci.dosw.reto5;

/**
 * Coffee class
 */
public class Coffee{
    private double price;
    private StringBuilder description;

    /**
     * Coffee constructor
     * @param price Coffee price
     */
    public Coffee(double price){
        this.price = price;
        this.description = new StringBuilder("Coffe");
    }

    /**
     * @return coffee price
     */
    public double getPrice(){
        return this.price;
    }

    /**
     * @return coffee description
     */
    public StringBuilder getDescription(){
        return this.description;
    }
}