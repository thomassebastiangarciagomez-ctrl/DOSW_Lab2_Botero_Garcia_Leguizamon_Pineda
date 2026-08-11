package edu.eci.dosw;
import edu.eci.dosw.reto1.*;
import edu.eci.dosw.reto2.*;
//import edu.eci.dosw.reto3.*;
//import edu.eci.dosw.reto4.*;
import edu.eci.dosw.reto5.*;
//import edu.eci.dosw.reto6.*;
import edu.eci.dosw.reto7.*;
//import edu.eci.dosw.reto8.*;

/**
 * Hello world!
 *
 */
public class App {

    public App(){}

    /**
     * 
     */
    public void reto1(){
        Reto1 reto1 = new Reto1();
        reto1.addProduct("Pan", 2000);
        for(int i = 0; i < 5; i++) reto1.addProduct("Papa", 1500);
        reto1.addProduct("Carne", 10000);
        reto1.getBill();
    }

    /**
     * 
     */
    public void reto2(){
        Reto2 reto2 = new Reto2();
        reto2.addIngredient("Bread", 2000);
        reto2.addIngredient("Meat", 10000);
        reto2.addIngredient("Beacon", 5000);
        reto2.addIngredient("Cheese", 1000);
        reto2.addIngredient("Bread", 2000);

        reto2.buildHamburger();
    }

    /**
     * 
     */
    public void reto3(){

    }

    /**
     * 
     */
    public void reto4(){

    }

    /**
     * 
     */
    public void reto5(){
        Reto5 reto5 = new Reto5();

        Coffee coffee1 = reto5.addCoffee("Coffee", 2000.0);
        coffee1 = reto5.addTopping(coffee1, "caramel");
        coffee1 = reto5.addTopping(coffee1, "chocolate");
        coffee1 = reto5.addTopping(coffee1, "whipped");

        Coffee coffee2 = reto5.addCoffee("Coffee", 3000.0);
        coffee2 = reto5.addTopping(coffee2, "milk");
        coffee2 = reto5.addTopping(coffee2, "mint");

        reto5.getCoffeeShop().finalBill();
    }

    /**
     * 
     */
    public void reto6(){

    }

    /**
     * 
     */
    public void reto7(){
        Light light = new Light();
        LightCommand lc = new LightCommand(light, new User("Juan"));
        RemoteControl rc = new RemoteControl();
        rc.setCommand(lc);
        rc.pressExecuteBotton();
        rc.pressUndoBotton();
        rc.pressUndoBotton();
        
        lc = new LightCommand(light, new User("Pedro"));
        rc.setCommand(lc);
        rc.pressExecuteBotton();
        rc.getHistory().stream().forEach(c -> System.out.println(c+"\n"));
    }

    /**
     * 
     */
    public void reto8(){

    }

    public static void main(String[] args ){
        App app = new App();
        System.out.println(" ---- Reto 1 ----");
        app.reto1();
        System.out.println("\n ---- Reto 2 ----");
        app.reto2();
        System.out.println("\n ---- Reto 5 ----");
        app.reto5();
        System.out.println("\n ---- Reto 7 ----");
        app.reto7();
    }
}
