package org.jpatterns.gof;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Alex Gout
 * @since 2010-09-09
 */
public class BuilderTest {
  @BuilderPattern.Product
  private static class Guitar {
    private String neck;
    private String elements;
    private String model;

    public void setNeck(String _neck) {
      this.neck = _neck;
    }

    public void setElements(String _elements) {
      this.elements = _elements;
    }

    public void setModel(String _model) {
      this.model = _model;
    }

    @Override
    public String toString() {
      return this.model + ";" + this.neck + ";" + this.elements;
    }
  }

  @BuilderPattern.Builder(participants = {Guitar.class, GuitarMaker.class})
  private static abstract class GuitarBuilder {
    protected Guitar guitar;

    public Guitar getGuitar() {
      return this.guitar;
    }

    public void createGuitar() {
      this.guitar = new Guitar();
    }

    public abstract void buildNeck();

    public abstract void buildModel();

    public abstract void buildElements();
  }

  @BuilderPattern.ConcreteBuilder
  private static class SteviesGuitarBuilder extends GuitarBuilder {

    @Override
    public void buildNeck() {
      guitar.setNeck("maple/Pau Ferro");
    }

    @Override
    public void buildModel() {
      guitar.setModel("Stratocaster");
    }

    @Override
    public void buildElements() {
      guitar.setElements("SSS");
    }
  }

  @BuilderPattern.ConcreteBuilder
  private static class AngusGuitarBuilder extends GuitarBuilder {

    @Override
    public void buildNeck() {
      this.guitar.setNeck("mahogany/rosewood");
    }

    @Override
    public void buildModel() {
      this.guitar.setModel("SG");
    }

    @Override
    public void buildElements() {
      this.guitar.setElements("HH");
    }
  }

  @BuilderPattern.Director
  private static class GuitarMaker {
    private GuitarBuilder guitarBuilder;

    public void setGuitarBuilder(GuitarBuilder _guitarBuilder) {
      this.guitarBuilder = _guitarBuilder;
    }

    public Guitar getGuitar() {
      return guitarBuilder.getGuitar();
    }

    public void buildGuitar() {
      this.guitarBuilder.createGuitar();
      this.guitarBuilder.buildModel();
      this.guitarBuilder.buildNeck();
      this.guitarBuilder.buildElements();
    }
  }


  @Test
  public void testBuilderStevieGuitar() {
    GuitarMaker guitarMaker = new GuitarMaker();
    guitarMaker.setGuitarBuilder(new SteviesGuitarBuilder());

    guitarMaker.buildGuitar();
    Guitar guitar = guitarMaker.getGuitar();

    assertEquals("Stratocaster;maple/Pau Ferro;SSS", guitar.toString());
  }

  @Test
  public void testBuilderAngusGuitar() {
    GuitarMaker guitarMaker = new GuitarMaker();
    guitarMaker.setGuitarBuilder(new AngusGuitarBuilder());

    guitarMaker.buildGuitar();
    Guitar guitar = guitarMaker.getGuitar();

    assertEquals("SG;mahogany/rosewood;HH", guitar.toString());
  }
}
