package org.jpatterns.gof;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * @author Heinz Kabutz
 * @since 2010-08-09
 */
public class ProxyTest {

  private static class Norwegian {
    @ProxyPattern.Client
    private final Lutefisk lutefisk;
    private boolean sick;

    private Norwegian(Lutefisk lutefisk) {
      this.lutefisk = lutefisk;
      lutefisk.storedBy(this);
    }

    public boolean isSick() {
      return sick;
    }

    public void becomeSick() {
      this.sick = true;
    }

    public void eatFisk() {
      lutefisk.eatenBy(this);
    }
  }

  @ProxyPattern.Subject(participants = {LutefiskProxy.class,
      LutefiskImpl.class})
  private interface Lutefisk {
    void eatenBy(Norwegian eater);

    void storedBy(Norwegian owner);
  }

  @ProxyPattern.Proxy(
      variation = ProxyPattern.Variation.STATIC_MANUAL,
      type = ProxyPattern.Type.VIRTUAL)
  public static class LutefiskProxy implements Lutefisk {
    private Lutefisk realSubject;

    public void eatenBy(Norwegian eater) {
      if (realSubject == null) {
        realSubject = new LutefiskImpl();
      }
      realSubject.eatenBy(eater);
    }

    public void storedBy(Norwegian owner) {
      // nothing happens
    }
  }

  @ProxyPattern.Subject
  private static class LutefiskImpl implements Lutefisk {
    public void eatenBy(Norwegian eater) {
      eater.becomeSick();
    }

    public void storedBy(Norwegian owner) {
      owner.becomeSick();
    }
  }

  @Test
  public void norwegianGetSickWhenBuyingRealLutefisk() {
    Norwegian norwegian = new Norwegian(new LutefiskImpl());
    Lutefisk lutefisk = new LutefiskImpl();
    assertTrue("sick from storing", norwegian.isSick());
    norwegian.eatFisk();
    assertTrue("sick from eating", norwegian.isSick());
  }

  @Test
  public void norwegianGetSickWhenEatingLutefisk() {
    Norwegian norwegian = new Norwegian(new LutefiskProxy());
    assertFalse("not sick from storing", norwegian.isSick());
    norwegian.eatFisk();
    assertTrue("sick from eating", norwegian.isSick());
  }
}
