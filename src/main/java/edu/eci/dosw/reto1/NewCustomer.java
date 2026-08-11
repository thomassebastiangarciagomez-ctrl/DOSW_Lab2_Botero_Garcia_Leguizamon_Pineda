package edu.eci.dosw.reto1;

public class NewCustomer implements Customer{
    private static final double CUSTOMER_DISCOUNT = 0.05;
    private static final String CUSTOMER_TYPE = "Nuevo"; 

    @Override
    public double discountCustomer(){
        return CUSTOMER_DISCOUNT;
    }

    @Override
    public String getTypeName(){
        return CUSTOMER_TYPE;
    }
}