package edu.eci.dosw.reto7;

public class Light extends Device {
    private boolean state;
    public Light(){
        super("Light");
        state = false;
    }

    public String turnAcction(){
        if (!state){
            state = true;
            return "Turn on: "+this.getName();
        }else {
            state = false;
            return "Turn off: "+this.getName();
        }
    } 
}
