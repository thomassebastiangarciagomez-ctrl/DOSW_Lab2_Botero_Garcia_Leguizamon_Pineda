package edu.eci.dosw.reto5;
import java.util.*;
import java.util.function.Function;

public class PermutadorCoffee {
    
    private static final Map<String, Function<Coffee, Coffee>> TOPPINGS = Map.of(
        "caramel", CaramelDecorator::new,
        "chocolate", ChocolateDecorator::new,
        "milk", MilkDecorator::new,
        "whipped", WhippedCreamDecorator::new,
        "mint", MintDecorator::new
    );


    public static Coffee addTopings(Coffee coffee, String topping){
        Function<Coffee, Coffee> decorationConstructor = TOPPINGS.get(topping.toLowerCase());

        if(decorationConstructor == null) {
            System.out.println("This topping doesn't exist");
            return coffee;
        }

        return decorationConstructor.apply(coffee);
    }
}
