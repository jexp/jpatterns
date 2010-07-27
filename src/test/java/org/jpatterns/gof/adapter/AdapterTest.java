package org.jpatterns.gof.adapter;

import static org.jpatterns.gof.adapter.AdapterVariation.CLASS;

public class AdapterTest {
  private static interface Singer {
    String sing();
  }

  private static class Soprano implements Singer {
    public String sing() {
      return "Soprano is singing";
    }
  }

  private static class Rapper {
    public String talk() {
      return "Vulgar lyrics deleted...";
    }
  }

  @AdapterPattern
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

  @AdapterPattern(variation = CLASS, role = AdapterRole.ADAPTER,
      participants = {Rapper.class, Singer.class})
  private static class RapperClassAdapter extends Rapper
      implements Singer {
    public String sing() {
      return talk();
    }
  }
}