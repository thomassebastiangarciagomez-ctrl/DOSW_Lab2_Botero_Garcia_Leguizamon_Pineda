package edu.eci.dosw.reto5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Simple unit tests for the Coffee base class, its decorators,
 * and the topping registry (PermutadorCoffee).
 */
public class CoffeeTest {

    @Test
    public void coffeeShouldReturnGivenBasePrice() {
        Coffee coffee = new Coffee(5000);

        assertEquals(5000, coffee.getPrice(), 0.0);
    }

    @Test
    public void coffeeDescriptionShouldStartWithCoffe() {
        Coffee coffee = new Coffee(5000);

        assertEquals("Coffe", coffee.getDescription().toString());
    }

    @Test
    public void milkDecoratorShouldAddToppingPriceToBaseCoffee() {
        Coffee coffee = new Coffee(5000);
        Coffee decorated = new MilkDecorator(coffee);

        assertEquals(5000 + MilkDecorator.PRICE, decorated.getPrice(), 0.0);
    }

    @Test
    public void milkDecoratorShouldAppendToppingNameToDescription() {
        Coffee coffee = new Coffee(5000);
        Coffee decorated = new MilkDecorator(coffee);

        assertTrue(decorated.getDescription().toString().contains("-Milk"));
    }

    @Test
    public void combiningDecoratorsShouldAccumulatePriceAndDescription() {
        Coffee coffee = new Coffee(5000);
        Coffee decorated = new ChocolateDecorator(new MilkDecorator(coffee));

        assertEquals(5000 + MilkDecorator.PRICE + ChocolateDecorator.PRICE, decorated.getPrice(), 0.0);
        assertTrue(decorated.getDescription().toString().contains("-Milk-Chocolat"));
    }

    @Test
    public void permutadorCoffeeShouldReturnDecoratedCoffeeForKnownTopping() {
        Coffee coffee = new Coffee(5000);

        Coffee decorated = PermutadorCoffee.addTopings(coffee, "milk");

        assertTrue(decorated instanceof MilkDecorator);
    }

    @Test
    public void permutadorCoffeeShouldNotDecorateCoffeeForUnknownTopping() {
        Coffee coffee = new Coffee(5000);

        Coffee result = PermutadorCoffee.addTopings(coffee, "unknownTopping");

        assertEquals(coffee, result);
    }
}
