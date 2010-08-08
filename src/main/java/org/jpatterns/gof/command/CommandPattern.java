package org.jpatterns.gof.command;

import org.jpatterns.DesignPattern;
import org.jpatterns.Refactoring;
import org.jpatterns.Source;
import org.jpatterns.Type;
import org.jpatterns.gof.composite.CompositePattern;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Michael Hunger
 * @since 08.08.2010
 */
@Retention(value = RetentionPolicy.CLASS)
@Target(value = ElementType.TYPE)
@DesignPattern(source = Source.GoF,
        type = Type.BEHAVIORAL,
        urls={"http://en.wikipedia.org/wiki/Command_pattern",
              "http://home.earthlink.net/~huston2/dp/command.html"  },
        refactorings = {Refactoring.ExtractParameterObject, Refactoring.ExtractMethodObject},
        related = {CompositePattern.class})

public @interface CommandPattern {
    @Retention(value = RetentionPolicy.CLASS)
    @Target(value = ElementType.TYPE)
    public @interface Command {
        boolean undoable() default false;
        String comment() default "";
        Class receiver() default void.class;
    }
    @Retention(value = RetentionPolicy.CLASS)
    @Target(value = ElementType.TYPE)
    public @interface ConcreteCommand {
        String comment() default "";
    }
    @Retention(value = RetentionPolicy.CLASS)
    @Target(value = ElementType.TYPE)
    public @interface Invoker {
        String comment() default "";
        Class command();
    }
    @Retention(value = RetentionPolicy.CLASS)
    @Target(value = ElementType.TYPE)
    public @interface Receiver {
        String comment() default "";
        Class command();
    }
}
