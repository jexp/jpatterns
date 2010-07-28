package org.jpatterns.gof.templatemethod;

import org.jpatterns.*;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Documented
@DesignPattern(type = Type.BEHAVIORAL)
public @interface TemplateMethodPattern {
  public abstract TemplateMethodRole role() default
      TemplateMethodRole.ABSTRACT_CLASS;

  public abstract Class[] participants() default {};

  public abstract String comment() default "";
}