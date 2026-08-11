package edu.eci.dosw.reto7;

public abstract class Device {
    private String name;

    public Device(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
