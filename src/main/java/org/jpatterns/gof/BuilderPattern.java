package org.jpatterns.gof;

import org.jpatterns.core.*;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 97]:</b> Separate the construction of a complex object
 * from its representation so that the same construction process can create
 * different representations.
 *
 * @author Heinz Kabutz
 * @since 2010-08-09
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(type = Type.CREATIONAL,
    related = {AbstractFactoryPattern.class, CompositePattern.class})
public @interface BuilderPattern {
  Class[] participants() default {};

  String comment() default "";

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Director {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Builder {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface ConcreteBuilder {
    Class[] participants() default {};

    String comment() default "";
  }

}
