package edu.eci.dosw.reto5;

public class MintDecorator extends Coffee{
    public static final double PRICE = 1800;
    private Coffee coffee;

    /**
     * MintDecorator constructor
     * @param coffee coffee
     */
    public MintDecorator(Coffee coffee){
        super(coffee.getPrice());
        this.coffee = coffee;
    }

    @Override
    public double getPrice(){
        return coffee.getPrice() + MintDecorator.PRICE;
    }

    @Override
    public StringBuilder getDescription(){
        return coffee.getDescription().append("-Mint");
    }
}
