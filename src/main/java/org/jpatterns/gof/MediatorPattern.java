package org.jpatterns.gof;

import org.jpatterns.core.*;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 273]:</b> Define an object that encapsulates how a set of
 * objects interact. Mediator promotes loose coupling by keeping objects from
 * referring to each other explicitly, and it lets you vary their interaction
 * independently.
 * <p/>
 * <img src="http://www.jpatterns.org/uml/gof/MediatorStructure.gif"/>
 *
 * @author Heinz Kabutz
 * @since 2010-08-09
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(type = Type.BEHAVIORAL,
    related = {FacadePattern.class, ObserverPattern.class})
public @interface MediatorPattern {
  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Mediator {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Colleague {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface ConcreteMediator {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface ConcreteColleague {
  }
}
