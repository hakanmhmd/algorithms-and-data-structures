package DesignPatterns.composite;

/**
 * Created by hakanmehmed on 03/07/2017.
 */
public class Constant implements Expression{
    private double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return this.value;
    }
}
