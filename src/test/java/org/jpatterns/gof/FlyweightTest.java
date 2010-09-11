package org.jpatterns.gof;

import org.junit.Test;

import java.awt.*;
import java.lang.ref.WeakReference;
import java.util.*;

import static junit.framework.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * @author Alex Gout
 * @since 2010-09-10
 */
public class FlyweightTest {
  enum AlienRace {
    Aldebarans, Bartledanians, Grebulons, Krikkiters, Shaltanacs, Poghrils, Humans
  }

  enum Location {
    Argabuthon, EroticonVI, Gagrakacka, Krikkit, Magrathea, NowWhat, ViltvodleVI, Vod, Xaxis
  }

  @FlyweightPattern.Flyweight(participants = {AnonymousAlien.class, KnownAlien.class})
  private interface Alien {
    String getName();
  }


  @FlyweightPattern.ConcreteFlyweight(participants = {Alien.class, KnownAlien.class})
  @FlyweightPattern.FlyweightFactory(participants = {Alien.class, KnownAlien.class})
  private static class AnonymousAlien implements Alien {
    private static final Map<Alien, WeakReference<Alien>> anonymousAliens = new HashMap<Alien, WeakReference<Alien>>();

    private Color color;
    private AlienRace alienRace;
    private Location approximatePlaceOfBirth;

    private AnonymousAlien(Color _color, AlienRace _alienRace, Location _approximatePlaceOfBirth) {
      this.color = _color;
      this.alienRace = _alienRace;
      this.approximatePlaceOfBirth = _approximatePlaceOfBirth;
    }

    private static Alien getAnonymousAlienForKnownData(Color _color, AlienRace _race, Location _placeOfBirth) {
      Alien tmp = new AnonymousAlien(_color, _race, _placeOfBirth);

      WeakReference<Alien> ref = anonymousAliens.get(tmp);

      Alien alien = null;
      if (ref == null) {
        alien = tmp;
        anonymousAliens.put(alien, new WeakReference<Alien>(alien));
      } else {
        alien = ref.get();
      }
      return alien;
    }

    @Override
    public boolean equals(Object _object) {
      if (_object == this) {
        return true;
      }
      if (!(_object instanceof AnonymousAlien)) {
        return false;
      }
      AnonymousAlien that = (AnonymousAlien) _object;
      return (this.color == that.color) && (this.alienRace == that.alienRace) && (this.approximatePlaceOfBirth == that.approximatePlaceOfBirth);
    }

    @Override
    public int hashCode() {
      return (this.color.hashCode() * 13 + this.alienRace.hashCode() * 31) * this.approximatePlaceOfBirth.hashCode() * 11;
    }

    public String getName() {
      return "anonymous";
    }
  }

  @FlyweightPattern.UnsharedConcreteFlyweight(participants = {Alien.class, AnonymousAlien.class})
  private static class KnownAlien implements Alien {
    private String name;
    private AlienRace alienRace;

    private KnownAlien(String _name, AlienRace _alienRace) {
      this.name = _name;
      this.alienRace = _alienRace;
    }

    public String getName() {
      return this.name;
    }

    public AlienRace getAlienRace() {
      return this.alienRace;
    }
  }

  @Test
  public void testAnonymousAlien() {
    Alien alien = AnonymousAlien.getAnonymousAlienForKnownData(Color.BLUE, AlienRace.Krikkiters, Location.EroticonVI);
    Alien otherAlienSame = AnonymousAlien.getAnonymousAlienForKnownData(Color.BLUE, AlienRace.Krikkiters, Location.EroticonVI);
    Alien otherAlienOther = AnonymousAlien.getAnonymousAlienForKnownData(Color.YELLOW, AlienRace.Krikkiters, Location.EroticonVI);

    assertTrue(AnonymousAlien.anonymousAliens.size() == 2);
    assertSame(otherAlienSame, alien);
    assertNotSame(otherAlienOther, alien);
  }
}
