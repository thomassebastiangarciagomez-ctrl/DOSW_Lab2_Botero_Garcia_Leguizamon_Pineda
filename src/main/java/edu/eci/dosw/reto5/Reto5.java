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

    public static void main(String[] args){
        Reto5 reto5 = new Reto5();

        Coffee coffee1 = reto5.addCoffee("Coffee", 2000.0);
        coffee1 = reto5.addTopping(coffee1, "caramel");
        coffee1 = reto5.addTopping(coffee1, "chocolate");
        coffee1 = reto5.addTopping(coffee1, "whipped");

        Coffee coffee2 = reto5.addCoffee("Coffee", 3000.0);
        coffee2 = reto5.addTopping(coffee2, "milk");
        coffee2 = reto5.addTopping(coffee2, "mint");

        reto5.getCoffeeShop().finalBill();
    }
}
