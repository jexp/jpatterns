package org.jpatterns.gof;

import org.jpatterns.core.*;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 163]:</b> Compose objects into tree structures to
 * represent whole-part hierarchies. Composite lets clients treat individual
 * objects and compositions of objects uniformly.
 * <p/>
 * <img src="http://www.jpatterns.org/uml/gof/CompositeStructure.gif"/>
 *
 * @author Heinz Kabutz
 * @since 2010-07-28
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(type = Type.STRUCTURAL,
    related = {ChainOfResponsibilityPattern.class, DecoratorPattern.class,
        FlyweightPattern.class, IteratorPattern.class, VisitorPattern.class})
public @interface CompositePattern {
  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Component {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Leaf {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Composite {
  }
}
