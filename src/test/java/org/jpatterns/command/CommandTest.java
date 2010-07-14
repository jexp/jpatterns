package org.jpatterns.command;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Michael Hunger
 * @since 14.07.2010
 */
public class CommandTest {
    @Test
    public void executeCommand() {
        final TestCommand command = new TestCommand();
        new CommandReceiver().receive(command);
        assertEquals(true,command.ran);
    }

    @_Command(receiver = CommandReceiver.class, comment = "BaseCommand")
    interface Command {
        void execute();
    }

    @_Command(client = CommandTest.class, comment = "This is our TestCommand")
    class TestCommand implements Command {
        private boolean ran;

        public void execute() {
            ran=true;
        }
    }

    @_CommandProcessor
    private class CommandReceiver {

        public void receive(Command command) {
            command.execute();
        }
    }
}
