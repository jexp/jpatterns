package org.jpatterns.gof.strategy;

import org.jpatterns.*;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
@Documented
@DesignPattern(type = Type.BEHAVIORAL)
public @interface StrategyPattern {
  StrategyRole role() default StrategyRole.STRATEGY;

  Class[] participants() default {};

  String comment() default "";
}