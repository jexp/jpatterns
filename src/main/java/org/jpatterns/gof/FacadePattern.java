package org.jpatterns.gof;

import org.jpatterns.core.DesignPattern;
import org.jpatterns.core.Type;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <b>Intent [GoF, pg 185]:</b> Provide a unified interface to a set of
 * interfaces in a subsystem. Facade defines a higher-level interface that makes
 * the subsystem easier to use.
 * <p>
 * <img alt="Facade Structure" src="http://www.jpatterns.org/uml/gof/FacadeStructure.gif">
 *
 * @author Heinz Kabutz
 * @since 2010-07-28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@DesignPattern(type = Type.STRUCTURAL,
        related = {AbstractFactoryPattern.class, MediatorPattern.class,
                SingletonPattern.class})
public @interface FacadePattern {
    Class[] participants() default {};

    String comment() default "";
}
