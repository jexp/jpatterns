package org.jpatterns.gof;

import org.jpatterns.*;

import java.lang.annotation.*;

/**
 * @author Heinz Kabutz
 * @since 2010-07-28
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.FIELD,
    ElementType.LOCAL_VARIABLE})
@Documented
@DesignPattern(type = Type.STRUCTURAL)
public @interface ProxyPattern {
  Variation variation() default Variation.STATIC_MANUAL;

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Subject {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface RealSubject {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = ElementType.TYPE)
  @Documented
  public @interface Proxy {
  }

  @Retention(value = RetentionPolicy.RUNTIME)
  @Target(value = {ElementType.TYPE, ElementType.FIELD,
      ElementType.LOCAL_VARIABLE})
  @Documented
  public @interface Client {
  }

  public static enum Variation {
    STATIC_MANUAL, STATIC_GENERATED, DYNAMIC
  }

  public static enum Type {
    VIRTUAL, REMOTE, PROTECTION
  }
}
