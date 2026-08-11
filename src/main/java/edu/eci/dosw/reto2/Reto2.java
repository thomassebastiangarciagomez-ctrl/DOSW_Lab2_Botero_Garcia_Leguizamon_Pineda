package edu.eci.dosw.reto2;

public class Reto2 {
    HamburgerBuilder hamburgerBuilder;

    public Reto2(){
        hamburgerBuilder = new HamburgerBuilder();
    }

    /**
     * This method works on add any ingredient that the chef wants
     * to add in the burger
     * 
     * @param ingredient String that represent the name of the ingredient
     * @param price Double that represents the price of the ingredient
     */
    public void addIngredient(String ingredient, double price){
        switch (ingredient) {
            case "Bread": hamburgerBuilder.bread(price); break;
            case "Meat": hamburgerBuilder.meat(price); break;
            case "Cheese": hamburgerBuilder.cheese(price); break;
            case "Vegetables": hamburgerBuilder.vegetables(price); break;
            case "Sauces": hamburgerBuilder.sauces(price); break;
            default: hamburgerBuilder.other(ingredient, price); break;
        }
    }

    /**
     * This method create the hamburger with the ingredients added and
     * calculate the final price
     * 
     */
    public void buildHamburger(){
        Hamburger hamburger = hamburgerBuilder.build();
        HamburgerService hamburgerService = new HamburgerService(hamburger);
        hamburgerService.calculatePrice();
    }
}
