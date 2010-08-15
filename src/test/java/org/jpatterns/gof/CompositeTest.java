package org.jpatterns.gof;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;

import java.util.*;

public class CompositeTest {
  @CompositePattern.Component(participants = {DistributionList.class,
      Person.class})
  private static abstract class Contact {
    public abstract void sendMail(String msg);

    public void add(Contact contact) {
    }

    public void remove(Contact contact) {
    }
  }

  @CompositePattern.Leaf
  private static class Person extends Contact {
    private String lastMsg;
    private final String email;

    public Person(String email) {
      this.email = email;
    }

    public void sendMail(String msg) {
      System.out.println("here is the message: " + msg);
      lastMsg = msg;
    }

    private String getLastMessage() {
      return lastMsg;
    }
  }

  @CompositePattern.Composite(comment = "bla bla bla")
  private static class DistributionList extends Contact {
    private final Collection<Contact> contacts = new ArrayList<Contact>();

    public void sendMail(String msg) {
      for (Contact contact : contacts) {
        contact.sendMail(msg);
      }
    }

    public void add(Contact contact) {
      contacts.add(contact);
    }

    public void remove(Contact contact) {
      contacts.remove(contact);
    }
  }

  @Test
  public void personWasSentMessage() {
    Person heinz = new Person("heinz@javaspecialists.eu");
    Contact admins = new DistributionList();
    admins.add(heinz);
    Contact all = new DistributionList();
    all.add(admins);
    all.sendMail("hey there!");
    assertEquals("hey there!", heinz.getLastMessage());
  }
}