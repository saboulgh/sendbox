package org.example;

import org.example.composite.Adder;
import org.example.composite.Constant;
import org.example.composite.Expression;
import org.example.composite.Subtracter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompositeTest {
    @Test
    public void constanteTest() {
        double testValue = 3.0;
        Expression expression = new Constant(testValue);

        assertEquals(testValue, expression.getValue(), 0.0);
    }

    @Test
    public void testAdder() {

        Expression leftValue = new Constant(3.0);
        Expression rightValue = new Constant(4.0);

        Expression expression = new Adder(leftValue, rightValue);

        assertEquals(leftValue.getValue() + rightValue.getValue(), expression.getValue(), 0.0);
    }

    @Test
    public void testSubtracter() {

        Expression leftValue = new Constant(3.0);
        Expression rightValue = new Constant(4.0);

        Expression expression = new Subtracter(leftValue, rightValue);

        assertEquals(leftValue.getValue() - rightValue.getValue(), expression.getValue(), 0.0);
    }
}
