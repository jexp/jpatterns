package org.jpatterns.gof;

import org.jpatterns.core.*;

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
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(type = Type.CREATIONAL,
    related = {AbstractFactoryPattern.class, BuilderPattern.class,
        PrototypePattern.class})
public @interface SingletonPattern {
  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Singleton {
    Variation variation() default Variation.LAZY;
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.METHOD)
  @Documented
  public @interface SingletonMethod {
  }

  public enum Variation {
    LAZY, EAGER
  }
}
