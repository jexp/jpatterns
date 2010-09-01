package org.jpatterns.jee;

import junit.framework.Assert;
import org.junit.Test;

public class BusinessDelegateTest {

  public static final String OP1_RET_VALUE = "operation1";
  public static final String OP2_RET_VALUE = "operation2";
  public static final String OP3_RET_VALUE = "operation3";

  @BusinessDelegatePattern.BusinessDelegate
  class BusinessDelegate {

    @BusinessDelegatePattern.BusinessService
    private final BusinessService1 service1 = new BusinessService1();

    @BusinessDelegatePattern.BusinessService
    private final BusinessService2 service2 = new BusinessService2();

    @BusinessDelegatePattern.BusinessService
    private final BusinessService3 service3 = new BusinessService3();

    public String operation1() {
      return service1.operation1();
    }

    public String operation2() {
      return service2.operation2();
    }

    public String operation3() {
      return service3.operation3();
    }

  }

  @BusinessDelegatePattern.BusinessService
  class BusinessService1 {

    public String operation1() {
      return OP1_RET_VALUE;
    }

  }

  @BusinessDelegatePattern.BusinessService
  class BusinessService2 {

    public String operation2() {
      return OP2_RET_VALUE;
    }

  }

  @BusinessDelegatePattern.BusinessService
  class BusinessService3 {

    public String operation3() {
      return OP3_RET_VALUE;
    }

  }

  @Test
  public void testBusinessDelegate() {

    String expectedOp1 = OP1_RET_VALUE;
    String expectedOp2 = OP2_RET_VALUE;
    String expectedOp3 = OP3_RET_VALUE;

    @BusinessDelegatePattern.BusinessDelegate(comment = "The Business Delegate "
        + "should hide the complexity of all the Business Services which it uses")
    BusinessDelegate bd = new BusinessDelegate();

    String actualOp1 = bd.operation1();

    Assert.assertEquals("The actual " + actualOp1 + " and expected "
        + expectedOp1 + " are not the same", expectedOp1, actualOp1);

    String actualOp2 = bd.operation2();
    Assert.assertEquals("The actual " + actualOp2 + " and expected "
        + expectedOp2 + " are not the same", expectedOp2, actualOp2);

    String actualOp3 = bd.operation3();
    Assert.assertEquals("The actual " + actualOp3 + " and expected "
        + expectedOp3 + " are not the same", expectedOp3, actualOp3);

  }
}
