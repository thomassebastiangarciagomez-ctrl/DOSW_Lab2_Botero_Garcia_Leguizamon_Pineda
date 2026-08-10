package edu.eci.dosw.reto1;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This class is for Laboratory 2 Challenge 1. This class is in construction
 *
 */
public class Bill {
    private ArrayList<Product> products;
    private Customer customer;

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

    /**
     * This method works on create and calculate the final value of the products
     * that the customer paid
     * 
     */
    public void createBill(){
        String list = products.stream()
            .collect(Collectors.groupingBy(Product::getName))
            .entrySet().stream()
            .map(s -> s.getKey() + " X" + s.getValue().size() + 
            "\t --- \t" + s.getValue().stream().mapToDouble(Product::getPrice).sum())
            .collect(Collectors.joining("\n"));

        System.out.println(list + "\n\nSubtotal: \t --- \t" + getSubtotal() + "\nDiscount: \t --- \t" + getDiscountAmount() + "\nFinal price: \t --- \t" + getTotal());
    }
}
