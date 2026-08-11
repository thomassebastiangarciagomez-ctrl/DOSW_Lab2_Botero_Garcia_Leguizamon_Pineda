package edu.eci.dosw.reto7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Simple unit tests for the RemoteControl invoker.
 */
public class RemoteControlTest {

    private RemoteControl remoteControl;
    private Light light;

    @Before
    public void setUp() {
        remoteControl = new RemoteControl();
        light = new Light();
    }

    @Test
    public void pressExecuteBottonShouldAddEntryToHistory() {
        Command command = new LightCommand(light, new User("Pedro"));
        remoteControl.setCommand(command);

        remoteControl.pressExecuteBotton();

        assertEquals(1, remoteControl.getHistory().size());
    }

    @Test
    public void pressUndoBottonShouldAddEntryWhenActionWasExecuted() {
        Command command = new LightCommand(light, new User("Pedro"));
        remoteControl.setCommand(command);

        remoteControl.pressExecuteBotton();
        remoteControl.pressUndoBotton();

        assertEquals(2, remoteControl.getHistory().size());
    }

    @Test
    public void pressUndoBottonShouldNotAddEntryWhenNoActionWasExecuted() {
        Command command = new LightCommand(light, new User("Pedro"));
        remoteControl.setCommand(command);

        remoteControl.pressUndoBotton();

        assertTrue(remoteControl.getHistory().isEmpty());
    }

    @Test
    public void historyShouldKeepRecordOfEachUserThatExecutedAnAction() {
        remoteControl.setCommand(new LightCommand(light, new User("Pedro")));
        remoteControl.pressExecuteBotton();

        remoteControl.setCommand(new DoorCommand(new Door(), new User("Daniel")));
        remoteControl.pressExecuteBotton();

        assertTrue(remoteControl.getHistory().get(0).contains("Pedro"));
        assertTrue(remoteControl.getHistory().get(1).contains("Daniel"));
    }
}
