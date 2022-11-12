package org.example.composite;

public class Adder extends BinaryExpression {


    public Adder(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public double getValue() {
        return getLeftExpression().getValue() + getRightExpression().getValue();
    }
}
