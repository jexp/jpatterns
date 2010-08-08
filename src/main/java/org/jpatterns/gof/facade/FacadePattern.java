package org.jpatterns.gof.facade;

import org.jpatterns.*;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(type = Type.STRUCTURAL)
public @interface FacadePattern {

  Class[] participants() default {};
  String comment() default "";
}