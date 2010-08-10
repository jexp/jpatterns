package org.jpatterns.gof;

import org.jpatterns.core.*;

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
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(type = Type.BEHAVIORAL,
    related = {FacadePattern.class, ObserverPattern.class})
public @interface ObserverPattern {
  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Observer {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Subject {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface ConcreteObserver {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface ConcreteSubject {
  }
}
