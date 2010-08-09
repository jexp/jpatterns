package org.jpatterns.gof;

import static junit.framework.Assert.assertSame;
import org.junit.Test;

/**
 * @author Alex Gout
 * @since 2010-08-08
 */
public class SingletonTest {
  @Test
  public void testSameInstance() {
    Singleton singleton = Singleton.getInstance();
    Singleton singleton2 = Singleton.getInstance();

    assertSame(singleton, singleton2);
  }
}
