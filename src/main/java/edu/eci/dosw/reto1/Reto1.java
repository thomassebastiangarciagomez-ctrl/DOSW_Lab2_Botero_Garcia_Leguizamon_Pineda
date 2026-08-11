package edu.eci.dosw.reto1;
import java.util.*;

public class Reto1 {
    ArrayList<Product> products;
    Bill bill;
    CustomerType type;
    Customer customer;

    public Reto1(){
        products = new ArrayList<>();
        this.customer = CustomerFactory.createCustomer(CustomerType.NEW);
    }

    /**
     * This method works on create a product and add to products ArrayList
     * 
     * @param name String that represent the name of the product
     * @param value Integer that represent the value of the product
     */
    public void addProduct(String name, int value){
        Product product = new Product(name, value);
        products.add(product);
    }

    /**
     * This method create the final bill from a customer
     * 
     */
    public void getBill(){
        bill = new Bill(products, customer);
        bill.createBill();
    }
}
