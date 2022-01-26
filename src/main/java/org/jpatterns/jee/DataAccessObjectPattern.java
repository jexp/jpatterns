/**
 *
 */
package org.jpatterns.jee;

import org.jpatterns.core.*;

import java.lang.annotation.*;

/**
 * <b>Intent [Core J2EE Patterns, pg 391]:</b> Abstract and encapsulate all
 * access to the data source. The DAO manages the connection with the data
 * source to obtain and store data
 * <p/>
 * <img alt="DAO Structure" src="http://www.jpatterns.org/uml/ee/DaoStructure.gif">
 * <p/>
 *
 * @author Marco Tedone
 * @since 2010-08-19
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@DesignPattern(source = Source.CoreJ2EE,
    type = Type.ENTERPRISE)
public @interface DataAccessObjectPattern {
  Class[] participants() default {};

  String comment() default "";

  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.TYPE, ElementType.FIELD,
      ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
  @Documented
  public @interface BusinessObject {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.TYPE, ElementType.FIELD,
      ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
  @Documented
  public @interface Dao {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.TYPE, ElementType.FIELD,
      ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
  @Documented
  public @interface DataSource {
    Class[] participants() default {};

    String comment() default "";

    // Giving users the possibility to specify which datasource they are using
    // might be useful for maintainance. The information is optional anyway

    DataSourceType dataSourceType() default DataSourceType.UNDEFINED;
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.TYPE, ElementType.FIELD,
      ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
  @Documented
  public @interface ValueObject {
    Class[] participants() default {};

    String comment() default "";
  }

  public enum DataSourceType {
    HIBERNATE, SPRING, ORACLE, DB2, MYSQL, SQLSERVER, SYBASE, BERKELEY,
    UNDEFINED
  }

}
