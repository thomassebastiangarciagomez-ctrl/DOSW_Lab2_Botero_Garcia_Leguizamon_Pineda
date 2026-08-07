package edu.eci.dosw.reto1;
import java.util.*;

public class Reto1 {
    ArrayList<Product> products;
    Bill bill;
    //Customer customer = new Customer();

    public Reto1(){
        products = new ArrayList<>();
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
        bill = new Bill(products);
        bill.createBill();
    }

    public static void main(String[] args){
        Reto1 reto1 = new Reto1();
        reto1.getBill();
    }
}
