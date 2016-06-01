package org.jpatterns.gof.structural;

import org.jpatterns.core.*;
import org.jpatterns.gof.creational.AbstractFactoryPattern;
import org.jpatterns.gof.structural.AdapterPattern;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 151]:</b> Decouple an abstraction from its implementation
 * so that the two can vary independently.
 * <p/>
 * <img src="http://www.jpatterns.org/uml/gof/BridgeStructure.gif"/>
 *
 * @author Heinz Kabutz
 * @since 2010-07-28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@DesignPattern(type = Type.STRUCTURAL,
    level = Level.Component,
    purpose = "Decouple an abstraction from its implementation so that the two " +
        "can vary independently.",
    alsoKnown = {"Handle/Body"},
    related = {AbstractFactoryPattern.class, AdapterPattern.class})
public @interface BridgePattern {
  Class[] participants() default {};

  String comment() default "";

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Abstraction {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface RefinedAbstraction {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Implementor {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface ConcreteImplementor {
    Class[] participants() default {};

    String comment() default "";
  }
}
