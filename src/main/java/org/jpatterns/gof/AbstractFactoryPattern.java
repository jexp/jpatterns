package org.jpatterns.gof;

import org.jpatterns.DesignPattern;
import org.jpatterns.Type;

import java.lang.annotation.*;

/**
 * @author Heinz Kabutz
 * @since 2010-08-09
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(type = Type.CREATIONAL)
public @interface AbstractFactoryPattern {

    @Retention(value = RetentionPolicy.RUNTIME)
    @Target(value = ElementType.TYPE)
    @Documented
    public @interface AbstractProduct {
    }

    @Retention(value = RetentionPolicy.RUNTIME)
    @Target(value = ElementType.TYPE)
    @Documented
    public @interface ConcreteProduct {
    }

    @Retention(value = RetentionPolicy.RUNTIME)
    @Target(value = ElementType.METHOD)
    @Documented
    public @interface FactoryMethod {
    }

    @Retention(value = RetentionPolicy.RUNTIME)
    @Target(value = ElementType.TYPE)
    @Documented
    public @interface AbstractFactory {
    }

    @Retention(value = RetentionPolicy.RUNTIME)
    @Target(value = ElementType.TYPE)
    @Documented
    public @interface ConcreteFactory {
    }

}
