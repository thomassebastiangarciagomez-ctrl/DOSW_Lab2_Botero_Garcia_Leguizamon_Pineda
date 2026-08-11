package edu.eci.dosw.reto7;

public class MusicSystemCommand extends Command{
    private MusicSystem musicSystem;

    public MusicSystemCommand(MusicSystem musicSystem,User user){
        this.musicSystem = musicSystem;
        this.user = user;
        this.log = "No command execute";
    }
    @Override
    public void execute(){
        log = "Command execute By "+ user.getName()+" "+musicSystem.musicSystemAction();
    }
    @Override
    public void undo(){
        log = "Command undo By "+ user.getName()+" "+musicSystem.musicSystemAction();
    }
    @Override
    public String getLog(){
        return this.log;
    }
    
}
