package org.jpatterns.gof;

import org.jpatterns.*;

import java.lang.annotation.*;

/**
 * @author Alex Gout
 * @since 2010-08-08
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(type = Type.CREATIONAL)
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
