/**
 * 
 */
package org.jpatterns.jee;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.jpatterns.core.DesignPattern;
import org.jpatterns.core.Type;

/**
 * <b>Intent [Core J2EE Patterns, pg 391]:</b> Abstract and encapsulate all
 * access to the data source. The DAO manages the connection with the data
 * source to obtain and store data
 * <p/>
 * <img src="http://www.jpatterns.org/uml/ee/DaoStructure.gif"/>
 * <p/>
 * 
 * @author Marco Tedone
 * @since 2010-08-19
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@DesignPattern(type = Type.ENTERPRISE)
public @interface DaoPattern {

	String comment() default "";

	@Retention(value = RetentionPolicy.RUNTIME)
	@Target(value = { ElementType.TYPE, ElementType.FIELD,
			ElementType.LOCAL_VARIABLE, ElementType.PARAMETER })
	@Documented
	@DesignPattern(type = Type.ENTERPRISE)
	public @interface BusinessObject {
		String comment() default "";
	}

	@Retention(value = RetentionPolicy.RUNTIME)
	@Target(value = { ElementType.TYPE, ElementType.FIELD,
			ElementType.LOCAL_VARIABLE, ElementType.PARAMETER })
	@Documented
	@DesignPattern(type = Type.ENTERPRISE)
	public @interface Dao {
		String comment() default "";
	}

	@Retention(value = RetentionPolicy.RUNTIME)
	@Target(value = { ElementType.TYPE, ElementType.FIELD,
			ElementType.LOCAL_VARIABLE, ElementType.PARAMETER })
	@Documented
	@DesignPattern(type = Type.ENTERPRISE)
	public @interface DataSource {
		String comment() default "";

		// Giving users the possibility to specify which datasource they are using
		// might be useful for maintainance. The information is optional anyway
		DataSourceType dataSourceType() default DataSourceType.NOT_DOCUMENTED;
	}

	@Retention(value = RetentionPolicy.RUNTIME)
	@Target(value = { ElementType.TYPE, ElementType.FIELD,
			ElementType.LOCAL_VARIABLE, ElementType.PARAMETER })
	@Documented
	@DesignPattern(type = Type.ENTERPRISE)
	public @interface ValueObject {
		String comment() default "";
	}

	public enum DataSourceType {
		HIBERNATE, SPRING, ORACLE, DB2, MYSQL, SQLSERVER, SYBASE, BERKELEY, NOT_DOCUMENTED
	}

}
