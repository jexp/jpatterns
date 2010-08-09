package org.jpatterns.gof;

import org.jpatterns.*;

import java.lang.annotation.*;

/**
 * @author Michael Hunger
 * @since 2010-08-08
 */
@Retention(value = RetentionPolicy.RUNTIME)
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
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface ConcreteCommand {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Invoker {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Receiver {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Client {
  }
}
