package org.jpatterns.gof;

import org.jpatterns.core.*;

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
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(type = Type.BEHAVIORAL,
    related = {FlyweightPattern.class, SingletonPattern.class})
public @interface StatePattern {
  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Context {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface State {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface ConcreteState {
  }
}
