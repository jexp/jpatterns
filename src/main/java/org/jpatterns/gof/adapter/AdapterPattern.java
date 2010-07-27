package org.jpatterns.gof.adapter;

import org.jpatterns.*;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(type = Type.STRUCTURAL)
public @interface AdapterPattern {
  AdapterVariation variation() default AdapterVariation.OBJECT;

  AdapterRole role() default AdapterRole.ADAPTER;

  Class[] participants() default {};

  String comment() default "";  
}