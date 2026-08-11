package edu.eci.dosw.reto5;

public class Reto5 {
    private CoffeeShop coffeeShop;

    public Reto5(){
        coffeeShop = new CoffeeShop();
    }

    public CoffeeShop getCoffeeShop(){
        return coffeeShop;
    }

    /**
     * 
     * @param price
     */
    public Coffee addCoffee(String name, double price){
        return coffeeShop.addCoffee(name, price);
    }

    public Coffee addTopping(Coffee coffee, String topping){
        return coffeeShop.addTopping(coffee, topping);
    }
}
