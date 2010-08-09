package org.jpatterns;

import java.lang.annotation.*;

/**
 * @author Michael Hunger
 * @since 2010-07-14
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {
    ElementType.TYPE,
    ElementType.CONSTRUCTOR,
    ElementType.FIELD,
    ElementType.LOCAL_VARIABLE,
    ElementType.METHOD,
    ElementType.PARAMETER
    })
@Documented
@Inherited
public @interface PatternDetails {
  Class[] participants() default {};
  String comment() default "";
}