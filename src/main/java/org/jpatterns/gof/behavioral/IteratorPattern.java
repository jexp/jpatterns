package org.jpatterns.gof.behavioral;

import org.jpatterns.core.*;
import org.jpatterns.gof.creational.FactoryMethodPattern;
import org.jpatterns.gof.structural.CompositePattern;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 257]:</b> Provide a way to access the elements of an
 * aggregate object sequentially without exposing its underlying representation.
 * <p/>
 * <img src="http://www.jpatterns.org/uml/gof/IteratorStructure.gif"/>
 *
 * @author Heinz Kabutz
 * @since 2010-08-09
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@DesignPattern(type = Type.BEHAVIORAL,
    level = Level.Component,
    purpose = "Provide a way to access the elements of an aggregate object " +
        "sequentially without exposing its underlying representation.",
    alsoKnown = {"Cursor"},
    related = {CompositePattern.class, FactoryMethodPattern.class,
        MementoPattern.class})
public @interface IteratorPattern {
  Class[] participants() default {};

  String comment() default "";

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Aggregate {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Iterator {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface ConcreteAggregate {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface ConcreteIterator {
    Class[] participants() default {};

    String comment() default "";
  }
}
