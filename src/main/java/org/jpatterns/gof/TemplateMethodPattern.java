package org.jpatterns.gof;

import org.jpatterns.core.*;

import java.lang.annotation.*;

/**
 * @author Heinz Kabutz
 * @since 2010-07-28
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Documented
@DesignPattern(type = Type.BEHAVIORAL,
    related = {FactoryMethodPattern.class, StrategyPattern.class})
public @interface TemplateMethodPattern {
  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface AbstractClass {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface ConcreteClass {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.METHOD)
  @Documented
  public @interface TemplateMethod {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.METHOD)
  @Documented
  public @interface PrimitiveMethod {
  }
}
