package org.jpatterns.gof;

import org.jpatterns.core.DesignPattern;
import org.jpatterns.core.Type;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <b>Intent [GoF, pg 243]:</b> Given a language, define a represention for its
 * grammar along with an interpreter that uses the representation to interpret
 * sentences in the language.
 *
 * @author Heinz Kabutz
 * @since 2010-08-09
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@DesignPattern(type = Type.BEHAVIORAL,
        related = {CompositePattern.class, FlyweightPattern.class,
                IteratorPattern.class, VisitorPattern.class})
public @interface InterpreterPattern {
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
    public @interface AbstractExpression {
        Class[] participants() default {};

        String comment() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Documented
    public @interface TerminalExpression {
        Class[] participants() default {};

        String comment() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Documented
    public @interface NonterminalExpression {
        Class[] participants() default {};

        String comment() default "";
    }
}
