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
     * Build hamburger
     * @return hamburger with all ingredients
     */
    public Hamburger build(){
        return new Hamburger(ingredients);
    }
}

