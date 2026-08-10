package edu.eci.dosw.reto2;
import java.util.*;

public class Hamburger {
    
    private List<Ingredient> ingredients;

    public Hamburger(List<Ingredient> ingredients){
        this.ingredients = ingredients;
    }

    /**
     * This method return a list of ingredients from hamburger
     * 
     * @return List that represents the ingredients from hamburger
     */
    public List<Ingredient> getIngredients(){
        return ingredients;
    }
}
