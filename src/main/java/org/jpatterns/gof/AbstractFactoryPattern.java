package org.jpatterns.gof;

import org.jpatterns.*;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 87]:</b> Provide an interface for creating families of
 * related or dependent objects without specifying their concrete classes.
 * <p/>
 * <img src="http://www.jpatterns.org/uml/gof/AbstractFactoryStructure.gif"/>
 * <p/>
 * <img src="http://www.jpatterns.org/uml/gof/AbstractFactoryUserViewStructure.gif"/>
 *
 * @author Heinz Kabutz
 * @since 2010-08-09
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(type = Type.CREATIONAL,
    related = {FactoryMethodPattern.class, PrototypePattern.class,
        SingletonPattern.class})
public @interface AbstractFactoryPattern {

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface AbstractProduct {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface ConcreteProduct {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.METHOD)
  @Documented
  public @interface FactoryMethod {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface AbstractFactory {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface ConcreteFactory {
  }

}
