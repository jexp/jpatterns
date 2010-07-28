package org.jpatterns.gof.proxy;

import org.jpatterns.*;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.FIELD,
    ElementType.LOCAL_VARIABLE})
@Documented
@DesignPattern(type = Type.STRUCTURAL)
public @interface ProxyPattern {
  ProxyVariation variation() default ProxyVariation.STATIC_MANUAL;

  // need different types: virtual, remote, protection, etc.

  ProxyRole role() default ProxyRole.SUBJECT;

  Class[] participants() default {};

  String comment() default "";
}