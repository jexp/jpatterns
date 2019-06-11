package org.jpatterns.gof;

import org.jpatterns.core.*;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 223]:</b> Avoid coupling the sender of a request to its
 * receiver by giving more than one object a chance to handle the request. Chain
 * the receiving objects and pass the request along the chain until an object
 * handles it.
 *
 * <img src="http://www.jpatterns.org/uml/gof/ChainOfResponsibilityStructure.gif"/>
 *
 * @author Heinz Kabutz
 * @since 2010-07-28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@DesignPattern(type = Type.BEHAVIORAL,
    related = {CompositePattern.class})
public @interface ChainOfResponsibilityPattern {
  Class[] participants() default {};

  String comment() default "";

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Handler {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface ConcreteHandler {
    Class[] participants() default {};

    String comment() default "";

    boolean defaultHandler() default false;
  }
}
