package org.jpatterns.gof;

import org.jpatterns.core.*;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 243]:</b> Given a language, define a represention for its
 * grammar along with an interpreter that uses the representation to interpret
 * sentences in the language.
 *
 * @author Heinz Kabutz
 * @since 2010-08-09
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(type = Type.BEHAVIORAL,
    related = {CompositePattern.class, FlyweightPattern.class,
        IteratorPattern.class, VisitorPattern.class})
public @interface InterpreterPattern {
  Class[] participants() default {};

  String comment() default "";

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Context {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface AbstractExpression {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface TerminalExpression {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface NonterminalExpression {
    Class[] participants() default {};

    String comment() default "";
  }
}
