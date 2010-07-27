package org.jpatterns.gof.proxy;

public class ProxyTest {
  private static class Norwegian {
    @ProxyPattern(role = ProxyRole.CLIENT)
    private final Lutefisk lutefisk = new LutefiskProxy();
  }

  @ProxyPattern(role = ProxyRole.SUBJECT)
  private static interface Lutefisk {
    public void eat();
  }

  @ProxyPattern(role = ProxyRole.PROXY,
      participants = {Lutefisk.class, LutefiskImpl.class})
  public static class LutefiskProxy implements Lutefisk {
    private Lutefisk realSubject;

    public void eat() {
      if (realSubject == null) {
        realSubject = new LutefiskImpl();
      }
      realSubject.eat();
    }
  }

  @ProxyPattern(role = ProxyRole.REAL_SUBJECT)
  private static class LutefiskImpl implements Lutefisk {
    public void eat() {
      System.out.println("don't");
    }
  }

}
