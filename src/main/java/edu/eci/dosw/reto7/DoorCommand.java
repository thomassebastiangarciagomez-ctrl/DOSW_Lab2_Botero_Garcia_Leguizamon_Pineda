package edu.eci.dosw.reto7;

public class DoorCommand extends Command {
    private Door door;

    public DoorCommand(Door door,User user){
        this.door = door;
        this.user = user;
        this.log = "No command execute";
    }
    @Override
    public void execute(){
        log = "Command execute By "+ user.getName()+" "+door.doorAction();
    }
    @Override
    public void undo(){
        log = "Command undo By "+ user.getName()+" "+door.doorAction();
    }
    @Override
    public String getLog(){
        return this.log;
    }
    
}
