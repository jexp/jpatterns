package org.jpatterns.gof.adapter;

import org.jpatterns.*;

import java.lang.annotation.*;

/**
 * @author Heinz Kabutz
 * @since 2010-07-28
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(type = Type.STRUCTURAL)
public @interface AdapterPattern {

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Adapter {
    Variation value() default Variation.OBJECT;
  }

  /**
   * We would hardly ever use this annotation as the adaptee is
   * usually not aware that he is being adapted.
   */
  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Adaptee {
  }

  public enum Variation {
    OBJECT,
    CLASS,
    /**
     * See http://www.javaspecialists.eu/archive/Issue108.html
     */
    DYNAMIC
  }
}