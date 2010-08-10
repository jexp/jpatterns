package org.jpatterns.gof;

import org.jpatterns.core.*;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 117]:</b> Specify the kinds of objects to create using a
 * prototypical instance, and create new objects by copying this prototype.
 *
 * @author Heinz Kabutz
 * @since 2010-08-09
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(type = Type.CREATIONAL,
    related = {AbstractFactoryPattern.class, CompositePattern.class,
        DecoratorPattern.class})
public @interface PrototypePattern {
}
