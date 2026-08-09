package edu.eci.dosw.reto2;

/** Hamburger class ingredient*/
public class Ingredient {
    private String name;
    private double price;

    /**
     * Ingredient constructor
     * @param name Ingredient name
     * @param price Ingredient price
     */
    public Ingredient(String name, double price){
        this.name = name;
        this.price = price;
    }
    
    /**
     * 
     * @return ingredient name
     */
    public String getName(){
        return this.name;
    }

    /**
     * 
     * @return ingredient price
     */
    public double getPrice(){
        return this.price;
    }
}
