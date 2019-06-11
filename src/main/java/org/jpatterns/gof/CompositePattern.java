package org.jpatterns.gof;

import org.jpatterns.core.*;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 163]:</b> Compose objects into tree structures to
 * represent whole-part hierarchies. Composite lets clients treat individual
 * objects and compositions of objects uniformly.
 *
 * <img alt="Composite Structure" src="http://www.jpatterns.org/uml/gof/CompositeStructure.gif">
 *
 * @author Heinz Kabutz
 * @since 2010-07-28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@DesignPattern(type = Type.STRUCTURAL,
    related = {ChainOfResponsibilityPattern.class, DecoratorPattern.class,
        FlyweightPattern.class, IteratorPattern.class, VisitorPattern.class})
public @interface CompositePattern {
  Class[] participants() default {};

  String comment() default "";

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Component {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Leaf {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Composite {
    Class[] participants() default {};

    String comment() default "";
  }
}
