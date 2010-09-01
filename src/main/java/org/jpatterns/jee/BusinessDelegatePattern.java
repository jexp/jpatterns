/**
 *
 */
package org.jpatterns.jee;

import org.jpatterns.core.*;
import org.jpatterns.gof.AdapterPattern.Adapter;
import org.jpatterns.gof.FacadePattern;

import java.lang.annotation.*;

/**
 * <b>Intent [Core J2EE Patterns, pg 249]:</b> use a BusinessDelegate to reduce
 * coupling between presentation-tier clients and business services. The
 * BusinessDelegate hides the underlying implementation details of the business
 * service [...].
 * <p/>
 * <img src="http://www.jpatterns.org/uml/ee/BusinessDelegateStructure.gif"/>
 * <p/>
 *
 * @author Marco Tedone
 * @since 2010-08-21
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@DesignPattern(type = Type.ENTERPRISE, related = {Adapter.class,
    FacadePattern.class})
public @interface BusinessDelegatePattern {

  String comment() default "";

  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.TYPE, ElementType.FIELD, ElementType.LOCAL_VARIABLE,
      ElementType.PARAMETER})
  @Documented
  @DesignPattern(type = Type.ENTERPRISE)
  public @interface BusinessDelegate {
    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.TYPE, ElementType.FIELD, ElementType.LOCAL_VARIABLE,
      ElementType.PARAMETER})
  @Documented
  @DesignPattern(type = Type.ENTERPRISE)
  public @interface BusinessService {
    String comment() default "";
  }

}
