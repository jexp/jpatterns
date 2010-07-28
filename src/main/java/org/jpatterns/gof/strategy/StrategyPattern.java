package org.jpatterns.gof.strategy;

import org.jpatterns.*;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
@Documented
@DesignPattern(type = Type.BEHAVIORAL)
public @interface StrategyPattern {
  public abstract StrategyRole role() default
      StrategyRole.STRATEGY;

  public abstract Class[] participants() default {};

  public abstract String comment() default "";
}