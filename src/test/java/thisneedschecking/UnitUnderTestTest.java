package thisneedschecking;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitUnderTestTest {

  @Test
  public void testAddingOneAndOne() {
    int result = UnitUnderTest.add(1, 1);
    Assert.assertEquals("one plus one should be 2!", 2, result);
  }

  @Test
  public void testMultiplyingTwoByTwo() {
    int result = UnitUnderTest.multiply(2, 2);
    Assert.assertEquals("2 * 2 should be 4", 4, result);
  }

  @Test(expected = ArithmeticException.class)
  public void testDivideByZero() {
    int result = UnitUnderTest.divide(1, 0);
//    Assert.fail("Should have thrown an exception");
  }
}