package org.jpatterns;

import java.lang.annotation.*;

/**
 * @author Michael Hunger
 * @since 14.07.2010
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.ANNOTATION_TYPE)
@Documented
@Inherited
public @interface DesignPattern {
  Source source() default Source.GoF;

  Type type();
}
