package org.jpatterns.gof.behavioral;

import org.jpatterns.core.*;
import org.jpatterns.gof.structural.FlyweightPattern;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 315]:</b> Define a family of algorithms, encapsulate each
 * one, and make them interchangeable. Strategy lets the algorithm vary
 * independently from clients that use it.
 * <p/>
 * <img src="http://www.jpatterns.org/uml/gof/StrategyStructure.gif"/>
 *
 * @author Heinz Kabutz
 * @since 2010-07-28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@DesignPattern(type = Type.BEHAVIORAL,
    level = Level.Component,
    purpose = "Define a family of algorithms, encapsulate each one, and make " +
        "them interchangeable. Strategy lets the algorithm vary independently " +
        "from clients that use it",
    alsoKnown = {"Policy"},
    related = {FlyweightPattern.class})
public @interface StrategyPattern {
  Class[] participants() default {};

  String comment() default "";

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Context {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Strategy {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.FIELD)
  @Documented
  public @interface StrategyField {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface ConcreteStrategy {
    Class[] participants() default {};

    String comment() default "";
  }
}
