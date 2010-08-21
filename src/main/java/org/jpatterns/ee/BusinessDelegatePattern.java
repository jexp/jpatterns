/**
 * 
 */
package org.jpatterns.ee;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.jpatterns.core.DesignPattern;
import org.jpatterns.core.Type;
import org.jpatterns.gof.FacadePattern;
import org.jpatterns.gof.AdapterPattern.Adapter;

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
@Target( { ElementType.TYPE })
@Documented
@DesignPattern(type = Type.ENTERPRISE, related = { Adapter.class,
		FacadePattern.class })
public @interface BusinessDelegatePattern {

	String comment() default "";

	@Retention(RetentionPolicy.RUNTIME)
	@Target( { ElementType.TYPE, ElementType.FIELD, ElementType.LOCAL_VARIABLE,
			ElementType.PARAMETER })
	@Documented
	@DesignPattern(type = Type.ENTERPRISE)
	public @interface BusinessDelegate {
		String comment() default "";
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target( { ElementType.TYPE, ElementType.FIELD, ElementType.LOCAL_VARIABLE,
			ElementType.PARAMETER })
	@Documented
	@DesignPattern(type = Type.ENTERPRISE)
	public @interface BusinessService {
		String comment() default "";
	}

}
