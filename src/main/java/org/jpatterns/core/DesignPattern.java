package org.jpatterns.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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

    String[] urls() default {};

    Refactoring[] refactorings() default {};

    Class[] related() default {};
}
