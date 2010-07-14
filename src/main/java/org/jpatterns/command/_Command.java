package org.jpatterns.command;

import org.jpatterns.DesignPattern;
import org.jpatterns.Source;
import org.jpatterns.Type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Michael Hunger
 * @since 14.07.2010
 */
@Retention(value = RetentionPolicy.CLASS)
@Target(value = ElementType.TYPE)
@DesignPattern(source = Source.GOF, type = Type.Behavioural)
public @interface _Command {
    Class[] client()  default {};

    Class[] invoker() default {};

    Class[] receiver() default {};

    String comment() default "";

    boolean undoable() default false;
}
