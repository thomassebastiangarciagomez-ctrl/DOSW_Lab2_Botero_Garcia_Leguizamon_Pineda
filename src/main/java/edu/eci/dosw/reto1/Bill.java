package edu.eci.dosw.reto1;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This class is for Laboratory 2 Challenge 1. This class is in construction
 *
 */
public class Bill {
    ArrayList<Product> products;
    private int sumAll;
    //Private Customer customer;

    public Bill(ArrayList<Product> products){
        sumAll = 0;
        this.products = new ArrayList<>();
        this.products = products;
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
        
        //Calculate the result
        sumAll += 1;

        System.out.println(list + "\n" + "Final price: " + sumAll);
    }
}
