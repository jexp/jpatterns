package org.jpatterns.gof.command;

import org.jpatterns.*;
import org.jpatterns.gof.composite.CompositePattern;

import java.lang.annotation.*;

/**
 * @author Michael Hunger
 * @since 2010-08-08
 */
@Retention(value = RetentionPolicy.RUNTIME)
// HK: I think we should use RUNTIME so that the information about the patterns is always available, even to Reflection
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(source = Source.GoF,
    type = Type.BEHAVIORAL,
    urls = {"http://en.wikipedia.org/wiki/Command_pattern",
        "http://home.earthlink.net/~huston2/dp/command.html"},
    refactorings = {
        Refactoring.ExtractParameterObject, // HK: I would leave out the refactorings for now - information overload - we can put that in later
        Refactoring.ExtractMethodObject},
    related = {CompositePattern.class})
// HK: should we really do this?  I would not want to re-document everything that is already in GoF.  The purpose of these annotations should be to document patterns in our code.

public @interface CommandPattern {
  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Command {
    boolean undoable() default false;
    String comment() default "";
    Class receiver() default void.class; // HK: The command would not know about what receiver it is talking to
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface ConcreteCommand {
    String comment() default "";
    // HK: This one would know about the receiver it was created for
    Class[] participants() default {};
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Invoker {
    String comment() default "";
    Class command() default void.class; // HK: an invoker could potentially have more than one command
    Class[] participants() default {}; // HK: I would prefer this approach, leaving it up to the user to specify as much or as little as he wants
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Receiver {
    String comment() default "";
    Class command() default void.class; // HK: the receiver should not know about the commands that are invoking it - look at my example GUIActionTest
    Class[] participants() default {};
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Client {
    String comment() default "";
    Class[] participants() default {};
  }
}