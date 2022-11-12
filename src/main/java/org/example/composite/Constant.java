package org.example.composite;

public class Constant implements Expression {

    private double value;
    public Constant(double testValue) {
        this.value = testValue;
    }

    @Override
    public double getValue() {
        return value;
    }
}
