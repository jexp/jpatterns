package org.jpatterns.gof;

import org.jpatterns.core.DesignPattern;
import org.jpatterns.core.Type;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <b>Intent [GoF, pg 315]:</b> Define a family of algorithms, encapsulate each
 * one, and make them interchangeable. Strategy lets the algorithm vary
 * independently from clients that use it.
 * <p>
 * <img alt="Strategy Structure" src="http://www.jpatterns.org/uml/gof/StrategyStructure.gif">
 *
 * @author Heinz Kabutz
 * @since 2010-07-28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@DesignPattern(type = Type.BEHAVIORAL,
        related = {FlyweightPattern.class})
public @interface StrategyPattern {
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
    public @interface Strategy {
        Class[] participants() default {};

        String comment() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @Documented
    public @interface StrategyField {
        Class[] participants() default {};

        String comment() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Documented
    public @interface ConcreteStrategy {
        Class[] participants() default {};

        String comment() default "";
    }
}
