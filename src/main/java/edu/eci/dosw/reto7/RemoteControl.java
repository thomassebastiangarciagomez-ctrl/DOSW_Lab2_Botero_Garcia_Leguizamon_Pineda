package edu.eci.dosw.reto7;
import java.util.List;
import java.util.ArrayList;

public class RemoteControl {
    private List<String> history;
    private Command command;
    private int executionActions;

    public RemoteControl(){
        history = new ArrayList<>();
        executionActions = 0;
    }
    public void setCommand(Command command){
        this.command = command;
    }
    public void pressExecuteBotton(){
        command.execute();
        executionActions++;
        history.add(command.getLog());
    }
    public void pressUndoBotton(){
        if(executionActions > 0){
            command.undo();
            history.add(command.getLog());
            executionActions--;
        }
    }
    public List<String> getHistory(){
        return history;
    }

    
}
