package edu.eci.dosw.reto2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */
public class Reto2Test {

    private HamburgerBuilder builder;

    @Before
    public void setUp() {
        builder = new HamburgerBuilder();
    }

    @Test
    public void shouldReturnIngredientNameAndPrice() {
        Ingredient ingredient = new Ingredient("bacon", 1500.0);
        assertEquals("bacon", ingredient.getName());
        assertEquals(1500.0, ingredient.getPrice(), 0.0001);
    }

    @Test
    public void shouldAddBreadIngredient() {
        Hamburger hamburger = builder.bread(500.0).build();
        assertEquals(1, hamburger.getIngredients().size());
        assertEquals("bread", hamburger.getIngredients().get(0).getName());
    }

    @Test
    public void shouldAddMeatIngredient() {
        Hamburger hamburger = builder.meat(3000.0).build();
        assertEquals("meat", hamburger.getIngredients().get(0).getName());
    }

    @Test
    public void shouldAddCheeseIngredient() {
        Hamburger hamburger = builder.cheese(1200.0).build();
        assertEquals("cheese", hamburger.getIngredients().get(0).getName());
    }

    @Test
    public void shouldAddVegetablesIngredient() {
        Hamburger hamburger = builder.vegetables(800.0).build();
        assertEquals("vegetables", hamburger.getIngredients().get(0).getName());
    }

    @Test
    public void shouldAddSaucesIngredient() {
        Hamburger hamburger = builder.sauces(400.0).build();
        assertEquals("sauces", hamburger.getIngredients().get(0).getName());
    }

    @Test
    public void shouldAddOtherIngredientWithCustomName() {
        Hamburger hamburger = builder.other("bacon", 1500.0).build();
        assertEquals("bacon", hamburger.getIngredients().get(0).getName());
        assertEquals(1500.0, hamburger.getIngredients().get(0).getPrice(), 0.0001);
    }

    @Test
    public void shouldSupportFluentChainingOfMultipleIngredients() {
        Hamburger hamburger = builder
            .bread(500.0)
            .meat(3000.0)
            .cheese(1200.0)
            .vegetables(800.0)
            .sauces(400.0)
            .other("bacon", 1500.0)
            .build();

        assertEquals(6, hamburger.getIngredients().size());
    }

    @Test
    public void shouldBuildHamburgerWithNoIngredients() {
        Hamburger hamburger = builder.build();
        assertTrue(hamburger.getIngredients().isEmpty());
    }

    @Test
    public void shouldReturnListOfIngredientsFromHamburger() {
        Hamburger hamburger = builder.bread(500.0).meat(3000.0).build();
        List<Ingredient> ingredients = hamburger.getIngredients();

        assertEquals(2, ingredients.size());
        assertEquals("bread", ingredients.get(0).getName());
        assertEquals("meat", ingredients.get(1).getName());
    }

    @Test
    public void shouldCalculatePriceWithoutThrowingException() {
        Hamburger hamburger = builder
            .bread(500.0)
            .meat(3000.0)
            .cheese(1200.0)
            .build();

        HamburgerService service = new HamburgerService(hamburger);
        service.calculatePrice();
    }

    @Test
    public void shouldCalculatePriceWithRepeatedIngredients() {
        Hamburger hamburger = builder
            .cheese(1200.0)
            .cheese(1200.0)
            .meat(3000.0)
            .build();

        HamburgerService service = new HamburgerService(hamburger);
        service.calculatePrice();
    }

    @Test
    public void shouldCalculatePriceWithEmptyIngredientsList() {
        Hamburger hamburger = builder.build();
        HamburgerService service = new HamburgerService(hamburger);
        service.calculatePrice();
    }

    @Test
    public void shouldAddBreadIngredientThroughReto2() {
        Reto2 reto2 = new Reto2();
        reto2.addIngredient("Bread", 500.0);
    }

    @Test
    public void shouldAddMeatIngredientThroughReto2() {
        Reto2 reto2 = new Reto2();
        reto2.addIngredient("Meat", 3000.0);
    }

    @Test
    public void shouldAddCheeseIngredientThroughReto2() {
        Reto2 reto2 = new Reto2();
        reto2.addIngredient("Cheese", 1200.0);
    }

    @Test
    public void shouldAddVegetablesIngredientThroughReto2() {
        Reto2 reto2 = new Reto2();
        reto2.addIngredient("Vegetables", 800.0);
    }

    @Test
    public void shouldAddSaucesIngredientThroughReto2() {
        Reto2 reto2 = new Reto2();
        reto2.addIngredient("Sauces", 400.0);
    }

    @Test
    public void shouldAddCustomIngredientThroughReto2DefaultCase() {
        Reto2 reto2 = new Reto2();
        reto2.addIngredient("Bacon", 1500.0);
    }

    @Test
    public void shouldBuildHamburgerFromReto2WithoutException() {
        Reto2 reto2 = new Reto2();
        reto2.addIngredient("Bread", 500.0);
        reto2.addIngredient("Meat", 3000.0);
        reto2.addIngredient("Bacon", 1500.0);

        reto2.buildHamburger();
    }
}
