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
     */
    public void showCoffie(){
        String description = coffees.stream()
            .map(s -> s.getPrice() + " " + s.getDescription())
            .collect(Collectors.joining("\n"));
        
        System.out.println(description);
    }

    /**
     * 
     * @param price
     */
    public void addCoffee(String name, double price){
        Coffee coffee = new Coffee(price);
        coffees.add(coffee);
    }
}
