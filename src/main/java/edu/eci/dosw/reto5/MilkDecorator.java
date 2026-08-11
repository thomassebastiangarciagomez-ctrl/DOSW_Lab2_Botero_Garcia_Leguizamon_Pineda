package edu.eci.dosw.reto5;

/**
 * 
 * MilkDecorator class
 */
public class MilkDecorator extends Coffee {
    public static final double PRICE = 1000;
    private Coffee coffee;

    /**
     * MilkDecorator constructor
     * @param coffee coffee
     */
    public MilkDecorator(Coffee coffee){
        super(coffee.getPrice());
        this.coffee = coffee;
    }

    @Override
    public double getPrice(){
        return coffee.getPrice() + MilkDecorator.PRICE;
    }

    @Override
    public StringBuilder getDescription(){
        return coffee.getDescription().append("-Milk");
    }
}
