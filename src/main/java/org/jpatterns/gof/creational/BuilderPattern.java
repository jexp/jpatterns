package org.jpatterns.gof.creational;

import org.jpatterns.core.*;
import org.jpatterns.gof.structural.CompositePattern;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 97]:</b> Separate the construction of a complex object
 * from its representation so that the same construction process can create
 * different representations.
 *
 * @author Heinz Kabutz
 * @since 2010-08-09
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@DesignPattern(type = Type.CREATIONAL,
    level = Level.Component,
    purpose = "Separate the construction of a complex object from its " +
        "representation so that the same construction process can create " +
        "different representations",
    related = {AbstractFactoryPattern.class, CompositePattern.class})
public @interface BuilderPattern {
  Class[] participants() default {};

  String comment() default "";

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Director {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Builder {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface ConcreteBuilder {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Product {
    Class[] participants() default {};

    String comment() default "";
  }

}
