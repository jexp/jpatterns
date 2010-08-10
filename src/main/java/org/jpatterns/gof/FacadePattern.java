package org.jpatterns.gof;

import org.jpatterns.core.*;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 185]:</b> Provide a unified interface to a set of
 * interfaces in a subsystem. Facade defines a higher-level interface that makes
 * the subsystem easier to use.
 * <p/>
 * <img src="http://www.jpatterns.org/uml/gof/FacadeStructure.gif"/>
 *
 * @author Heinz Kabutz
 * @since 2010-07-28
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(type = Type.STRUCTURAL,
    related = {AbstractFactoryPattern.class, MediatorPattern.class,
        SingletonPattern.class})
public @interface FacadePattern {
}
