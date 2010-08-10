package org.jpatterns.gof;

import org.jpatterns.core.*;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 151]:</b> Decouple an abstraction from its implementation
 * so that the two can vary independently.
 * <p/>
 * <img src="http://www.jpatterns.org/uml/gof/BridgeStructure.gif"/>
 *
 * @author Heinz Kabutz
 * @since 2010-07-28
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(type = Type.STRUCTURAL,
    related = {AbstractFactoryPattern.class, AdapterPattern.class})
public @interface BridgePattern {
}
