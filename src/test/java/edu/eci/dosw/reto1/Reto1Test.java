package edu.eci.dosw.reto1;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */
public class Reto1Test {

    private ArrayList<Product> products;
    private Customer newCustomer;
    private Customer frequentCustomer;

    @Before
    public void setUp() {
        products = new ArrayList<>();
        products.add(new Product("Manzana", 1000));
        products.add(new Product("Manzana", 1000));
        products.add(new Product("Pan", 2000));

        newCustomer = CustomerFactory.createCustomer(CustomerType.NEW);
        frequentCustomer = CustomerFactory.createCustomer(CustomerType.FREQUENT);
    }

    @Test
    public void shouldReturnProductNameAndPrice() {
        Product product = new Product("Queso", 3000);
        assertEquals("Queso", product.getName());
        assertEquals(3000, product.getPrice());
    }

    @Test
    public void shouldReturnNewCustomerDiscountAndType() {
        assertEquals(0.05, newCustomer.discountCustomer(), 0.0001);
        assertEquals("Nuevo", newCustomer.getTypeName());
    }

    @Test
    public void shouldReturnFrequentCustomerDiscountAndType() {
        assertEquals(0.1, frequentCustomer.discountCustomer(), 0.0001);
        assertEquals("Frecuente", frequentCustomer.getTypeName());
    }

    @Test
    public void shouldCreateNewCustomerInstance() {
        Customer customer = CustomerFactory.createCustomer(CustomerType.NEW);
        assertTrue(customer instanceof NewCustomer);
    }

    @Test
    public void shouldCreateFrequentCustomerInstance() {
        Customer customer = CustomerFactory.createCustomer(CustomerType.FREQUENT);
        assertTrue(customer instanceof FrequentCustomer);
    }

    @Test
    public void shouldReturnCopyOfProductsList() {
        Bill bill = new Bill(products, newCustomer);
        ArrayList<Product> returned = bill.getProducts();

        assertEquals(products.size(), returned.size());
        assertNotSame("getProducts debe devolver una copia, no la misma referencia", products, returned);
    }

    @Test
    public void shouldCalculateSubtotalWithNewCustomer() {
        Bill bill = new Bill(products, newCustomer);
        // 1000 + 1000 + 2000
        assertEquals(4000, bill.getSubtotal());
    }

    @Test
    public void shouldIgnoreProductsWithNonPositivePriceInSubtotal() {
        products.add(new Product("Gratis", 0));
        Bill bill = new Bill(products, newCustomer);
        assertEquals(4000, bill.getSubtotal());
    }

    @Test
    public void shouldCalculateDiscountAmountForNewCustomer() {
        Bill bill = new Bill(products, newCustomer);
        assertEquals(4000 * 0.05, bill.getDiscountAmount(), 0.0001);
    }

    @Test
    public void shouldCalculateDiscountAmountForFrequentCustomer() {
        Bill bill = new Bill(products, frequentCustomer);
        assertEquals(4000 * 0.1, bill.getDiscountAmount(), 0.0001);
    }

    @Test
    public void shouldCalculateTotalForNewCustomer() {
        Bill bill = new Bill(products, newCustomer);
        double expectedTotal = 4000 - (4000 * 0.05);
        assertEquals(expectedTotal, bill.getTotal(), 0.0001);
    }

    @Test
    public void shouldCalculateTotalForFrequentCustomer() {
        Bill bill = new Bill(products, frequentCustomer);
        double expectedTotal = 4000 - (4000 * 0.1);
        assertEquals(expectedTotal, bill.getTotal(), 0.0001);
    }

    @Test
    public void shouldCreateBillWithoutThrowingException() {
        Bill bill = new Bill(products, newCustomer);
        bill.createBill();
    }

    @Test
    public void shouldCreateBillWithEmptyProductsList() {
        Bill bill = new Bill(new ArrayList<Product>(), newCustomer);
        assertEquals(0, bill.getSubtotal());
        assertEquals(0.0, bill.getDiscountAmount(), 0.0001);
        assertEquals(0.0, bill.getTotal(), 0.0001);
        bill.createBill();
    }

    @Test
    public void shouldAddProductToReto1() {
        Reto1 reto1 = new Reto1();
        reto1.addProduct("Leche", 2500);

        assertEquals(1, reto1.products.size());
        assertEquals("Leche", reto1.products.get(0).getName());
        assertEquals(2500, reto1.products.get(0).getPrice());
    }

    @Test
    public void shouldGenerateBillFromReto1WithoutException() {
        Reto1 reto1 = new Reto1();
        reto1.addProduct("Leche", 2500);
        reto1.addProduct("Leche", 2500);
        reto1.addProduct("Pan", 1500);

        reto1.getBill();
        assertNotNull(reto1.bill);
    }

    @Test
    public void shouldInitializeReto1WithNewCustomerByDefault() {
        Reto1 reto1 = new Reto1();
        assertTrue(reto1.customer instanceof NewCustomer);
        assertTrue(reto1.products.isEmpty());
    }
}
