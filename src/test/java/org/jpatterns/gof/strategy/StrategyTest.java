package org.jpatterns.gof.strategy;

import java.util.zip.Adler32;


public class StrategyTest {
  @StrategyPattern
  private static interface Checksum {
    public void update(int b);
    public void update(byte[] b, int off, int len);
    public long getValue();
    public void reset();
  }

  @StrategyPattern(role = StrategyRole.CONCRETE_STRATEGY)
  private static class MyAdler32 implements Checksum {
    private final Adler32 delegate = new Adler32();
    public void update(int b) {
      delegate.update(b);
    }
    public void update(byte[] b, int off, int len) {
      delegate.update(b, off, len);
    }
    public void update(byte[] b) {
      delegate.update(b);
    }
    public void reset() {
      delegate.reset();
    }
    public long getValue() {
      return delegate.getValue();
    }
  }
}
