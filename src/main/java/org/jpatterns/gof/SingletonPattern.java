package org.jpatterns.gof;

import org.jpatterns.core.*;

import java.lang.annotation.*;

/**
 * @author Alex Gout
 * @since 2010-08-08
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(type = Type.CREATIONAL,
    related = {AbstractFactoryPattern.class, BuilderPattern.class,
        PrototypePattern.class})
public @interface SingletonPattern {
  Variation variation() default Variation.LAZY;

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.METHOD)
  @Documented
  public @interface SingletonMethod {
  }

  public enum Variation {
    LAZY, EAGER
  }
}
