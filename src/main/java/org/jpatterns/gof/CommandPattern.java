package org.jpatterns.gof;

import org.jpatterns.core.*;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 233]:</b> Encapsulate a request as an object, thereby
 * letting you parameterize clients with different requests, queue or log
 * requests, and support undoable operations.
 *
 * <img alt="Command Structure" src="http://www.jpatterns.org/uml/gof/CommandStructure.gif">
 *
 * @author Michael Hunger
 * @since 2010-08-08
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@DesignPattern(source = Source.GoF,
    type = Type.BEHAVIORAL,
    urls = {"http://en.wikipedia.org/wiki/Command_pattern",
        "http://home.earthlink.net/~huston2/dp/command.html"},
    refactorings = {
        Refactoring.ExtractParameterObject,
        Refactoring.ExtractMethodObject},
    related = {CompositePattern.class, MementoPattern.class,
        PrototypePattern.class})

public @interface CommandPattern {
  Class[] participants() default {};

  String comment() default "";

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Command {
    Class[] participants() default {};

    String comment() default "";

    boolean undoable() default false;
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface ConcreteCommand {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Invoker {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Receiver {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Client {
    Class[] participants() default {};

    String comment() default "";
  }
}
