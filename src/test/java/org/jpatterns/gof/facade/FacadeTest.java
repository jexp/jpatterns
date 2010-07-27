package org.jpatterns.gof.facade;

import static junit.framework.Assert.assertEquals;

public class FacadeTest {
  @FacadePattern
  public static class Tests {
    public void isEquals(Object expected, Object actual) {
      assertEquals(expected, actual);
    }
  }
}
