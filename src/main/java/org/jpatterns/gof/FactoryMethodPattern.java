package org.jpatterns.gof;

import org.jpatterns.core.*;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 107]:</b> Define an interface for creating an object, but
 * let subclasses decide which class to instantiate. Factory Method lets a class
 * defer instantiation to subclasses.
 * <p/>
 * This pattern refers to the GoF factory method, which differs greatly from the
 * static factory method commonly found in the refactoring literature.
 * <p/>
 * <img src="http://www.jpatterns.org/uml/gof/FactoryMethodStructure.gif"/>
 *
 * @author Heinz Kabutz
 * @since 2010-08-09
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(type = Type.CREATIONAL,
    related = {AbstractFactoryPattern.class, TemplateMethodPattern.class,
        PrototypePattern.class})
public @interface FactoryMethodPattern {
  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Creator {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Product {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface ConcreteCreator {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface ConcreteProduct {
  }
}
