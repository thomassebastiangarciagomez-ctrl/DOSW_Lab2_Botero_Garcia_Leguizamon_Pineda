package edu.eci.dosw.reto5;

public class WhippedCreamDecorator extends Coffee{
    public static final double PRICE = 800;
    private Coffee coffee;

    /**
     * WhippedCreamDecorator constructor
     * @param coffee coffee
     */
    public WhippedCreamDecorator(Coffee coffee){
        super(coffee.getPrice());
        this.coffee = coffee;
    }

    @Override
    public double getPrice(){
        return coffee.getPrice() + WhippedCreamDecorator.PRICE;
    }

    @Override
    public StringBuilder getDescription(){
        return coffee.getDescription().append("-WhippedCream");
    }
}
