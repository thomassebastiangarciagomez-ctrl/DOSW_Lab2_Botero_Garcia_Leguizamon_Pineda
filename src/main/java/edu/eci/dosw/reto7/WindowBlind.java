package edu.eci.dosw.reto7;

public class WindowBlind extends Device {
    private boolean state;
    public WindowBlind(){
        super("WindowBlind");
        state = false;
    }

    public String windowBlindAction(){
        if(!state){
            state = true;
            return "Move Right: "+this.getName();
        }else{
            state = false;
            return "Move Left: "+this.getName();
        }
    }
}
