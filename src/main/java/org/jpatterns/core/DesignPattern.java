package org.jpatterns.core;

import java.lang.annotation.*;

/**
 * @author Michael Hunger
 * @since 2010-07-14
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.ANNOTATION_TYPE)
@Documented
@Inherited
public @interface DesignPattern {
  Source source() default Source.GoF;

  Type type();

  String[] urls() default {};

  Refactoring[] refactorings() default {};

  Class[] related() default {};
}
