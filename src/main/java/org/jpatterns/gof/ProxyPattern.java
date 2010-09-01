package org.jpatterns.gof;

import org.jpatterns.core.*;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 207]:</b> Provide a surrogate or placeholder for another
 * object to control access to it.
 * <p/>
 * <img src="http://www.jpatterns.org/uml/gof/ProxyStructure.gif"/>
 *
 * @author Heinz Kabutz
 * @since 2010-07-28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD,
    ElementType.LOCAL_VARIABLE})
@Documented
@DesignPattern(type = Type.STRUCTURAL,
    related = {AdapterPattern.class, DecoratorPattern.class})
public @interface ProxyPattern {
  Class[] participants() default {};

  String comment() default "";

  Variation variation() default Variation.STATIC_MANUAL;

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Subject {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface RealSubject {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Proxy {
    Class[] participants() default {};

    String comment() default "";

    Variation variation() default Variation.STATIC_MANUAL;

    Type type() default Type.UNDEFINED;
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.TYPE, ElementType.FIELD,
      ElementType.LOCAL_VARIABLE})
  @Documented
  public @interface Client {
    Class[] participants() default {};

    String comment() default "";
  }

  public static enum Variation {
    STATIC_MANUAL, STATIC_GENERATED, DYNAMIC
  }

  public static enum Type {
    UNDEFINED, VIRTUAL, REMOTE, PROTECTION
  }
}
