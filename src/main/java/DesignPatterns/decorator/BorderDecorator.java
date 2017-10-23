package DesignPatterns.decorator;

/**
 * Created by hakanmehmed on 04/07/2017.
 */
public class BorderDecorator extends Decorator {
    public BorderDecorator(GraphicalComponent next) {
        super(next);
    }

    @Override
    public void paint() {
        super.paint();
        System.out.println("Border rendered here...");
    }
}
