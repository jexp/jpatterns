package org.jpatterns.gof;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * @author Alex Gout
 * @since 2010-09-09
 */

public class ChainOfResponsibilityTest {
  private OrderHandler regularOrderHandler;
  private OrderHandler bigOrderHandler;
  private OrderHandler hugeOrderHandler;


  private static class Order {
    float orderAmount;
    String description;

    private Order(float orderAmount, String description) {
      this.orderAmount = orderAmount;
      this.description = description;
    }
  }

  @ChainOfResponsibilityPattern.Handler
  private static abstract class OrderHandler {
    protected OrderHandler successor;

    public String handleOrder(Order _order) {
      if (canHandle(_order)) {
        return processOrder(_order);
      } else {
        return this.successor.handleOrder(_order);
      }
    }

    protected abstract boolean canHandle(Order _order);

    protected abstract String processOrder(Order _order);

    public void setSuccessor(OrderHandler _handler) {
      this.successor = _handler;
    }
  }

  @ChainOfResponsibilityPattern.ConcreteHandler
  private static class RegularOrderHandler extends OrderHandler {
    private static final float MAX_AMOUNT = 100.00f;

    @Override
    protected boolean canHandle(Order _order) {
      return Float.compare(MAX_AMOUNT, _order.orderAmount) >= 0;
    }

    @Override
    protected String processOrder(Order _order) {
      return _order.description + " handled by RegularOrderHandler";
    }
  }

  @ChainOfResponsibilityPattern.ConcreteHandler
  private static class BigOrderHandler extends OrderHandler {
    private static final float MAX_AMOUNT = 10000.00f;

    @Override
    protected boolean canHandle(Order _order) {
      return Float.compare(MAX_AMOUNT, _order.orderAmount) >= 0;
    }

    @Override
    protected String processOrder(Order _order) {
      return _order.description + " handled by BigOrderHandler";
    }
  }

  @ChainOfResponsibilityPattern.ConcreteHandler
  private static class HugeOrderHandler extends OrderHandler {
    @Override
    protected boolean canHandle(Order _order) {
      return true;
    }

    @Override
    protected String processOrder(Order _order) {
      return _order.description + " handled by HugeOrderHandler";
    }
  }


  @Before
  public void initializeHandlers() {
    this.regularOrderHandler = new RegularOrderHandler();
    this.bigOrderHandler = new BigOrderHandler();
    this.hugeOrderHandler = new HugeOrderHandler();
    this.regularOrderHandler.setSuccessor(this.bigOrderHandler);
    this.bigOrderHandler.setSuccessor(this.hugeOrderHandler);
  }


  @Test
  public void testSmallOrder() {
    Order order = new Order(10, "smallOrder");
    String handlerResponse = this.regularOrderHandler.handleOrder(order);
    assertEquals("smallOrder handled by RegularOrderHandler", handlerResponse);
  }

  @Test
  public void testBigOrder() {
    Order order = new Order(1000, "bigOrder");
    String handlerResponse = this.regularOrderHandler.handleOrder(order);
    assertEquals("bigOrder handled by BigOrderHandler", handlerResponse);
  }

  @Test
  public void testHugeOrder() {
    Order order = new Order(100000, "hugeOrder");
    String handlerResponse = this.regularOrderHandler.handleOrder(order);
    assertEquals("hugeOrder handled by HugeOrderHandler", handlerResponse);
  }
}

