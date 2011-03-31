package org.jpatterns.gof.structural;

import org.jpatterns.core.*;
import org.jpatterns.gof.behavioral.MediatorPattern;
import org.jpatterns.gof.creational.*;

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
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@DesignPattern(type = Type.STRUCTURAL,
    level = Level.Component,
    purpose = "Provide a unified interface to a set of interfaces in a " +
        "subsystem. Facade defines a higher-level interface that makes the " +
        "subsystem easier to use.",
    related = {AbstractFactoryPattern.class, MediatorPattern.class,
        SingletonPattern.class})
public @interface FacadePattern {
  Class[] participants() default {};

  String comment() default "";
}
