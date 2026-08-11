package edu.eci.dosw.reto7;

public class WindowBlindCommand extends Command{
    private WindowBlind windowBlind;

    public WindowBlindCommand(WindowBlind windowBlind,User user){
        this.windowBlind = windowBlind;
        this.user = user;
        this.log = "No command execute";
    }
    @Override
    public void execute(){
        log = "Command execute By "+ user.getName()+" "+windowBlind.windowBlindAction();
    }
    @Override
    public void undo(){
        log = "Command undo By "+ user.getName()+" "+windowBlind.windowBlindAction();
    }
    @Override
    public String getLog(){
        return this.log;
    }
    
}
