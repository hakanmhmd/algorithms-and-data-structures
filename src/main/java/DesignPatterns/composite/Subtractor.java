package DesignPatterns.composite;

/**
 * Created by hakanmehmed on 03/07/2017.
 */
public class Subtractor extends BinaryExpression {
    public Subtractor(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double getValue() {
        return this.left.getValue() - this.right.getValue();
    }
}
