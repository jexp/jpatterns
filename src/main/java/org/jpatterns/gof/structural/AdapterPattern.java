package org.jpatterns.gof.structural;

import org.jpatterns.core.*;

import java.lang.annotation.*;

/**
 * <b>Intent [GoF, pg 139]:</b> Convert the interface of a class into another
 * interface clients expect. Adapter lets classes work together that couldn't
 * otherwise because of incompatible interfaces.
 * <p/>
 * The structure for an object adapter is:
 * <p/>
 * <img src="http://www.jpatterns.org/uml/gof/ObjectAdapterStructure.gif"/>
 * <p/>
 * The structure for a class adapter is:
 * <p/>
 * <img src="http://www.jpatterns.org/uml/gof/ClassAdapterStructure.gif"/>
 *
 * @author Heinz Kabutz
 * @since 2010-07-28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@DesignPattern(type = Type.STRUCTURAL,
    level = Level.Component,
    purpose = "Convert the interface of a class into another interface clients " +
        "expect. Adapter lets classes work together that couldn't otherwise " +
        "because of incompatible interfaces.",
    alsoKnown = {"Wrapper"},
    related = {BridgePattern.class, DecoratorPattern.class, ProxyPattern.class})
public @interface AdapterPattern {
  Class[] participants() default {};

  String comment() default "";

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Adapter {
    Class[] participants() default {};

    String comment() default "";

    Variation value() default Variation.OBJECT;
  }

  /**
   * We would hardly ever use this annotation as the adaptee is
   * usually not aware that he is being adapted.
   */
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Adaptee {
    Class[] participants() default {};

    String comment() default "";
  }

  public enum Variation {
    OBJECT,
    CLASS,
    /**
     * See http://www.javaspecialists.eu/archive/Issue108.html
     */
    DYNAMIC
  }
}
