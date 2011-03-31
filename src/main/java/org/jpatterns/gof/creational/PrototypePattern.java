package org.jpatterns.gof.creational;

import org.jpatterns.core.*;
import org.jpatterns.gof.structural.*;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 117]:</b> Specify the kinds of objects to create using a
 * prototypical instance, and create new objects by copying this prototype.
 *
 * @author Heinz Kabutz
 * @since 2010-08-09
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@DesignPattern(type = Type.CREATIONAL,
    level = Level.SingleClass,
    purpose = "Specify the kinds of objects to create using a prototypical " +
        "instance, and create new objects by copying this prototype.",
    related = {AbstractFactoryPattern.class, CompositePattern.class,
        DecoratorPattern.class})
public @interface PrototypePattern {
  Class[] participants() default {};

  String comment() default "";

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Prototype {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface ConcretePrototype {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.METHOD)
  @Documented
  public @interface Operation {
    Class[] participants() default {};

    String comment() default "";
  }
}
