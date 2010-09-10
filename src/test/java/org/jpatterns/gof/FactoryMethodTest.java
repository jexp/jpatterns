package org.jpatterns.gof;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Alex Gout
 * @since 2010-09-10
 */
public class FactoryMethodTest {

  @FactoryMethodPattern.Product(participants = VehicleFactory.class)
  private static interface Vehicle {
    public String echo();
  }

  @FactoryMethodPattern.Creator(participants = Vehicle.class)
  private static interface VehicleFactory {
    public Vehicle createVehicle();
  }

  @FactoryMethodPattern.ConcreteProduct
  private static class Car implements Vehicle {

    public String echo() {
      return "Car!";
    }
  }

  @FactoryMethodPattern.ConcreteCreator
  private static class CarFactory implements VehicleFactory {

    public Vehicle createVehicle() {
      return new Car();
    }
  }

  @FactoryMethodPattern.ConcreteProduct
  private static class Bike implements Vehicle {

    public String echo() {
      return "Bike!";
    }
  }

  @FactoryMethodPattern.ConcreteCreator
  private static class BikeFactory implements VehicleFactory {

    public Vehicle createVehicle() {
      return new Bike();
    }
  }

  @Test
  public void testCarFactory() {
    VehicleFactory factory = new CarFactory();
    Vehicle vehicle = factory.createVehicle();

    assertEquals("Car!", vehicle.echo());
  }

  @Test
  public void testBikeFactory() {
    VehicleFactory factory = new BikeFactory();
    Vehicle vehicle = factory.createVehicle();

    assertEquals("Bike!", vehicle.echo());
  }


}
