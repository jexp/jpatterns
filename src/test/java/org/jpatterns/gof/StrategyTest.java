package org.jpatterns.gof;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.zip.Adler32;

/**
 * @author Heinz Kabutz
 * @since 2010-08-09
 */
public class StrategyTest {
  @StrategyPattern.Strategy
  private static interface Checksum {
    public void update(int b);

    public void update(byte[] b);

    public void update(byte[] b, int off, int len);

    public long getValue();

    public void reset();
  }

  @StrategyPattern.ConcreteStrategy
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

  @StrategyPattern.ConcreteStrategy
  private static class Heinz57 implements Checksum {
    private long value = 57;

    public void update(int b) {
      value += b * 57;
    }

    public void update(byte[] b, int off, int len) {
      for (int i = 0; i < len; i++) {
        update(b[i + off]);
      }
    }

    public void update(byte[] b) {
      for (byte b1 : b) {
        update(b1);
      }
    }

    public void reset() {
      value = 57;
    }

    public long getValue() {
      return value;
    }
  }

  @Test
  public void adler32StrategyWorks() {
    final Checksum checksum = new MyAdler32();
    byte[] bytes = {1, 2, 4, 8, 16};
    for (byte value : bytes) {
      checksum.update(value);
    }
    final long crc = checksum.getValue();
    checksum.reset();
    checksum.update(bytes);
    assertEquals(crc, checksum.getValue());
  }
}
