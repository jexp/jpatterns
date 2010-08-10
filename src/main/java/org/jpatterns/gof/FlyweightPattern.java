package org.jpatterns.gof;

import org.jpatterns.core.*;

import java.lang.annotation.*;

/**
 * @author Heinz Kabutz
 * @since 2010-07-28
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(type = Type.STRUCTURAL,
    related = {CompositePattern.class, StatePattern.class,
        StrategyPattern.class})
public @interface FlyweightPattern {
}
