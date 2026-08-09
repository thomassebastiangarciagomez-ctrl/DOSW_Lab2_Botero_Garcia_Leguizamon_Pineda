package edu.eci.dosw.reto1;

public class CustomerFactory {
    private CustomerFactory(){
    }

    public static Customer createCustomer(CustomerType type){
        if(type == CustomerType.NEW){
            return new NewCustomer();
        }
        else{
            return new FrequentCustomer();
        }
    }
}
