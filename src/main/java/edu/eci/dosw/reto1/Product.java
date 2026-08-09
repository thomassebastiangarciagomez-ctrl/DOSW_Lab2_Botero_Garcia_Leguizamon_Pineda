package edu.eci.dosw.reto1;

public class Product{
    private final int price;
    private final String name;
    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }
}

