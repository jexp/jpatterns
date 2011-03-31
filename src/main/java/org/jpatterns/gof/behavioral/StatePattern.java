package org.jpatterns.gof.behavioral;

import org.jpatterns.core.*;
import org.jpatterns.gof.creational.SingletonPattern;
import org.jpatterns.gof.structural.FlyweightPattern;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 305]:</b> Allow an object to alter its behavior when its
 * internal state changes. The object will appear to change its class.
 * <p/>
 * <img src="http://www.jpatterns.org/uml/gof/StateStructure.gif"/>
 *
 * @author Heinz Kabutz
 * @since 2010-08-09
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@DesignPattern(type = Type.BEHAVIORAL,
    level = Level.SingleClass,
    purpose = "Allow an object to alter its behavior when its internal state " +
        "changes. The object will appear to change its class.",
    alsoKnown = {"Objects for States"},
    related = {FlyweightPattern.class, SingletonPattern.class})
public @interface StatePattern {
  Class[] participants() default {};

  String comment() default "";

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Context {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface State {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface ConcreteState {
    Class[] participants() default {};

    String comment() default "";
  }
}
