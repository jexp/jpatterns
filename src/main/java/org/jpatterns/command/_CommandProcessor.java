package org.jpatterns.command;

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
public @interface _CommandProcessor {
}
