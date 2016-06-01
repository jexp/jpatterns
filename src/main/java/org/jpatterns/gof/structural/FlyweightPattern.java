package org.jpatterns.gof.structural;

import org.jpatterns.core.*;
import org.jpatterns.gof.behavioral.*;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 195]:</b> Use sharing to support large numbers of
 * fine-grained objects efficiently.
 * <p/>
 * <img src="http://www.jpatterns.org/uml/gof/FlyweightStructure.gif"/>
 *
 * @author Heinz Kabutz
 * @since 2010-07-28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@DesignPattern(type = Type.STRUCTURAL,
    level = Level.Component,
    purpose = "Use sharing to support large numbers of fine-grained objects " +
        "efficiently.",
    related = {CompositePattern.class, StatePattern.class,
        StrategyPattern.class})
public @interface FlyweightPattern {
  Class[] participants() default {};

  String comment() default "";

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface FlyweightFactory {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Flyweight {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface UnsharedConcreteFlyweight {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface ConcreteFlyweight {
    Class[] participants() default {};

    String comment() default "";
  }
}
