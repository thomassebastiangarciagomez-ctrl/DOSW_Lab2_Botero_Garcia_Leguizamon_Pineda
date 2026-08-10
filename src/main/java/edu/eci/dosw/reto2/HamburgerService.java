package edu.eci.dosw.reto2;

public class HamburgerService {

    public static void main(String[] args){
        Hamburger hamburger = new HamburgerBuilder()
                                    .bread(10)
                                    .meat(20)
                                    .build();
        System.out.println(hamburger.getIngredients().stream().mapToDouble(i -> i.getPrice()).sum());
    }
    
}
