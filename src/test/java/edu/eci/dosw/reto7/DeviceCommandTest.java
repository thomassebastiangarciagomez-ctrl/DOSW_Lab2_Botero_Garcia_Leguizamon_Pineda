package edu.eci.dosw.reto7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Simple unit tests for devices and their commands.
 */
public class DeviceCommandTest {

    private User user;

    @Before
    public void setUp() {
        user = new User("Juan");
    }

    @Test
    public void lightActionShouldToggleBetweenOnAndOff() {
        Light light = new Light();
        assertEquals("Turn on: Light", light.turnAcction());
        assertEquals("Turn off: Light", light.turnAcction());
    }

    @Test
    public void lightCommandExecuteShouldLogUserAndAction() {
        Light light = new Light();
        LightCommand command = new LightCommand(light, user);

        command.execute();

        assertTrue(command.getLog().contains("Juan"));
        assertTrue(command.getLog().contains("Turn on: Light"));
    }

    @Test
    public void lightCommandUndoShouldLogUserAndAction() {
        Light light = new Light();
        LightCommand command = new LightCommand(light, user);

        command.execute();
        command.undo();

        assertTrue(command.getLog().contains("Command undo By Juan"));
    }

    @Test
    public void doorCommandExecuteShouldNotProduceDefaultLog() {
        Door door = new Door();
        DoorCommand command = new DoorCommand(door, user);

        command.execute();

        assertTrue(!command.getLog().equals("No command execute"));
    }

    @Test
    public void doorActionShouldToggleBetweenOpenAndClose() {
        Door door = new Door();
        assertEquals("Open: Door", door.doorAction());
        assertEquals("Close: Door", door.doorAction());
    }
}
