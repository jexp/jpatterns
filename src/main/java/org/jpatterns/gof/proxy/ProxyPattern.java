package org.jpatterns.gof.proxy;

import org.jpatterns.*;

import java.lang.annotation.*;

/**
 * @author Heinz Kabutz
 * @since 2010-07-28
 */
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