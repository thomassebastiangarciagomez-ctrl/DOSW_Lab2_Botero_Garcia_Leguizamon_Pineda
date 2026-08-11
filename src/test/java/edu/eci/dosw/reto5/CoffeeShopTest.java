package edu.eci.dosw.reto5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Simple unit tests for the CoffeeShop class.
 */
public class CoffeeShopTest {

    private CoffeeShop coffeeShop;

    @Before
    public void setUp() {
        coffeeShop = new CoffeeShop();
    }

    @Test
    public void calculatePriceShouldSumPricesOfAllAddedCoffees() {
        coffeeShop.addCoffee("Espresso", 3000);
        coffeeShop.addCoffee("Latte", 4000);

        assertEquals(7000, coffeeShop.calculatePrice(), 0.0);
    }

    @Test
    public void calculatePriceShouldNotChangeWhenNoCoffeeIsAdded() {
        assertEquals(0, coffeeShop.calculatePrice(), 0.0);
    }

    @Test
    public void addToppingShouldUpdateCoffeePriceInTheShop() {
        Coffee coffee = coffeeShop.addCoffee("Espresso", 3000);

        coffeeShop.addTopping(coffee, "milk");

        assertEquals(3000 + MilkDecorator.PRICE, coffeeShop.calculatePrice(), 0.0);
    }

    @Test
    public void showCoffieShouldContainDescriptionOfEachCoffee() {
        coffeeShop.addCoffee("Espresso", 3000);

        assertTrue(coffeeShop.showCoffie().contains("Coffe"));
    }
}
