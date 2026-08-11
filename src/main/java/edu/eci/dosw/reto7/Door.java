package edu.eci.dosw.reto7;

public class Door extends Device {
    private boolean state;
    public Door(){
        super("Door");
        state = false;
    }

    public String doorAction(){
        if(!state){
            state = true;
            return "Open: "+this.getName();
        }else{
            state = false;
            return "Close: "+this.getName();
        }
    }
}
