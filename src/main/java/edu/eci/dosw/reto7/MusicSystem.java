package edu.eci.dosw.reto7;

public class MusicSystem extends Device{
    private boolean state;
    public MusicSystem(){
        super("MusicSystem");
        state = false;
    }

    public String musicSystemAction(){
        if(!state){
            state = true;
            return "Inclease volume: "+this.getName();
        }else{
            state = false;
            return "Decrease volume: "+this.getName();
        }
    }
    
}
