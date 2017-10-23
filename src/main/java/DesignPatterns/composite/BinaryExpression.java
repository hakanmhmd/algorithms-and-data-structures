package DesignPatterns.composite;

/**
 * Created by hakanmehmed on 03/07/2017.
 */
public abstract class BinaryExpression implements Expression {
    protected Expression right;
    protected Expression left;

    public BinaryExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }
}
