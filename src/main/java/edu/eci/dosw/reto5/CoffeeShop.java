package edu.eci.dosw.reto5;
import java.util.*;
import java.util.stream.Collectors;

public class CoffeeShop {
    ArrayList<Coffee> coffees;

    public CoffeeShop(){
        coffees = new ArrayList<>();
    }

    /**
     * 
     * @return
     */
    public double calculatePrice(){
        double total = coffees.stream()
            .mapToDouble(Coffee::getPrice)
            .sum();
        return total;
    }


    /**
     * 
     * @return
     */
    public String showCoffie(){
        String description = coffees.stream()
            .map(s -> s.getDescription() + "\t --- \t" + s.getPrice())
            .collect(Collectors.joining("\n"));
        
        return description;
    }

    /**
     * 
     * @param price
     */
    public Coffee addCoffee(String name, double price){
        Coffee coffee = new Coffee(price);
        coffees.add(coffee);
        return coffee;
    }

    /**
     * 
     * @param coffee
     */
    public Coffee addTopping(Coffee coffee, String topping){
        int index = coffees.indexOf(coffee);
        Coffee decoration = PermutadorCoffee.addTopings(coffee, topping);
        coffees.set(index, decoration);
        return decoration;
    }

    public void finalBill(){
        String description = showCoffie();
        double price = calculatePrice();

        System.out.println("Coffee Shop\n" + description + "\n\n" + "Total: \t --- \t" + price);
    }
}
