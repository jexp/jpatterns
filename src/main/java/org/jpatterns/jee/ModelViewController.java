package org.jpatterns.jee;

import org.jpatterns.core.*;

import java.lang.annotation.*;

/**
 * <b> Intent: The Model View Controller (MVC) pattern divides an application in
 * three components: The View, the Controller and the Model.</b>
 * <ul>
 * <li><b>The View</b> presents data to clients</li>
 * <li><b>The Controller</b> handles client's requests, uses the Model to get
 * things done and dispatches to the appropriate view a response to the request
 * (this response might contain objects from the Model)</li>
 * <li><b>The Model</b> wraps the logic and the domain model of the application,
 * offering both services and objects to the view</li>.
 * </ul>
 *
 * <img src="http://www.jpatterns.org/uml/ee/MVCStructure.gif"/>
 *
 *
 * @author Marco Tedone
 * @since 2010-08-21
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@DesignPattern(source = Source.Other,
    type = Type.ENTERPRISE)
public @interface ModelViewController {
  Class[] participants() default {};

  String comment() default "";

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface View {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Controller {
    Class[] participants() default {};

    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  public @interface Model {
    Class[] participants() default {};

    String comment() default "";
  }
}