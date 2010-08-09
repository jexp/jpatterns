package org.jpatterns.gof.facade;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;

public class FacadeTest {
  @FacadePattern
  public static class Tests {
    public void isEquals(Object expected, Object actual) {
      assertEquals(expected, actual);
    }
  }

  @Test
  public void facadeProvidesIsEquals() {
    new Tests().isEquals(1, Integer.valueOf(1));
  }
}
