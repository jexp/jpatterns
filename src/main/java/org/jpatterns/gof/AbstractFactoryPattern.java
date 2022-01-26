package org.jpatterns.gof;

import org.jpatterns.core.DesignPattern;
import org.jpatterns.core.Type;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <b>Intent [GoF, pg 87]:</b> Provide an interface for creating families of
 * related or dependent objects without specifying their concrete classes.
 * <p>
 * <img alt="Abstract Factory Structure" src="http://www.jpatterns.org/uml/gof/AbstractFactoryStructure.gif">
 * <p>
 * <img alt="Abstract Factory User View Structure" src="http://www.jpatterns.org/uml/gof/AbstractFactoryUserViewStructure.gif">
 *
 * @author Heinz Kabutz, Michael Hunger
 * @since 2010-08-09
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@DesignPattern(type = Type.CREATIONAL,
        related = {FactoryMethodPattern.class, PrototypePattern.class,
                SingletonPattern.class})
public @interface AbstractFactoryPattern {
    Class[] participants() default {};

    String comment() default "";

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Documented
    public @interface AbstractProduct {
        Class[] participants() default {};

        String comment() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Documented
    public @interface ConcreteProduct {
        Class[] participants() default {};

        String comment() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @Documented
    public @interface FactoryMethod {
        Class[] participants() default {};

        String comment() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Documented
    public @interface AbstractFactory {
        Class[] participants() default {};

        String comment() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Documented
    public @interface ConcreteFactory {
        Class[] participants() default {};

        String comment() default "";
    }
} 
