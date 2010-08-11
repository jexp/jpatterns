package org.jpatterns.gof;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Heinz Kabutz
 * @since 2010-08-09
 */
public class CommandGUIActionTest {
  @CommandPattern.Invoker
  private static class MyButton extends JButton {
    public MyButton(javax.swing.Action a) {
      super(a);
    }
  }

  @CommandPattern.ConcreteCommand(participants = MyReceiver.class)
  private static class FooAction extends AbstractAction {
    private final MyReceiver receiver;

    private FooAction(MyReceiver receiver) {
      super("Foo");
      this.receiver = receiver;
    }

    public void actionPerformed(ActionEvent e) {
      receiver.foo();
    }
  }

  @CommandPattern.ConcreteCommand
  private static class BarAction extends AbstractAction {
    private final MyReceiver receiver;

    private BarAction(MyReceiver receiver) {
      super("Bar");
      this.receiver = receiver;
    }

    public void actionPerformed(ActionEvent e) {
      receiver.bar();
    }
  }

  @CommandPattern.Receiver
  private static class MyReceiver {
    public void foo() {
      System.out.println("foo was pressed");
    }

    public void bar() {
      System.out.println("bar was pressed");
    }
  }

  @CommandPattern.Client
  private static class MyClient extends JFrame {
    public MyClient(Action... actions) {
      super("MyClient");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(400, 500);
      addActions(actions);
      setVisible(true);
    }

    private void addActions(Action... actions) {
      addButtons(actions);
      addMenus(actions);
    }

    private void addMenus(Action... actions) {
      JMenuBar menubar = new JMenuBar();
      JMenu menu = new JMenu("MyActions");
      menubar.add(menu);
      for (Action action : actions) {
        menu.add(new JMenuItem(action));
      }
      setJMenuBar(menubar);
    }

    private void addButtons(Action... actions) {
      setLayout(new FlowLayout());
      for (Action action : actions) {
        add(new MyButton(action));
      }
    }
  }

  public static void main(String[] args) {
    MyReceiver receiver = new MyReceiver();
    final FooAction foo_action = new FooAction(receiver);
    final BarAction bar_action = new BarAction(receiver);

    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new MyClient(foo_action, bar_action);
      }
    });
  }

  @Test
  public void bindUpReceivers() {
    MyReceiver receiver = new MyReceiver();
    final FooAction foo_action = new FooAction(receiver);
    final BarAction bar_action = new BarAction(receiver);
    foo_action.actionPerformed(null);
  }
}
