package org.jpatterns.gof.facade;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FacadeTest {
  @FacadePattern
  public static class Tests {
    public void isEquals(Object expected, Object actual) {
      assertEquals(expected, actual);
    }
  }

  @Test
  public void facadeProvidesIsEquals() {
      new Tests().isEquals(1,Integer.valueOf(1));
  }
}
