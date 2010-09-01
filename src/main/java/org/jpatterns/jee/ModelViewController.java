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
 * <p/>
 * <img src="http://www.jpatterns.org/uml/ee/MVCStructure.gif"/>
 * <p/>
 *
 * @author Marco Tedone
 * @since 2010-08-21
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@DesignPattern(type = Type.ENTERPRISE, related = {
    BusinessDelegatePattern.class})
public @interface ModelViewController {

  String comment() default "";

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  @DesignPattern(type = Type.ENTERPRISE)
  public @interface View {
    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  @DesignPattern(type = Type.ENTERPRISE)
  public @interface Controller {
    String comment() default "";
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Documented
  @DesignPattern(type = Type.ENTERPRISE)
  public @interface Model {
    String comment() default "";
  }

}
