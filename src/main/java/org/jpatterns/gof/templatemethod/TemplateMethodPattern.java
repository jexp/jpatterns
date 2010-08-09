package org.jpatterns.gof.templatemethod;

import org.jpatterns.*;

import java.lang.annotation.*;

/**
 * @author Heinz Kabutz
 * @since 2010-07-28
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Documented
@DesignPattern(type = Type.BEHAVIORAL)
public @interface TemplateMethodPattern {
  TemplateMethodRole role() default
      TemplateMethodRole.ABSTRACT_CLASS;

  Class[] participants() default {};

  String comment() default "";
}