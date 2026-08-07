package edu.eci.dosw.reto1;

public class Product{
    private int price;
    private String name;
    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String gerName(){
        return name;
    }

    public int getPrice(){
        return price;
    }
}

