package edu.eci.dosw.reto1;

public class FrequentCustomer implements Customer{
    private static final double CUSTOMER_DISCOUNT = 0.1;
    private static final String CUSTOMER_NAME = "Frecuente";

    @Override
    public double discountCustomer(){
        return CUSTOMER_DISCOUNT;
    }

    @Override
    public String getTypeName(){
        return CUSTOMER_NAME;
    }
}
