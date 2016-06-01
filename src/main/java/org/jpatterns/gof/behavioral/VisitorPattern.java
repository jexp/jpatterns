package org.jpatterns.gof.behavioral;

import org.jpatterns.core.*;
import org.jpatterns.gof.structural.CompositePattern;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 331]:</b> Represent an operation to be performed on the
 * elements of an object structure. Visitor lets you define a new operation
 * without changing the classes of the elements on which it operates.
 * <p/>
 * <img src="http://www.jpatterns.org/uml/gof/VisitorStructure.gif"/>
 *
 * @author Heinz Kabutz
 * @since 2010-08-09
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@DesignPattern(type = Type.BEHAVIORAL,
    level = Level.Component,
    purpose = "Represent an operation to be performed on the elements of an " +
        "object structure. Visitor lets you define a new operation without " +
        "changing the classes of the elements on which it operates.",
    related = {CompositePattern.class, InterpreterPattern.class})
public @interface VisitorPattern {
  Class[] participants() default {};

  String comment() default "";

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Visitor {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface ConcreteVisitor {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Element {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface ConcreteElement {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface ObjectStructure {
    Class[] participants() default {};

    String comment() default "";
  }
}
