package edu.eci.dosw.reto7;

public class Reto7 {
    public static void main(String[] args){
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
}
