package org.jpatterns.plopd;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;

public class NullObjectTest {
  @NullObjectPattern.AbstractObject
  private static interface Policy {
    float calculateInterest();
  }

  @NullObjectPattern.NullObject
  private static class NullPolicy implements Policy {
    public float calculateInterest() {
      return 0.0f;
    }
  }

  @NullObjectPattern.RealObject
  private static class RealPolicy implements Policy {
    public float calculateInterest() {
      return 12.4f;
    }
  }

  @Test
  public void calculatingInterestWithNullObject() {
    Policy policy = new NullPolicy();
    assertEquals(0.0f, policy.calculateInterest());
  }

  @Test
  public void calculatingInterestWithRealObject() {
    Policy policy = new RealPolicy();
    assertEquals(12.4f, policy.calculateInterest(), 0.01f);
  }
}
