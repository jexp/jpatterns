package org.jpatterns.gof.behavioral;

import org.jpatterns.core.*;
import org.jpatterns.gof.creational.FactoryMethodPattern;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 325]:</b> Define the skeleton of an algorithm in an
 * operation, deferring some steps to subclasses. Template Method lets
 * subclasses redefine certain steps of an algorithm without changing the
 * algorithm's structure.
 * <p/>
 * <img src="http://www.jpatterns.org/uml/gof/TemplateMethodStructure.gif"/>
 *
 * @author Heinz Kabutz
 * @since 2010-07-28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@DesignPattern(type = Type.BEHAVIORAL,
    level = Level.SingleClass,
    purpose = "Define the skeleton of an algorithm in an operation, deferring " +
        "some steps to subclasses. Template Method lets subclasses redefine " +
        "certain steps of an algorithm without changing the algorithm's structure.",
    related = {FactoryMethodPattern.class, StrategyPattern.class})
public @interface TemplateMethodPattern {
  Class[] participants() default {};

  String comment() default "";

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface AbstractClass {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface ConcreteClass {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.METHOD)
  @Documented
  public @interface TemplateMethod {
    Class[] participants() default {};

    String comment() default "";
  }


  /**
   * @deprecated Misnamed, please use @PrimitiveOperation instead.
   */
  @Deprecated
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.METHOD)
  @Documented
  public @interface PrimitiveMethod {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.METHOD)
  @Documented
  public @interface PrimitiveOperation {
    Class[] participants() default {};

    String comment() default "";
  }
}
