package org.jpatterns.gof.behavioral;

import org.jpatterns.core.*;
import org.jpatterns.gof.creational.SingletonPattern;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 293]:</b> Define a one-to-many dependency between objects
 * so that when one object changes state, all its dependents are notified and
 * updated automatically.
 * <p/>
 * <img src="http://www.jpatterns.org/uml/gof/ObserverStructure.gif"/>
 *
 * @author Heinz Kabutz
 * @since 2010-08-09
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@DesignPattern(type = Type.BEHAVIORAL,
    level = Level.Component,
    purpose = "Define a one-to-many dependency between objects so that when one " +
        "object changes state, all its dependents are notified and updated " +
        "automatically.",
    alsoKnown = {"Publisher-Subscriber"},
    related = {MediatorPattern.class, SingletonPattern.class})
public @interface ObserverPattern {
  Class[] participants() default {};

  String comment() default "";

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Observer {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Subject {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface ConcreteObserver {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface ConcreteSubject {
    Class[] participants() default {};

    String comment() default "";
  }
}
