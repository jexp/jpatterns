package org.jpatterns.gof.behavioral;

import org.jpatterns.core.*;
import org.jpatterns.gof.structural.FacadePattern;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 283]:</b> Without violating encapsulation, capture and
 * externalize an object's internal state so that the object can be restored to
 * this state later.
 * <p/>
 * <img src="http://www.jpatterns.org/uml/gof/MementoStructure.gif"/>
 *
 * @author Heinz Kabutz
 * @since 2010-08-09
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@DesignPattern(type = Type.BEHAVIORAL,
    level = Level.SingleClass,
    purpose = "Without violating encapsulation, capture and externalize an " +
        "object's internal state so that the object can be restored to this " +
        "state later.",
    alsoKnown = {"Token", "Snapshot"},
    related = {FacadePattern.class, ObserverPattern.class})
public @interface MementoPattern {
  Class[] participants() default {};

  String comment() default "";

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Originator {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Memento {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface MementoImpl {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Caretaker {
    Class[] participants() default {};

    String comment() default "";
  }
}
