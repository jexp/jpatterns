package org.jpatterns.gof.proxy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * @author Heinz Kabutz
 * @since 2010-08-09
 */
public class ProxyTest {

  @ProxyPattern(role = ProxyRole.CLIENT)
  private static class Norwegian {
    private Lutefisk lutefisk;

    private boolean sick;

    public boolean isSick() {
      return sick;
    }

    public void becomeSick() {
      this.sick = true;
    }

    public void buy(Lutefisk lutefisk) {
      this.lutefisk = lutefisk;
      lutefisk.boughtBy(this);
    }

    public void eatFisk() {
      if (lutefisk == null)
        throw new IllegalStateException("Have not Lutefisk");
      lutefisk.eatenBy(this);
    }
  }

  @ProxyPattern(role = ProxyRole.SUBJECT)
  private interface Lutefisk {
    void boughtBy(Norwegian eater);

    void eatenBy(Norwegian eater);
  }

  @ProxyPattern(role = ProxyRole.PROXY,
      participants = {Lutefisk.class, LutefiskImpl.class})
  public static class LutefiskProxy implements Lutefisk {
    private Lutefisk realSubject;

    public void eatenBy(Norwegian eater) {
      if (realSubject == null) {
        realSubject = new LutefiskImpl();
      }
      realSubject.eatenBy(eater);
    }

    public void boughtBy(Norwegian eater) {
      // nothing happens
    }
  }

  @ProxyPattern(role = ProxyRole.REAL_SUBJECT)
  private static class LutefiskImpl implements Lutefisk {
    public void eatenBy(Norwegian eater) {
      eater.becomeSick();
    }

    public void boughtBy(Norwegian eater) {
      eater.becomeSick();
    }
  }

  @Test
  public void norwegianGetSickWhenBuyingRealLutefisk() {
    final Norwegian norwegian = new Norwegian();
    final Lutefisk lutefisk = new LutefiskImpl();
    norwegian.buy(lutefisk);
    assertTrue("sick from buying", norwegian.isSick());
    norwegian.eatFisk();
    assertTrue("sick from eating", norwegian.isSick());
  }

  @Test
  public void norwegianGetSickWhenEatingLutefisk() {
    final Norwegian norwegian = new Norwegian();
    final Lutefisk lutefisk = new LutefiskProxy();
    norwegian.buy(lutefisk);
    assertFalse("not sick from buying", norwegian.isSick());
    norwegian.eatFisk();
    assertTrue("sick from eating", norwegian.isSick());
  }
}
