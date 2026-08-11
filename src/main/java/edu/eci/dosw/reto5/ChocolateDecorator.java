package edu.eci.dosw.reto5;

public class ChocolateDecorator extends Coffee {
    public static final double PRICE = 1500;
    private Coffee coffee;

    /**
     * ChocolateDecorator constructor
     * @param coffee coffee
     */
    public ChocolateDecorator(Coffee coffee){
        super(coffee.getPrice());
        this.coffee = coffee;
    }

    @Override
    public double getPrice(){
        return coffee.getPrice() + ChocolateDecorator.PRICE;
    }

    @Override
    public StringBuilder getDescription(){
        return coffee.getDescription().append("-Chocolat");
    }
}
