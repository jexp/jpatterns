package org.jpatterns.command;

import org.jpatterns.*;

import java.lang.annotation.*;

/**
 * @author Michael Hunger
 * @since 14.07.2010
 */
@Retention(value = RetentionPolicy.CLASS)
@Target(value = ElementType.TYPE)
@DesignPattern(source = Source.GoF, type = Type.BEHAVIORAL)
public @interface _Command {
  Class[] client() default {};

  Class[] invoker() default {};

  Class[] receiver() default {};

  String comment() default "";

  boolean undoable() default false;
}
