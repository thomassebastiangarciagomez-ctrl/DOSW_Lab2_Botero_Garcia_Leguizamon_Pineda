package edu.eci.dosw.reto1;
import java.util.*;

/**
 * This class is for Laboratory 2 Challenge 1. This class is in construction
 *
 */
public class Bill {
    private final ArrayList<Product> products;
    private final Customer customer;

    public Bill(ArrayList<Product> products, Customer customer){
        this.customer = customer;
        this.products = products;
    }

    public ArrayList<Product> getProducts(){
        return new ArrayList<>(products);
    }

    public int getSubtotal(){
        return products.stream()
            .filter(p -> p.getPrice() > 0)
            .mapToInt(Product :: getPrice)
            .sum();
    }

    public double getDiscountAmount(){
        return getSubtotal() * customer.discountCustomer();
    }
    
    public double getTotal(){
        return getSubtotal() - getDiscountAmount();
    }
}
