package edu.eci.dosw.reto5;

public class Reto5 {
    CoffeeShop coffeeShop;

    public Reto5(){
        coffeeShop = new CoffeeShop();
    }

    /**
     * 
     * @param price
     */
    public void addCoffee(String name, double price){
        coffeeShop.addCoffee(name, price);
    }

    public static void main(String[] args){
        Reto5 reto5 = new Reto5();
        reto5.addCoffee("Coffee", 2000.0);
    }
}
