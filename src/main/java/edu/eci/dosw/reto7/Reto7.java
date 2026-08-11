package edu.eci.dosw.reto7;

public class Reto7 {
    public static void run(){
        System.out.println("Running Challenge 7 The magic remote control");
        Light light = new Light();
        Door door = new Door();
        MusicSystem ms = new MusicSystem();

        Command lc = new LightCommand(light, new User("Juan"));
        RemoteControl rc = new RemoteControl();
        rc.setCommand(lc);
        rc.pressExecuteBotton();
        rc.pressUndoBotton();
        rc.pressUndoBotton();
        
        lc = new MusicSystemCommand(ms, new User("Pedro"));
        rc.setCommand(lc);
        rc.pressExecuteBotton();

        lc = new DoorCommand(door, new User("Daniel"));
        rc.setCommand(lc);
        rc.pressExecuteBotton();
        rc.getHistory().stream().forEach(c -> System.out.println(c+"\n"));
    }
}
