package edu.eci.dosw.reto2;
import java.util.List;
import java.util.ArrayList;

/**
 * 
 * HamburgerBuilder
 */
public class HamburgerBuilder {
    private List<Ingredient> ingredients;

    public HamburgerBuilder(){
        this.ingredients = new ArrayList<>();
    }

    /**
     * Bread like hamburger ingredient
     * @param price bread price
     * @return hamburgerBuilder add bread
     */
    public HamburgerBuilder bread(double price){
        ingredients.add(new Ingredient("bread", price));
        return this;
    }

    /**
     * Meat like hamburger ingredient
     * @param price meat price
     * @return hamburgerBuilder add meat
     */
    public HamburgerBuilder meat(double price){
        ingredients.add(new Ingredient("meat", price));
        return this;
    }

    /**
     * Cheese like hamburger ingredient
     * @param price meat price
     * @return hamburgerBuilder add meat
     */
    public HamburgerBuilder cheese(double price){
        ingredients.add(new Ingredient("cheese", price));
        return this;
    }

    /**
     * Vegetables like hamburger ingredient
     * @param price meat price
     * @return hamburgerBuilder add meat
     */
    public HamburgerBuilder vegetables(double price){
        ingredients.add(new Ingredient("vegetables", price));
        return this;
    }

    /**
     * Sauces like hamburger ingredient
     * @param price meat price
     * @return hamburgerBuilder add meat
     */
    public HamburgerBuilder sauces(double price){
        ingredients.add(new Ingredient("sauces", price));
        return this;
    }

    /**
     * Other like hamburger ingredient
     * @param price meat price
     * @return hamburgerBuilder add meat
     */
    public HamburgerBuilder other(String name, double price){
        ingredients.add(new Ingredient(name, price));
        return this;
    }

    /**
     * Build hamburger
     * @return hamburger with all ingredients
     */
    public Hamburger build(){
        return new Hamburger(ingredients);
    }
}
