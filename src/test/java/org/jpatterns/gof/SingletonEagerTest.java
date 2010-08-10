package org.jpatterns.gof;

import static junit.framework.Assert.assertNotNull;
import org.junit.Test;

public class SingletonEagerTest {
  @SingletonPattern.Singleton(variation = SingletonPattern.Variation.EAGER)
  public static class EagerSingleton {
    private final static EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {
    }

    @SingletonPattern.SingletonMethod
    public static EagerSingleton getInstance() {
      return INSTANCE;
    }
  }

  @Test
  public void testEagerness() {
    assertNotNull(EagerSingleton.INSTANCE);
    assertNotNull(EagerSingleton.getInstance());
  }
}
