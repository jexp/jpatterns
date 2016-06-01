package org.jpatterns.core;

import java.lang.annotation.*;

/**
 * @author Michael Hunger
 * @since 2010-07-14
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@Documented
@Inherited
public @interface DesignPattern {
  Source source() default Source.GoF;
  Type type();
  Level level();
  String[] alsoKnown() default {};
  Class[] related() default {};

  String purpose() default "";
  String introduction() default "";
  String[] applicability() default {};
  String implementation() default "";
  String[] benefitsAndDrawbacks() default {};

  String[] urls() default {};
  Refactoring[] refactorings() default {};
}
