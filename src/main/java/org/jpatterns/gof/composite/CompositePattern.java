package org.jpatterns.gof.composite;

import org.jpatterns.*;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(type = Type.STRUCTURAL)
public @interface CompositePattern {
  public abstract CompositeRole role() default CompositeRole.COMPONENT;

  public abstract Class[] participants() default {};

  public abstract String comment() default "";
}