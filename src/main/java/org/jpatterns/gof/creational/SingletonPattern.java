package org.jpatterns.gof.creational;

import org.jpatterns.core.*;
import org.jpatterns.gof.creational.*;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 127]:</b> Ensure a class only has one instance, and
 * provide a global point of access to it.
 * <p/>
 * <img src="http://www.jpatterns.org/uml/gof/SingletonStructure.gif"/>
 *
 * @author Alex Gout
 * @since 2010-08-08
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@DesignPattern(type = Type.CREATIONAL,
    level = Level.SingleClass,
    purpose = "Ensure a class only has one instance, and provide a global " +
        "point of access to it.",
    related = {AbstractFactoryPattern.class, BuilderPattern.class,
        PrototypePattern.class})
public @interface SingletonPattern {
  Class[] participants() default {};

  String comment() default "";

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Singleton {
    Class[] participants() default {};

    String comment() default "";

    Variation variation() default Variation.LAZY;
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.METHOD)
  @Documented
  public @interface SingletonMethod {
    Class[] participants() default {};

    String comment() default "";
  }

  public enum Variation {
    LAZY, EAGER
  }
}
