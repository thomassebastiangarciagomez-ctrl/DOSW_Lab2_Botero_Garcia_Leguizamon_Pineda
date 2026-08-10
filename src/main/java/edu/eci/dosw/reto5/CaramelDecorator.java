package edu.eci.dosw.reto5;

public class CaramelDecorator extends Coffee{
    public static final double PRICE = 1200;
    private Coffee coffee;

    /**
     * CaramelDecorator constructor
     * @param coffee coffee
     */
    public CaramelDecorator(Coffee coffee){
        super(coffee.getPrice());
        this.coffee = coffee;
    }

    @Override
    public double getPrice(){
        return coffee.getPrice() + CaramelDecorator.PRICE;
    }

    @Override
    public StringBuilder getDescription(){
        return coffee.getDescription().append("-Caramel");
    }
}
