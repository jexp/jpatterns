package org.jpatterns.gof;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Heinz Kabutz
 * @since 2010-08-09
 */
public class AdapterTest {
  private static interface Singer {
    String sing();
  }

  private static class Soprano implements Singer {
    public String sing() {
      return "Soprano is singing";
    }
  }


  @AdapterPattern.Adaptee
  private static class Rapper {
    public String talk() {
      return "Vulgar lyrics deleted...";
    }
  }

  @AdapterPattern.Adapter(AdapterPattern.Variation.OBJECT)
  private static class RapperObjectAdapter implements Singer {
    private final Rapper rapper;

    public RapperObjectAdapter(Rapper rapper) {
      this.rapper = rapper;
    }

    public RapperObjectAdapter() {
      this(new Rapper());
    }

    public String sing() {
      return rapper.talk();
    }
  }

  @AdapterPattern.Adapter(value = AdapterPattern.Variation.CLASS,
      participants = {Rapper.class, Singer.class})
  private static class RapperClassAdapter extends Rapper
      implements Singer {
    public String sing() {
      return talk();
    }
  }

  @Test
  public void testRapperClassRapsInsteadOfSinging() {
    Singer rapperClassAdapter = new RapperClassAdapter();
    assertEquals("rapper talks", new Rapper().talk(), rapperClassAdapter.sing());
  }

  @Test
  public void testRapperObjectAdapterRapsInsteadOfSinging() {
    Singer rapperObjectAdapter = new RapperObjectAdapter(new Rapper());
    assertEquals("rapper talks", new Rapper().talk(), rapperObjectAdapter.sing());
  }
}
