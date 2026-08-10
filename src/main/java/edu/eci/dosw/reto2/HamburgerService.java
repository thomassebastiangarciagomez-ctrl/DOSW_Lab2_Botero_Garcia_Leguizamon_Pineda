package edu.eci.dosw.reto2;
import java.util.*;
import java.util.stream.Collectors;

public class HamburgerService {

    private Hamburger hamburger;

    public HamburgerService(Hamburger hamburger){
        this.hamburger = hamburger;
    }

    /**
     * This method works on calculate the final price of hamburger
     * with the list of ingredients
     * 
     */
    public void calculatePrice(){
        List<Ingredient> ingredients = hamburger.getIngredients();
        double total = ingredients.stream()
            .mapToDouble(Ingredient::getPrice)
            .sum();
        
        String bill = ingredients.stream()
            .collect(Collectors.groupingBy(Ingredient::getName))
            .entrySet().stream()
            .map(s -> s.getKey() + " X" + s.getValue().size() +
            "\t --- \t" + s.getValue().stream().mapToDouble(Ingredient::getPrice).sum())
            .collect(Collectors.joining("\n"));
        
        System.out.println("Bill of the Hamburger\n" + bill + "\n\nTotal: \t --- \t" + total);
    }
}
