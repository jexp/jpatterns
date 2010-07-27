package org.jpatterns.gof.proxy;

import org.jpatterns.*;
import org.jpatterns.gof.adapter.*;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.FIELD,
    ElementType.LOCAL_VARIABLE})
@Documented
@DesignPattern(type = Type.STRUCTURAL)
public @interface ProxyPattern {
  public abstract ProxyVariation variation() default ProxyVariation.STATIC_MANUAL;

  public abstract ProxyRole role() default ProxyRole.SUBJECT;

  public abstract Class[] participants() default {};

  public abstract String comment() default "";
}