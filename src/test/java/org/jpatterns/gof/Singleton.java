package org.jpatterns.gof;

/**
 * @author Alex Gout
 * @since 2010-08-09
 */
@SingletonPattern(variation = SingletonPattern.Variation.EAGER)
public class Singleton {
  private static Singleton INSTANCE = new Singleton();

  private Singleton() {

  }

  @SingletonPattern.SingletonMethod
  public static final Singleton getInstance() {
    return INSTANCE;
  }
}
