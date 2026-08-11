package edu.eci.dosw.reto1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class BillTest {

    @Test
    public void customerFactoryShouldReturnCorrectDiscountForNewCustomer() {
        Customer customer = CustomerFactory.createCustomer(CustomerType.NEW);
        assertEquals(0.05, customer.discountCustomer(), 0.001);
        assertEquals("Nuevo", customer.getTypeName());
    }

    @Test
    public void customerFactoryShouldReturnCorrectDiscountForFrequentCustomer() {
        Customer customer = CustomerFactory.createCustomer(CustomerType.FREQUENT);
        assertEquals(0.10, customer.discountCustomer(), 0.001);
        assertEquals("Frecuente", customer.getTypeName());
    }

    @Test
    public void billShouldCalculateCorrectSubtotal() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Camiseta", 20000));
        products.add(new Product("Camiseta", 20000));
        products.add(new Product("Galletas", 500));

        Bill bill = new Bill(products, CustomerFactory.createCustomer(CustomerType.FREQUENT));

        assertEquals(40500, bill.getSubtotal());
    }

    @Test
    public void billShouldExcludeInvalidPricesFromSubtotal() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Producto válido", 10000));
        products.add(new Product("Producto inválido", 0));
        products.add(new Product("Producto negativo", -500));

        Bill bill = new Bill(products, CustomerFactory.createCustomer(CustomerType.NEW));

        assertEquals(10000, bill.getSubtotal());
    }

    @Test
    public void billShouldCalculateDiscountAndTotalCorrectly() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Producto", 100000));

        Bill bill = new Bill(products, CustomerFactory.createCustomer(CustomerType.FREQUENT));

        assertEquals(10000.0, bill.getDiscountAmount(), 0.001);
        assertEquals(90000.0, bill.getTotal(), 0.001);
    }

    @Test
    public void getProductsShouldReturnDefensiveCopy() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Producto", 5000));

        Bill bill = new Bill(products, CustomerFactory.createCustomer(CustomerType.NEW));

        bill.getProducts().add(new Product("Intruso", 999999));

        assertEquals(1, bill.getProducts().size());
        assertTrue(bill.getSubtotal() == 5000);
    }
}