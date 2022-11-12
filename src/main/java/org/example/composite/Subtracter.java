package org.example.composite;

public class Subtracter extends BinaryExpression {

    public Subtracter(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public double getValue() {
        return getLeftExpression().getValue() - getRightExpression().getValue();
    }
}
