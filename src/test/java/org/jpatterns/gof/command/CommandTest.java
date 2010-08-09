package org.jpatterns.gof.command;

import org.jpatterns.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Michael Hunger
 * @since 2010-07-14
 */
@CommandPattern.Invoker
@PatternParticipants(CommandTest.Command.class)
public class CommandTest {
  @Test
  public void executeCommand() {
    final TestCommand command = new TestCommand();
    new CommandReceiver().receive(command);
    assertEquals(true, command.ran);
  }

  @CommandPattern.Command
  @PatternParticipants(CommandReceiver.class)
  interface Command {
    void execute();
  }

  @CommandPattern.ConcreteCommand
  @PatternComment("This is our TestCommand")
  class TestCommand implements Command {
    private boolean ran;

    public void execute() {
      ran = true;
    }
  }

  @CommandPattern.Receiver
  @PatternParticipants(Command.class)
  private class CommandReceiver {

    public void receive(Command command) {
      command.execute();
    }
  }
}
