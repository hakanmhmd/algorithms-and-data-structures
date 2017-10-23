package DesignPatterns.tests;

import DesignPatterns.composite.*;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.views.DocumentView;

import static org.junit.Assert.assertEquals;

/**
 * Created by hakanmehmed on 03/07/2017.
 */
public class CompositeTest {

    @Test
    public void testConstant() {
        double testValue = 3.0;
        Expression e = new Constant(testValue);
        assertEquals(testValue, e.getValue(), 0.0);

    }

    @Test
    public void testAdder() {
        double valueOne = 2.0;
        double valueTwo = 8.0;

        Expression e = new Adder(new Constant(valueOne), new Constant(valueTwo));
        assertEquals((valueOne + valueTwo), e.getValue(), 0.0);
    }

    @Test
    public void testSubtractor() {
        double valueOne = 2.0;
        double valueTwo = 8.0;

        Expression e = new Subtractor(new Constant(valueOne), new Constant(valueTwo));
        assertEquals((valueOne - valueTwo), e.getValue(), 0.0);
    }

    @Test
    public void testDivider() {
        double valueOne = 2.0;
        double valueTwo = 8.0;

        Expression e = new Divider(new Constant(valueOne), new Constant(valueTwo));
        assertEquals((valueOne / valueTwo), e.getValue(), 0.0);
    }

    @Test
    public void testMultiplie() {
        double valueOne = 2.0;
        double valueTwo = 8.0;

        Expression e = new Multiplier(new Constant(valueOne), new Constant(valueTwo));
        assertEquals((valueOne * valueTwo), e.getValue(), 0.0);
    }

    @Test
    public void testComplexExpression() {
        Expression e = new Divider(
                new Multiplier(
                        new Adder(new Constant(3), new Constant(5)),
                        new Constant(100)),
                new Adder(new Constant(2), new Constant(64)));

        assertEquals(12.121212, e.getValue(), 0.00001);
    }
}
