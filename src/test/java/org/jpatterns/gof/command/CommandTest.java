package org.jpatterns.gof.command;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Michael Hunger
 * @since 2010-07-14
 */
@CommandPattern.Invoker(command = CommandTest.Command.class)
public class CommandTest {
  @Test
  public void executeCommand() {
    final TestCommand command = new TestCommand();
    new CommandReceiver().receive(command);
    assertEquals(true, command.ran);
  }

  @CommandPattern.Command(receiver = CommandReceiver.class, comment = "BaseCommand")
  interface Command {
    void execute();
  }

  @CommandPattern.ConcreteCommand(comment = "This is our TestCommand")
  class TestCommand implements Command {
    private boolean ran;

    public void execute() {
      ran = true;
    }
  }

  @CommandPattern.Receiver(command = Command.class)
  private class CommandReceiver {

    public void receive(Command command) {
      command.execute();
    }
  }
}
