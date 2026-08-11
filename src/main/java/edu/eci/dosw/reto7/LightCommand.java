package edu.eci.dosw.reto7;

public class LightCommand extends Command {
    private Light light;

    public LightCommand(Light light,User user){
        this.light = light;
        this.user = user;
        this.log = "No command execute";
    }
    @Override
    public void execute(){
        log = "Command execute By "+ user.getName()+" "+light.turnAcction();
    }
    @Override
    public void undo(){
        log = "Command undo By "+ user.getName()+" "+light.turnAcction();
    }
    @Override
    public String getLog(){
        return this.log;
    }
    
}
